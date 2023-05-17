package GarageClasses;
import SlotClasses.ParkingSlot;
import VehicleClasses.Vehicle;
import java.util.Vector;

                                                                             // PARENT CLASS (THE STRATEGY CLASS)
public abstract class Garage {
    protected int totalNumberOfVehicles=0;
    protected double totalIncome=0;
    public int numberOfSlots;
    public Vector<ParkingSlot> Slots;

    public Garage(int n){
        numberOfSlots=n;
        Slots=new Vector<ParkingSlot>(numberOfSlots);
    }

    public abstract boolean parkIn(Vehicle v);

    public double parkOut(int slotIndex ){

        if(slotIndex<0 || slotIndex >=numberOfSlots){System.out.println("You have entered a slot number that doesn't exist");return 0;}
        else {
            Slots.get(slotIndex).occupied = false;
            Slots.get(slotIndex).occupying_vehicle.departure_time = System.currentTimeMillis();
            long totalTime = Slots.get(slotIndex).occupying_vehicle.departure_time - Slots.get(slotIndex).occupying_vehicle.arrival_time;
            double cost = (totalTime / 3600000.0) * 5;
            totalIncome = totalIncome + cost;
            return cost;
        }
    }

    public void displayAvailableSlots(){
        for (int i = 0; i < numberOfSlots; i++) {
            if (Slots.get(i).occupied == false) {

                System.out.println("Slot number: " + Slots.get(i).number);
                System.out.println("Slot length: " + Slots.get(i).length);
                System.out.println("Slot width: "  + Slots.get(i).width);
                System.out.println("---------------------------------------------");
            }
        }
    }

    public int getTotalNumberOfVehicles() {
        return totalNumberOfVehicles;
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}
