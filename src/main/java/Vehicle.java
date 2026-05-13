import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

// A car's value is determined as
    // 0-3 years old - 3% reduced value of cost per year
    // 4-6 years old - 6% reduced value of cost per year
    // 7-10 years old - 8% reduced value of cost per year
    // over 10 years old - $1000.00
    // MINUS reduce final value by 25% if over 100,000 miles
    // unless makeModel contains word Honda or Toyota

    @Override
    public double getValue(){
        double value = 0;
        double depreciatedValue = 0;

        int yearsBought = LocalDate.now().getYear() - this.year;

        if (yearsBought <= 3) {
            depreciatedValue = .03 * getOriginalCost();
        } else if (yearsBought <= 6) {
            depreciatedValue = .06 * getOriginalCost();
        } else if (yearsBought <= 10) {
            depreciatedValue = .08 * getOriginalCost();
        }
        value -= depreciatedValue;
        if (yearsBought > 10) {
            value = 1000.00;
        }
        if (!makeModel.equalsIgnoreCase("Honda") && (!makeModel.equalsIgnoreCase("Toyota"))){
                if (odometer > 100000){
                    depreciatedValue = .25 * value;
                    value -= depreciatedValue;
                }}
        return value;
    }
}



