package HotelDataAnalysis.AirBnb;

import java.io.File;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.KeyValueGroupedDataset;
import org.apache.spark.sql.SparkSession;

import com.data.model.Analytic;

import scala.Tuple2;
import scala.Tuple3;

/**
 * Hello world!
 *
 */
public class AirBnbAnalyticJob {
	public static void main(String[] args) {
		String inputPath = args[0];
		String outputPath = args[1];

		SparkSession spark = SparkSession.builder().master("local").appName("DataAnalysis").getOrCreate();
		
		//Read input data from the files
		Dataset<Tuple2<String, String>> listings = spark.read().textFile(inputPath + File.separator + "listing.txt")
				.map(new RecordAssigner("LIST"), Encoders.tuple(Encoders.STRING(), Encoders.STRING()));
		
		
		Dataset<Tuple2<String, String>> calander = spark.read().textFile(inputPath + File.separator + "calendar.txt")
				.map(new RecordAssigner("CAL"), Encoders.tuple(Encoders.STRING(), Encoders.STRING()));
		
		
		Dataset<Tuple2<String, String>> review = spark.read().textFile(inputPath + File.separator + "review.txt")
				.map(new RecordAssigner("REV"), Encoders.tuple(Encoders.STRING(), Encoders.STRING()));
		
		//Group the data based on the listing Id
		final KeyValueGroupedDataset<String,Tuple2<String,String>> keyGroupedData = listings.union(calander).union(review).groupByKey(new Key(), Encoders.STRING());
		
		//Construct a Dataframe of Analytic objects which stores all the input read from the above files
		Dataset<Analytic> analyticInputs =keyGroupedData.mapGroups(new Aggregator(), Encoders.kryo(Analytic.class));
		
		// Generate new dataframe that will be used to do a groupByregion wise at later stage
		Dataset<Tuple2<String, Analytic>> groupedDataSet = analyticInputs.flatMap(new RegionalData(), Encoders.tuple(Encoders.STRING(), Encoders.kryo(Analytic.class)));		
		
		// Group the data based on the regional Data namely city plus state
		final KeyValueGroupedDataset<String, Tuple2<String, Analytic>> keyGroupedDataSet = groupedDataSet.groupByKey(new RegionalKey(), Encoders.STRING());
		
		//Perform DataAnalysis Region wise and return results
		Dataset<Tuple3<String,String,String>> outputs = keyGroupedDataSet.flatMapGroups(new ResultAggregator(),Encoders.tuple(Encoders.STRING(),Encoders.STRING(),Encoders.STRING()));
		
		//Dump outputs to the output location
		outputs.withColumnRenamed("_1", "analytic").withColumnRenamed("_2", "output").write()
		.partitionBy("analytic", "output").text(outputPath);

	}
}
