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
import com.solvd.navigator.service.FloydService;
import com.solvd.navigator.service.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

		int startIndex = 0;
		int endIndex = 0;

        try {
            UserInput userInput = new UserInput();
            userInput.input();
			startIndex = userInput.getStartAddressId();
			endIndex = userInput.getEndAddressId();
        } catch (SQLException e) {
            LOGGER.error("SQLException");
        }
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
            LOGGER.info(street.selectAllEntity());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            System.out.println(publicTransportDirections.selectAllEntity());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        // List<StreetLocation> allAdreses = strInst.selectAllEntity();

        // 1. ბაზიდან წამოვიღოთ ყველა წვერო თავისი კოორდინატებით.
        // 2. ამ კოორდინატებით დავითვალოთ დისტანციები, ყველა წვერო ყველა წვეროსთან
        // დისტანციებს ვითვლით მარტო მეზობელ წვეროებზე. (ანუ თუ navigatordb.directions
        // თეიბლი არ შეიცავს 2 წვეროს არ ვითვლით)
        // ამ დისტანციებს ვინახავთ 2 განზომილებიან მასივში int[][] graphDist
        int[][] graphDist = {{0, 3, 6, Integer.MAX_VALUE}, {3, 0, 2, 1}, {6, 2, 0, 4},
                {Integer.MAX_VALUE, 1, 4, 0}};
        // veriko

        // 3. ბაზიდან წამოვიღოთ ყველა წვერო თავისი კოორდინატებით.
        // 4. ამ კოორდინატებით დავითვალოთ დროები, ყველა წვერო ყველა წვეროსთან
        // დროებს ვითვლით მარტო მეზობელ წვეროებზე. (ანუ თუ navigatordb.directions თეიბლი
        // არ შეიცავს 2 წვეროს არ ვითვლით)
        // დროს ვითვლით დისტანცია / არჩ. ტრანსპ. საშ. სიჩქარეზე +
        // navigatordb.directions-ში შუქნიშანი არის true 10 წუთი
        // ამ დროებს ვინახავთ 2 განზომილებიან მასივში int[][] graphTime
        int[][] graphTime = {{0, 33, 6, Integer.MAX_VALUE}, {33, 0, 22, 1}, {6, 22, 0, 4},
                {Integer.MAX_VALUE, 1, 4, 0}};
        // mirian

        // 3. სკანერით ირჩევს იუზერი საწყისი ადრესის ინდექსს და საბოლოო ადრესის ინდექსს
        int i = 3;
        int j = 0;
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
        fs.setStartIndex(startIndex);
        fs.setEndIndex(endIndex);
        fs.floydWarshall();
        System.out.println(fs.distRes());

        FloydService fsTime = new FloydService();
        fsTime.setGraph(graphTime);
        fsTime.setStartIndex(startIndex);
        fsTime.setEndIndex(endIndex);
        fsTime.floydWarshall();
        System.out.println(fsTime.timeRes());
    }
}