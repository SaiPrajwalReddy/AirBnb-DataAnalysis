package HotelDataAnalysis.AirBnb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.spark.api.java.function.FlatMapGroupsFunction;

import com.data.model.Analytic;
import com.data.model.Listing;

import scala.Tuple2;
import scala.Tuple3;

public class ResultAggregator
		implements FlatMapGroupsFunction<String, Tuple2<String, Analytic>, Tuple3<String, String, String>> {

	/**
	 * Class used to perform data analysis region wise
	 */
	private static final long serialVersionUID = 8910996703858623721L;

	@Override
	public Iterator<Tuple3<String, String, String>> call(String key, Iterator<Tuple2<String, Analytic>> values)
			throws Exception {
		// TODO Auto-generated method stub
		List<Tuple3<String, String, String>> tuples = new ArrayList<>();
		Integer numberOfListingsPerKey = 0;

		double highAvailability = 0;
		double lowAvailability = 0;
		double perOfHighAvailability = 0;
		double perOfLowAvailability = 0;
		double occupancy = 0;
		double noOfHotelRooms = 0;
		double noOfSharedRooms = 0;
		double noOfPrivateRooms = 0;
		double noOfHomes = 0;
		double perOfHotelRooms = 0;
		double perOfSharedRooms = 0;
		double perOfPrivateRooms = 0;
		double perOfHomes = 0;
		double avgPricePerNight = 0;
		double pricePerNight = 0;
		double perOfOccuancy = 0;
		double multipleListings = 0;
		double singleListings = 0;
		double perMultipleListings = 0;
		double perSingleListings = 0;
		Set<String> hostIdSet = new HashSet<String>();

		while (values.hasNext()) {
			numberOfListingsPerKey++;
			Tuple2<String, Analytic> record = values.next();
			Analytic an = record._2;
			int size = an.getDataContainer().getCalendar().size();
			if (size == 0 || size > 60)
				highAvailability++;
			else
				lowAvailability++;

			int reviews = an.getDataContainer().getReview().size();

			occupancy = occupancy + reviews;

			for (Listing l : an.getDataContainer().getListing()) {
				if ("Entire home".equals(l.getRoomType())) {
					noOfHomes++;
				} else if ("Hotel room".equals(l.getRoomType())) {
					noOfHotelRooms++;
				} else if ("Private room".equals(l.getRoomType())) {
					noOfPrivateRooms++;
				} else if ("Shared room".equals(l.getRoomType())) {
					noOfSharedRooms++;
				}

				pricePerNight += l.getPrice();
				String hostId = l.getHostId().toString();

				if (hostIdSet.contains(hostId))
					multipleListings++;
				else {
					hostIdSet.add(hostId);
				}
			}

		}
		perOfHighAvailability = (highAvailability / numberOfListingsPerKey) * 100;
		perOfLowAvailability = (lowAvailability / numberOfListingsPerKey) * 100;
		perOfOccuancy = (occupancy / 365) * 100;
		perOfHotelRooms = (noOfHotelRooms / numberOfListingsPerKey) * 100;
		perOfSharedRooms = (noOfSharedRooms / numberOfListingsPerKey) * 100;
		perOfPrivateRooms = (noOfPrivateRooms / numberOfListingsPerKey) * 100;
		perOfHomes = (noOfHomes / numberOfListingsPerKey) * 100;
		avgPricePerNight = pricePerNight / numberOfListingsPerKey;
		singleListings = numberOfListingsPerKey - multipleListings;
		perMultipleListings = (multipleListings / numberOfListingsPerKey) * 100;
		perSingleListings = (singleListings / numberOfListingsPerKey) * 100;

		String availabilityPerState = key + "|" + highAvailability + "|" + perOfHighAvailability + "|" + lowAvailability
				+ "|" + perOfLowAvailability;

		String occupancyPerYear = key + "|" + occupancy + "|" + perOfOccuancy;

		String roomTypesPerState = key + "|" + noOfHomes + "|" + perOfHomes + "|" + noOfHotelRooms + "|"
				+ perOfHotelRooms + "|" + noOfPrivateRooms + "|" + perOfPrivateRooms + "|" + noOfSharedRooms + "|"
				+ perOfSharedRooms + "|" + avgPricePerNight + "|" + numberOfListingsPerKey;

		String typeOfListingsPerHost = key + "|" + singleListings + "|" + perSingleListings + "|" + multipleListings
				+ "|" + perMultipleListings;

		tuples.add(new Tuple3<String, String, String>("AirBnb", "ListingsPerState",
				key + "|" + numberOfListingsPerKey.toString()));
		tuples.add(new Tuple3<String, String, String>("AirBnb", "AvailabilityPerState", availabilityPerState));
		tuples.add(new Tuple3<String, String, String>("AirBnb", "OccupancyRatePerState", occupancyPerYear));
		tuples.add(new Tuple3<String, String, String>("AirBnb", "RoomTypePerState", roomTypesPerState));
		tuples.add(new Tuple3<String, String, String>("AirBnb", "ListingsPerHostPerState", typeOfListingsPerHost));
		return tuples.iterator();
	}

}
