package smarthomesystem;

public class AdjustSettingCommand implements Command {
    private SmartDevice device;
    private String setting;
    private Object value;
    public AdjustSettingCommand(SmartDevice device, String setting,Object value) {
        this.device = device;
        this.setting = setting;
        this.value = value;
    }
    public void execute(){
        device.adjustSettings(setting,value);
    }
}
