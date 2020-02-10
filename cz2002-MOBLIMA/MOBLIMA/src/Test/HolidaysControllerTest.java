/*package Test;

import java.io.File;
import java.util.ArrayList;

import Controller.*;
import static Controller.HolidaysController.FILENAME;

import Model.*;

public class HolidaysControllerTest {

    public static void main(String[] args) throws Exception {

        new File(FILENAME).delete();

        HolidaysController holidaysController = new HolidaysController();
        Holiday holiday = null;

        // creating test values + Testing HolidaysController.create()
        System.out.println(".....Testing HolidaysController.create()");
        holidaysController.create("2019-10-01");
        holidaysController.create("2019-11-01");
        readAllAndPrint(holidaysController.read());

        // testing HolidaysController.read()
        System.out.println(".....Testing HolidaysController.read()");
        readAllAndPrint(holidaysController.read());

        // testing HolidaysController.isHoliday()
        System.out.println(".....Testing HolidaysController.isHoliday()");
        holiday = new Holiday("2019-10-01");
        System.out.println(holiday.getHolidayDate() + " is a holiday: " + holidaysController.isHoliday(holiday.getHolidayDate()));
        holiday = new Holiday("2019-12-01");
        System.out.println(holiday.getHolidayDate() + " is a holiday: " + holidaysController.isHoliday(holiday.getHolidayDate()));

        // testing HolidaysController.delete()
        System.out.println(".....Testing HolidaysController.delete()");
        holidaysController.delete("2019-10-01");
        readAllAndPrint(holidaysController.read());
    }   

    public static void readAllAndPrint(ArrayList<Holiday> holidayListing){     
        holidayListing.forEach(n->System.out.println(n));
    }
}*/