package smarthomesystem;

interface SmartDevice{
    void turnOn();
    void turnOff();
    void adjustSettings(String setting,Object value);
}