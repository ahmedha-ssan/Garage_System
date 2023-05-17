import java.util.*;
import VehicleClasses.Vehicle;
import SlotClasses.ParkingSlot;
import GarageClasses.*;


public class main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of slots in your garage.");
        int slotsNUM = input.nextInt();

        System.out.println("Choose one of the following parking approaches.");
        System.out.println("1.First come first served approach");
        System.out.println("2.Best-fit approach");
        System.out.println("Enter (1) for the first option and (2) for the second");

        ContextGarage garage = ContextGarage.getInstance(new FirstComeFirstServedGarage(slotsNUM));

        while (true) {
            int choice = input.nextInt();
            if(choice==1){break;}
            if(choice==2){garage = ContextGarage.getInstance(new BestFitGarage(slotsNUM));break ;}
            else{System.out.println("You have entered INVALID input try again ");}
        }


        System.out.println("Enter the info of the slots");


        for (int i = 1; i <= slotsNUM; i++) {
            int l, w;
            System.out.println("Enter the length of the " + i + " slot.");
            l = input.nextInt();
            System.out.println("Enter the width of the  " + i + " slot.");
            w = input.nextInt();
            ParkingSlot temp = new ParkingSlot(l, w);
            garage.object.Slots.add(temp);

        }                             // Getting slots info from the user


        System.out.println("The application is ready to be used");



        while (true) {

            System.out.println("1.Display available slots");
            System.out.println("2.Add a vehicle to the garage");
            System.out.println("3.Remove a vehicle from the garage");
            System.out.println("4.Total Income");
            System.out.println("5.Total number of vehicles");
            System.out.println("6.Exit");

            System.out.println("Enter (1) for the first option and (2) for the second ETC...");
            int choice_2 = input.nextInt();
            if (choice_2 == 1) {
                garage.object.displayAvailableSlots();
            }
            else if (choice_2 == 2) {
                System.out.println("please enter the details of the vehicle");
                input.nextLine();
                System.out.println("please enter the model name of the vehicle");
                String mn = input.nextLine();

                System.out.println("please enter the identification number of the vehicle");
                int id = input.nextInt();

                System.out.println("please enter the model year of the vehicle");
                int my = input.nextInt();

                System.out.println("please enter the width of the vehicle");
                int w = input.nextInt();

                System.out.println("please enter the length of the vehicle");
                int l = input.nextInt();
                Vehicle temp = new Vehicle(mn, id, my, w, l);
                garage.object.parkIn(temp);
            }//Getting vehicle info from the user

            else if(choice_2==3){
                System.out.println("Enter the number of the slot that the car was parked in");
                int s= input.nextInt();
                System.out.println("The parking fees is "+garage.object.parkOut(s-1)+" EGP");
            }

            else if(choice_2==4){

                System.out.println("The total income are "+garage.object.getTotalIncome()+" EGP");
            }
            else if(choice_2==5){

                System.out.println("total number of vehicles is "+garage.object.getTotalNumberOfVehicles());
            }
            else if(choice_2==6){
                System.out.println("Thanks for using our application");
                return;
            }

            else{System.out.println("You have entered INVALID input try again ");}

        }                                                    // Getting instructions from the user
    }
}