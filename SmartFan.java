package smarthomesystem;

public class SmartFan implements SmartDevice {
    private int speed=0;
    private boolean swingMode=false;
    public void turnOn(){
        System.out.println("Smart Fan turned on.");
    }
    public void turnOff(){
        System.out.println("Smart Fan turned off.");
    }
    public void adjustSettings(String setting,Object value){
        switch(setting.toLowerCase()){
            case "speed":
            speed=(int)value;
            System.out.println("Fan speed set to " + speed);
            case "swingmode":
            swingMode=(boolean) value;
            System.out.println("Swing mode set to "+(swingMode? "On": "Off"));
            break;
            default:
            System.out.println("invalid setting for Smart Fan");
        }
    }
}
