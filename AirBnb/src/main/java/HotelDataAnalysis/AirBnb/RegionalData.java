package HotelDataAnalysis.AirBnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.api.java.function.FlatMapFunction;

import com.data.model.Analytic;
import com.data.model.DataContainer;
import com.data.model.Listing;

import scala.Tuple2;

public class RegionalData implements FlatMapFunction<Analytic, Tuple2<String, Analytic>> {

	/**
	 * Input : Analytic Object
	 * Returns: tuple key value pair where key is the combination of state and city and value is the analytic object
	 * This operation helps to group the data regional wise at later stages
	 */
	private static final long serialVersionUID = -1027706854539543437L;

	@Override
	public Iterator<Tuple2<String, Analytic>> call(Analytic value) throws Exception {
		// TODO Auto-generated method stub
		DataContainer dataContainer = value.getDataContainer();
		List<Listing> ls = dataContainer.getListing();
		List<Tuple2<String, Analytic>> tuples = new ArrayList<>();
		String key = "";		
			for (Listing rec : ls) {
				if(null != rec.getState() && null!= rec.getCity())
				{
					key = rec.getState().toString() + "|" + rec.getCity().toString();					
					 tuples.add(new Tuple2<String, Analytic>(key, value));
				}
			}
		return tuples.iterator();
	}

}
