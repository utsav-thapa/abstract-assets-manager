import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Asset> myProperties = new ArrayList<>();

        House myHouse = new House("Thapa's Mansion","2025-10-14",10000000,"1800 Memory Ln",1,8000,25000);
        House farmHouse = new House("Utsav's Ranch","2025-01-01",500000,"1500 Ohio",1,10000,200000);

        myProperties.add(myHouse);
        myProperties.add(farmHouse);

        Vehicle mainCar = new Vehicle("Mustang","2026-01-01",50000,"Ford",2024,1500);
        Vehicle vintageRide = new Vehicle("Cobra","2022-01-01",150000,"Shelby",1965,12000);

        myProperties.add(mainCar);
        myProperties.add(vintageRide);

        Cash hoardingMoney = new Cash("Inherited $$", "1999-10-12",100000000);
        myProperties.add(hoardingMoney);

        double totalAssets = 0 ;


        for(Asset a : myProperties){
            totalAssets += a.getValue();
        }
        System.out.println("The total value of your assets is $" + totalAssets);

        String message = "";
        for (int i = 0; i < myProperties.toArray().length; i++) {

            if (myProperties.get(i) instanceof House) {
                House house = (House) myProperties.get(i);
                message = "House at " + house.getAddress() +" $" + house.getValue();
                System.out.println(message);
            } else if (myProperties.get(i) instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) myProperties.get(i);
                message = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel() + " $" + vehicle.getValue();
                System.out.println(message);
            } else if (myProperties.get(i) instanceof Cash){
                Cash cash = (Cash) myProperties.get(i);
                message = String.format("Cash: $%.10s",cash.getValue());
                System.out.println(message);;
            }
        }










    }
}
