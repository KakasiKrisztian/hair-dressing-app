package customer;

public class Customer {
    private String name;
    private int desiredHour;
    private String desiredDay;

    public Customer(String name, int desiredHour, String desiredDay) {
        this.name = name;
        this.desiredHour = desiredHour;
        this.desiredDay = desiredDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDesiredHour() {
        return desiredHour;
    }

    public void setDesiredHour(int desiredHour) {
        this.desiredHour = desiredHour;
    }

    public String getDesiredDay() {
        return desiredDay;
    }

    public void setDesiredDay(String desiredDay) {
        this.desiredDay = desiredDay;
    }
}
