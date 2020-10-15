package HotelDataAnalysis.AirBnb;

import org.apache.spark.api.java.function.MapFunction;

import com.data.model.Analytic;

import scala.Tuple2;

public class RegionalKey implements MapFunction<Tuple2<String, Analytic>, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5006503486218676864L;

	@Override
	public String call(Tuple2<String, Analytic> value) throws Exception {
		// TODO Auto-generated method stub		
		return value._1;
	}

}
