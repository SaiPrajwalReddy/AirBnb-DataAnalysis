# AirBnb-DataAnalysis
Analyzing the data of AirBnb using Apache Spark

# Technologies Used
  -	Apache Spark
  -	Java
  -	Avro

# What is this

	An Application built using Apache Spark that reads the datasets of Airbnb and generates the following statistics

# ListingsPerState
	Determines the total number of listings that are available at a state level. This will help business determine the areas where the number of listings are relatively less and take measures to improve business in these areas
# AvailabilityPerState
	Not all lisitings registered with AirBnb are available through out the year. These stats help determine the areas where availability of listings is lower, helping the business to focus on these areas to improve availability.
# OccupancyPerState
	These stats determine the occupancy rate for listings on a state level.Pulling the records with a low occupancy rate helps business to analyse reasons for lower occupancy and take appropriate steps to improve occupancy rate in these areas.
# RoomTypePerState
	Stats that reveal the total number of private rooms,shared rooms,Hotels etc present in a region
# ListingsPerHostPerState
	Stats that determine the number of listings a host has in a given state

# How do we run it?

The application expects there files as input namely
	- Lisiting.txt : contains information about listings
	- Calendar.txt : contains information about the days when a listing is avalibale
	- Review.txt : contains information about the customer reviews for each listing.

spark-submit -–master yarn --jars avro-1.1.0.jar,beanio-2.1.0.jar --class HotelDataAnalysis.AirBnb.App  AirBnb-0.0.1-SNAPSHOT.jar <inputDir containing the above mentioned files> < OutputLocation >


All the jars specified in the spark-submit command and the input dataset is available in this repo.
This project uses AVRO model objects for serialization and deserialization and the BeanIO for mapping records to objects. Hence these jars will be needed during run time and hence are provided in the –-jars option of spark submit command

