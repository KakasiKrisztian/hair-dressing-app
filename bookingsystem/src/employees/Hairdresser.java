package employees;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Hairdresser {
    private String name;
    private String salonName;
    private LinkedHashMap<String, Integer> daysAndHoursFree;
//    private LinkedHashMap<String, HashMap<String, Integer>> busyHoursDaysAndCustomerName;


    public Hairdresser(String name, String salonName, LinkedHashMap<String, Integer> daysAndHoursFree) {
        this.name = name;
        this.salonName = salonName;
        this.daysAndHoursFree = daysAndHoursFree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public LinkedHashMap<String, Integer> getDaysAndHoursFree() {
        return daysAndHoursFree;
    }

    public void setDaysAndHoursFree(LinkedHashMap<String, Integer> daysAndHoursFree) {
        this.daysAndHoursFree = daysAndHoursFree;
    }


    @Override
    public String toString() {
        return "Hairdresser{" +
                "name='" + name + '\'' +
                ", salonName='" + salonName + '\'' +
                ", daysAndHoursFree=" + daysAndHoursFree +
                '}';
    }
}
