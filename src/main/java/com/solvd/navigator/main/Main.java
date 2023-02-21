package com.solvd.navigator.main;

import com.solvd.navigator.dao.ICarDao;
import com.solvd.navigator.dao.IStreetDao;
//import com.solvd.navigator.dao.mybatis.CarImpl;
import com.solvd.navigator.dao.mybatis.StreetImpl;
import com.solvd.navigator.service.FloydService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);



    public static void main(String[] args) {


//        ICarDao carInst = new CarImpl();
        IStreetDao strInst = new StreetImpl();
        try {
            LOGGER.info(strInst.selectAllEntity());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 1. ბაზიდან წამოვიღოთ ყველა წვერო თავისი კოორდინატებით.
        // 2. ამ კოორდინატებით დავითვალოთ დისტანციები, ყველა წვერო ყველა წვეროსთან
        //      დისტანციებს ვითვლით მარტო მეზობელ წვეროებზე. (ანუ თუ navigatordb.directions თეიბლი არ შეიცავს 2 წვეროს არ ვითვლით)
        //      ამ დისტანციებს ვინახავთ 2 განზომილებიან მასივში int[][] graphDist
        int[][] graphDist = {
                {0, 3, 6, Integer.MAX_VALUE},
                {3, 0, 2, 1},
                {6, 2, 0, 4},
                {Integer.MAX_VALUE, 1, 4, 0}
        };

        // 3. ბაზიდან წამოვიღოთ ყველა წვერო თავისი კოორდინატებით.
        // 4. ამ კოორდინატებით დავითვალოთ დროები, ყველა წვერო ყველა წვეროსთან
        //      დროებს ვითვლით მარტო მეზობელ წვეროებზე. (ანუ თუ navigatordb.directions თეიბლი არ შეიცავს 2 წვეროს არ ვითვლით)
        //      დროს ვითვლით დისტანცია / არჩ. ტრანსპ. საშ. სიჩქარეზე + navigatordb.directions-ში შუქნიშანი არის true 10 წუთი
        //      ამ დროებს ვინახავთ 2 განზომილებიან მასივში int[][] graphTime
        int[][] graphTime = {
                {0, 33, 6, Integer.MAX_VALUE},
                {33, 0, 22, 1},
                {6, 22, 0, 4},
                {Integer.MAX_VALUE, 1, 4, 0}
        };

        // 3. სკანერით ირჩევს იუზერი საწყისი ადრესის ინდექსს და საბოლოო ადრესის ინდექსს
        int i = 3;
        int j = 0;

        FloydService fs = new FloydService();
        fs.setGraph(graphDist);
        fs.setStartIndex(i);
        fs.setEndIndex(j);
        fs.floydWarshall();
        System.out.println(fs.distRes());

        FloydService fsTime = new FloydService();
        fsTime.setGraph(graphTime);
        fsTime.setStartIndex(i);
        fsTime.setEndIndex(j);
        fsTime.floydWarshall();
        System.out.println(fsTime.timeRes());
    }
}