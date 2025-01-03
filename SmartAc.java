package smarthomesystem;

public class SmartAc implements SmartDevice {
    private int temperature=24;
    public void turnOn(){
        System.out.println("Smart AC turned On");
    }
    public void turnOff(){
        System.out.println("Smart AC turned off.");
    }
    public void adjustSettings(String setting,Object value){
        if(setting.equalsIgnoreCase("temperature")){
            temperature=(int) value;
            System.out.println("Temperature set to "+ temperature+ "C");
        } else {
            System.out.println("invalid setting for Smart AC");
        }
    }
}
