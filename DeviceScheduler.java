package smarthomesystem;

import java.util.Timer;
import java.util.TimerTask;

public class DeviceScheduler {
    public void schedule(Command command,long delayInMills){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                command.execute();
                
            }          
        },delayInMills);
    }
}
