package smarthomesystem;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
    private List<SmartDevice> devices=new ArrayList<>();
    public void addDevice(SmartDevice device){
        devices.add(device);
    }
    public void executeCommand(Command command){
        command.execute();
    }
    public void scheduleCommand(Command command,long delayInMills,long millis){
        DeviceScheduler scheduler=new DeviceScheduler();
        scheduler.schedule(command, delayInMills);
    }
}
