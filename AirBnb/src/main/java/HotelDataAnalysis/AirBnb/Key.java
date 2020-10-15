package HotelDataAnalysis.AirBnb;

import org.apache.spark.api.java.function.MapFunction;

import scala.Tuple2;

public class Key implements MapFunction<Tuple2<String,String>,String> {


	/**
	 * The listing Id common in all the input files is used as a key
	 */
	private static final long serialVersionUID = -5093221981678861670L;

	public String call(Tuple2<String, String> value) throws Exception {
		// TODO Auto-generated method stub		
		return value._1;
	}

}
