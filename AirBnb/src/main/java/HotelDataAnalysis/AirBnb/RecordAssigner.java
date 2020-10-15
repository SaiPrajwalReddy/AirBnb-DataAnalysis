package HotelDataAnalysis.AirBnb;

import org.apache.spark.api.java.function.MapFunction;

import scala.Tuple2;

public class RecordAssigner implements MapFunction<String, Tuple2<String, String>> {

	/**
	 * Class that takes input record and assigns appropriate record type depending upon
	 * the file it is currently reading 
	 */
	private static final long serialVersionUID = 5254626864361200201L;
	String value = "";

	public RecordAssigner(String value) {		
		this.value = value;
	}

	public Tuple2<String, String> call(String rec) throws Exception {
		String key = rec.split("\\|")[0];
				
		rec = value+"|"+rec ;

		return new Tuple2<String, String>(key, rec);
	}

}
