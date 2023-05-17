package GarageClasses;
import VehicleClasses.Vehicle;
                                                         // THE SECOND CHILD  OF CLASS "GARAGE" (CONCRETE STRATEGY)
public class FirstComeFirstServedGarage extends Garage {

    public FirstComeFirstServedGarage(int n){
        super(n);
    }

    public boolean parkIn(Vehicle v) {
        boolean done = false;
        int index=0;
        for (int i = 0; i < numberOfSlots; i++) {
            if (Slots.get(i).occupied == false && Slots.get(i).area >= v.area) {
                Slots.get(i).occupied = true;
                Slots.get(i).occupying_vehicle = v;
                v.arrival_time =System.currentTimeMillis( );
                done = true;
                index=i;
                break;
            }
        }
        if (done == false) {
            System.out.println("All parking slots that fit this car are occupied, this car has to wait for another car's departure");
            return false;
        }
        else{System.out.println("This car should park in the "+ (index+1) +" slot");totalNumberOfVehicles++;return true;}

    }

}
