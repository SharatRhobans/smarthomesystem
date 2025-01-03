package smarthomesystem;

public class SmartLight implements SmartDevice {
    private int brightness = 0;
    private String color = "White";

    public void turnOn() {
        System.out.println("Smart Light turned on");
    }

    public void turnOff() {
        System.out.println("Smart Light turned off");
    }

    public void adjustSettings(String setting, Object value) {
        switch (setting.toLowerCase()) {
            case "brightness":
                brightness = (int) value;
                System.out.println("Brightness set to " + brightness);
                break;
            case "color":
                color = (String) value;
                System.out.println("Color set to " + color);
                break;
            default:
                System.out.println("Invalid setting for smart light");
        }
    }
}
