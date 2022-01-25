package scheduling;

import customer.Customer;
import employees.Hairdresser;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Scheduler {
    private static final String[] WORKING_DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public void scheduleSession(Customer customer, String hairdresserName, HashMap<String, Hairdresser> hairdressers){

        Hairdresser hairdresser = hairdressers.get(hairdresserName);

        hairdresser.getDaysAndHoursFree().remove(customer.getDesiredDay());

        System.out.println("You have just made an appointment with hairdresser " + hairdresser.getName() + " for customer " + customer.getName() + " for day " + customer.getDesiredDay() + " at the hour " + customer.getDesiredHour() +".");

        System.out.println("The free days of hairdresser " + hairdresser.getName() + " are now " + hairdresser.getDaysAndHoursFree());
    }

    public HashMap<String, Hairdresser> retrieveHairDressers(){

        System.out.println("Retrieving available hairdressers...");

        LinkedHashMap<String, Integer> johnSchedule = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> mayaSchedule = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> miaSchedule = new LinkedHashMap<>();

        LinkedHashMap<String, HashMap<String, Integer>> johnScheduleBusy = new LinkedHashMap<>();

        LinkedHashMap<String, HashMap<String, Integer>> mayaScheduleBusy = new LinkedHashMap<>();

        LinkedHashMap<String, HashMap<String, Integer>> miaScheduleBusy = new LinkedHashMap<>();

        HashMap<String, Hairdresser> retrievedHds = new HashMap<>();

        for (String day: WORKING_DAYS) {
            johnSchedule.put(day, ThreadLocalRandom.current().nextInt(8,19));
            mayaSchedule.put(day, ThreadLocalRandom.current().nextInt(8,19));
            miaSchedule.put(day, ThreadLocalRandom.current().nextInt(8,19));
        }


        Hairdresser one = new Hairdresser("John", "La Vitta Bella", johnSchedule);
        Hairdresser two = new Hairdresser("Maya", "Moderna Hair Style", mayaSchedule);
        Hairdresser three = new Hairdresser("Mia", "One Dream", miaSchedule);

        retrievedHds.put("John", one);
        retrievedHds.put("Maya", two);
        retrievedHds.put("Mia", three);

        System.out.println("Here are the available artists: ");

        for (String key: retrievedHds.keySet()) {
            System.out.println(retrievedHds.get(key));
        }

        return retrievedHds;

    }
}
