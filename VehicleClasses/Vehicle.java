package VehicleClasses;
public class Vehicle {

    public String model_Name;
    public int identification_Number;
    public int model_Year;
    public int width;
    public int length;
    public int area;
    public long arrival_time;
    public long departure_time;

    public Vehicle(String mn, int id, int my, int w, int l){
        model_Name=mn;
        identification_Number=id;
        model_Year=my;
        width=w;
        length=l;
        area=l*w;
    }
}


