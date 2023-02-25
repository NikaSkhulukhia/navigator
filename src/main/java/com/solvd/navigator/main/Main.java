package com.solvd.navigator.main;

import com.solvd.navigator.dao.ICarDao;
import com.solvd.navigator.dao.ICityDao;
import com.solvd.navigator.dao.IDirectionsDao;
import com.solvd.navigator.dao.IPublicTransportDao;
import com.solvd.navigator.dao.IPublicTransportDirectionsDao;
import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.dao.mybatis.CarImpl;
import com.solvd.navigator.dao.mybatis.CityImpl;
import com.solvd.navigator.dao.mybatis.DirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportDirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportImpl;
//import com.solvd.navigator.dao.mybatis.CarImpl;
import com.solvd.navigator.dao.mybatis.StreetImpl;
import com.solvd.navigator.dao.mybatis.StreetLocationImpl;
import com.solvd.navigator.model.Directions;
import com.solvd.navigator.model.StreetLocation;
import com.solvd.navigator.service.FloydService;
import com.solvd.navigator.service.FloydTimeService;
import com.solvd.navigator.service.TimeGraphService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {

		// Street Location Verified
		// Car verified
		// City verified
		// Directions verified
		// PublicTransport verified
		// PublicTransportDirections
		// Street Verified

		ICarDao carInst = new CarImpl();
		IStreetLocationDao streetLocation = new StreetLocationImpl();
		ICityDao city = new CityImpl();
		IDirectionsDao directions = new DirectionsImpl();
		IPublicTransportDao publicTransport = new PublicTransportImpl();
		IPublicTransportDirectionsDao publicTransportDirections = new PublicTransportDirectionsImpl();
		IStreetDao street = new StreetImpl();

		try {
			List<Directions> directionsTable = directions.selectAllEntity();
			HashMap neighbours = new HashMap();
			for (Directions directions2 : directionsTable) {
				// System.out.println(directions2);
				if (directions2.isTrafficLight() == false) {
					int a = directions2.getIdStreetLocation1();
					int b = directions2.getIdStreetLocation2();
					neighbours.put(a, b);
					System.out.println(a + "        " + b);
					System.out.println(neighbours);
				}

			}

		} catch (SQLException e1) {

		}

		// List<StreetLocation> allAdreses = strInst.selectAllEntity();

		// 1. ბაზიდან წამოვიღოთ ყველა წვერო თავისი კოორდინატებით.
		// 2. ამ კოორდინატებით დავითვალოთ დისტანციები, ყველა წვერო ყველა წვეროსთან
		// დისტანციებს ვითვლით მარტო მეზობელ წვეროებზე. (ანუ თუ navigatordb.directions
		// თეიბლი არ შეიცავს 2 წვეროს არ ვითვლით)
		// ამ დისტანციებს ვინახავთ 2 განზომილებიან მასივში int[][] graphDist
		int[][] graphDist = { { 0, 3, 6, Integer.MAX_VALUE }, { 3, 0, 2, 1 }, { 6, 2, 0, 4 },
				{ Integer.MAX_VALUE, 1, 4, 0 } };
		// veriko

		// 3. ბაზიდან წამოვიღოთ ყველა წვერო თავისი კოორდინატებით.
		// 4. ამ კოორდინატებით დავითვალოთ დროები, ყველა წვერო ყველა წვეროსთან
		// დროებს ვითვლით მარტო მეზობელ წვეროებზე. (ანუ თუ navigatordb.directions თეიბლი
		// არ შეიცავს 2 წვეროს არ ვითვლით)
		// დროს ვითვლით დისტანცია / არჩ. ტრანსპ. საშ. სიჩქარეზე +
		// navigatordb.directions-ში შუქნიშანი არის true 10 წუთი
		// ამ დროებს ვინახავთ 2 განზომილებიან მასივში int[][] graphTime
		// mirian

		int[][] graphTime = { { 0, 33, 6, Integer.MAX_VALUE }, { 33, 0, 22, 1 }, { 6, 22, 0, 4 },
				{ Integer.MAX_VALUE, 1, 4, 0 } };

		TimeGraphService tg = new TimeGraphService();
		TimeGraphService tc = new TimeGraphService();

		tc.initializeTimeMatrix("car");
		double[][] timeMatrix = tg.initializeTimeMatrix("car");
		System.out.println("---------------------------------");
		for (int i = 0; i < timeMatrix.length; i++) {
			for (int j = 0; j < timeMatrix[i].length; j++) {
				System.out.print(timeMatrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("---------------------------------");

		// 3. სკანერით ირჩევს იუზერი საწყისი ადრესის ინდექსს და საბოლოო ადრესის ინდექსს
		int i = 0;
		int j = 3;
		// saba
		// ტრანსპორტი
		// გთხოვთ აირჩიოთ სასურველი ტრანსპორტი: 1. ბასი 2. ქარი.
		// სკანერ: 1 2 სხვა რამეზე შეზღუდვა (3, 4 , სფგკჯსეკგჰს)

		// საწყისი ადრესი
		// ქალაქის არჩევა: 1. თბილისი , 2. ბათუმი
		// ჩამოწეროს არჩეული ქალაქების ადრესების სია: 1. პეკინის 7, 2. პეკინის 5.
		// შევინახოთ სადმე

		// საბოლოო ადრესი
		// ქალაქის არჩევა: 1. თბილისი , 2. ბათუმი
		// ჩამოწეროს არჩეული ქალაქების ადრესების სია: 1. პეკინის 7, 2. პეკინის 5.
		// შევინახოთ სადმე

		// ბაგი ბაზასთან და მაპერეთან - ყველა
		// ავტობუსის შეცვლის ლოგიკა - ნიკა

		FloydService fs = new FloydService();
		fs.setGraph(graphDist);
		fs.setStartIndex(i);
		fs.setEndIndex(j);
		fs.floydWarshall();
		System.out.println(fs.distRes());

		FloydService fsTime = new FloydService();

		// fsTime.setGraph(timeMatrix);
		// fsTime.setStartIndex(i);
		// fsTime.setEndIndex(j);
		// fsTime.floydWarshall();
		// System.out.println(fsTime.timeRes());

		FloydTimeService fsTime1 = new FloydTimeService();
		fsTime1.setGraph(timeMatrix);
		fsTime1.setStartIndex(0);
		fsTime1.setEndIndex(1);
		fsTime1.floydWarshall();
		System.out.println(fsTime1.timeRes());

	}
}