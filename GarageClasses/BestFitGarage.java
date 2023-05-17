package GarageClasses;
import VehicleClasses.Vehicle;

                                                              // THE FIRST CHILD  OF CLASS "GARAGE" (CONCRETE STRATEGY)
public class BestFitGarage extends Garage {

    public BestFitGarage(int n){
        super(n);
    }


    public boolean parkIn(Vehicle v){

        boolean done = false;
        int most_suited = 1000000000;
        int index = 0;
        for (int i = 0; i < numberOfSlots; i++) {
            if (Slots.get(i).occupied == false) {
                if (Slots.get(i).area >= v.area) {
                    if (most_suited > Slots.get(i).area) {
                        most_suited = Slots.get(i).area;
                        done = true;
                        v.arrival_time = System.currentTimeMillis( );
                        index = i;
                    }
                }
            }
        }

        if (done == false) {
            System.out.println("All parking slots that fit this car are occupied, this car has to wait for another car's departure");
            return false;
        } else {
            Slots.get(index).occupied = true;
            Slots.get(index).occupying_vehicle = v;
            System.out.println("This car should park in the "+ (index+1) +" slot");
            totalNumberOfVehicles++;
            return true;
        }
    }
}

