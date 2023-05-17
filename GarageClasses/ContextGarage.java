package GarageClasses;
public class ContextGarage {
                                                                      //THE CONTEXT CLASS
                                                                     // A SINGLETON DESIGN PATTERN IS APPLIED ON THIS CLASS

    private static ContextGarage contextgarage;
    public Garage object;
    private ContextGarage(Garage obj){
        object = obj;
    }
    public static ContextGarage getInstance (Garage obj) {
        if (contextgarage == null) { contextgarage = new ContextGarage(obj); }
        return contextgarage;
    }
}
