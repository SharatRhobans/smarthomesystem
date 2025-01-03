package smarthomesystem;

public class TurnOffCommand implements Command{
    private SmartDevice device;
    public TurnOffCommand(SmartDevice device){
        this.device = device;
    }
    public void execute(){
        device.turnOff();
    }
}
