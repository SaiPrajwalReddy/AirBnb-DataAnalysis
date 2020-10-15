package HotelDataAnalysis.AirBnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.api.java.function.MapGroupsFunction;

import com.data.model.Analytic;
import com.data.model.Calendar;
import com.data.model.DataContainer;
import com.data.model.Listing;
import com.data.model.Review;

import scala.Tuple2;
public class Aggregator implements MapGroupsFunction<String, Tuple2<String, String>, Analytic> {

	/**
	 * Key : listing Id
	 * Returns : An analytic object constructed by binding data from all the input files read
	 */
	private static final long serialVersionUID = 4886011086133168812L;
	private InputDataParser parser = new InputDataParser();

	public Analytic call(String key, Iterator<Tuple2<String, String>> values) throws Exception {		
		Analytic analytic = new Analytic();
		List <Listing> listRec = new ArrayList<Listing>();
		List<Calendar> calRec = new ArrayList<Calendar>();
		List<Review> revRec = new ArrayList<Review>();
		
		DataContainer dataContainer = new DataContainer();
		while (values.hasNext()) {
			Tuple2<String, String> rec = values.next();

			String valueString = rec._2;

			String recType = valueString.split("\\|")[0];
			String record = valueString.replaceFirst(recType+"\\|","");

			if (recType.equals("LIST")) {
				
				Listing obj = (Listing)parser.unmarshall("LIST", record);
				listRec.add(obj);
				
				
			} else if (recType.equals("CAL")) {
				Calendar obj = (Calendar)parser.unmarshall("CAL", record); 
				calRec.add(obj);

			} else if (recType.equals("REV")) {
				Review obj = (Review)parser.unmarshall("REV", record);
				revRec.add(obj);
			}
		}
		dataContainer.setCalendar(calRec);
		dataContainer.setReview(revRec);
		dataContainer.setListing(listRec);
		analytic.setDataContainer(dataContainer);
						
		return analytic;
	}

}
