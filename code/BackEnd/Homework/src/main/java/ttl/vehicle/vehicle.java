package ttl.vehicle;

import java.util.Scanner;

public class vehicle {
    public static void main(String [] args){
        vehicleData newVehicle = captureData();
        printData(newVehicle);
    }

    public static class vehicleData {
        private int vehicleId;
        public int getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
        }
        private String make;
        public String getMake(){
            return make;
        }
        public void setMake(String make){
            this.make = make;
        }
        private String model;
        public String getModel(){
            return model;
        }
        public void setModel(String model){
            this.model = model;
        }
        private String color;
        public String getColor(){
            return color;
        }
        public void setColor(String color){
            this.color = color;
        }
        private String bundlePackage;
        public String getBundlePackage(){
            return bundlePackage;
        }
        public void setBundlePackage(String bundlePackage){
            this.bundlePackage = bundlePackage;
        }
        private int odometer;
        public int getOdometer(){
            return odometer;
        }
        public void setOdometer(int odometer){
            this.odometer = odometer;
        }
        private float price;
        public float getPrice(){
            return price;
        }
        public void setPrice(int price){
            this.price = price;
        }
        private char rating;
        public char getRating(){
            return rating;
        }
        public void setOdometer(char rating){
            this.rating = rating;
        }
    }

    public static vehicleData captureData(){
        vehicleData newVehicle = new vehicleData();
        try {
            Scanner reader = new Scanner(System.in);
            for(int i = 0; i < 7; i++) {
                switch (i){
                    case 0:
                        System.out.println("Type vehicle Identification Number");
                        newVehicle.vehicleId = Integer.parseInt(reader.nextLine());
                        break;
                    case 1:
                        System.out.println("Type vehicle Make");
                        newVehicle.make = reader.nextLine();
                        break;
                    case 2:
                        System.out.println("Type Vehicle Model");
                        newVehicle.model = reader.nextLine();
                        break;
                    case 3:
                        System.out.println("Type Vehicle Towing Package");
                        newVehicle.bundlePackage = reader.nextLine();
                        break;
                    case 4:
                        System.out.println("Type Vehicle Odometer");
                        newVehicle.odometer = reader.nextInt();
                        break;
                    case 5:
                        System.out.println("Type Vehicle Price");
                        newVehicle.price = reader.nextFloat();
                        break;
                    case 6:
                        System.out.println("Type Vehicle Quality Rating (A, B, or C)");
                        newVehicle.rating = reader.next().charAt(0);
                        break;
                }
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        };
        return newVehicle;
    }

    public static void printData(vehicleData vehicleCaptured){
        System.out.println(STR."The vehicle id is: \{vehicleCaptured.vehicleId}");
        System.out.println(STR."The vehicle make is: \{vehicleCaptured.make}");
        System.out.println(STR."The vehicle model is: \{vehicleCaptured.model}");
        System.out.println(STR."The vehicle color is: \{vehicleCaptured.color}");
        System.out.println(STR."The vehicle bundlePackage is: \{vehicleCaptured.bundlePackage}");
        System.out.println(STR."The vehicle odometer is: \{vehicleCaptured.odometer}");
        System.out.println(STR."The vehicle price is: \{vehicleCaptured.price}");
        System.out.println(STR."The vehicle rating is: \{vehicleCaptured.rating}");
    }
}

