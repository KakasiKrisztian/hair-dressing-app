package setup;

import customer.Customer;
import employees.Hairdresser;
import scheduling.Scheduler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Setup {
    public void initApp(){

        Scanner sc = new Scanner(System.in);
        System.out.println( "Hello, please introduce your name:" );
        String name = sc.nextLine();

        Scheduler scheduler = new Scheduler();

        HashMap<String, Hairdresser> hairdressers = scheduler.retrieveHairDressers();

        String[] dayAndName = retrieveDayAndName(hairdressers, sc);

        int hour = retrieveHour(sc);

        Customer customer = new Customer(name, hour, dayAndName[1]);

        scheduler.scheduleSession(customer, dayAndName[0], hairdressers);


    }

    private String[] retrieveDayAndName(HashMap<String, Hairdresser> hairdressers, Scanner sc){

        String[] nameAndDay = new String[2];
        System.out.println( "Please introduce the name of the hairdresser you would like to make an appointment with:" );
        String hairdresserName = sc.nextLine();

        if (hairdressers.keySet().contains(hairdresserName)){
            System.out.println("Invalid day selected..");
            return retrieveDayAndName(hairdressers, sc);
        }

        nameAndDay[0] = hairdresserName;

        Hairdresser hairdresser = hairdressers.get(hairdresserName);

        System.out.println("Please introduce the day in which the appointment should be made: ");
        String day = sc.nextLine();

        if (hairdresser.getDaysAndHoursFree().containsKey(day)){
            System.out.println("Invalid day selected..");
            return retrieveDayAndName(hairdressers, sc);
        }

        nameAndDay[1] = day;
        return nameAndDay;
    }

    private int retrieveHour(Scanner sc){
        System.out.println( "Please introduce the hour at which the appointment should be made: " );
        int hour = 0;
        try {
            hour = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid hour selected..");
            return retrieveHour(sc);
        }

        return hour;
    }

}
