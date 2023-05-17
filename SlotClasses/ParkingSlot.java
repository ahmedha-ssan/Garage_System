package SlotClasses;

import VehicleClasses.Vehicle;

public class ParkingSlot {
    public int number;
    public int length;
    public int width;
    public int area;
    public static int st_num=1;
    public boolean occupied= false;
    public Vehicle occupying_vehicle;

    public ParkingSlot(int l, int w){
        length=l;
        width=w;
        area=l*w;
        number=st_num;
        st_num++;
    }
}
