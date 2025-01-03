package smarthomesystem;

import java.util.Scanner;

public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        // Create devices
        SmartDevice light = new SmartLight();
        SmartDevice fan = new SmartFan();
        SmartDevice ac = new SmartAc();

        // Add devices to controller
        controller.addDevice(light);
        controller.addDevice(fan);
        controller.addDevice(ac);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Smart Home System!");
        System.out.println("Available devices: 1. Light  2. Fan  3. AC");
        
        while (true) {
            System.out.println("\nChoose a device (1: Light, 2: Fan, 3: AC, 0: Exit): ");
            int deviceChoice = scanner.nextInt();

            if (deviceChoice == 0) {
                System.out.println("Exiting Smart Home System. Goodbye!");
                break;
            }

            SmartDevice selectedDevice;
            switch (deviceChoice) {
                case 1:
                    selectedDevice = light;
                    break;
                case 2:
                    selectedDevice = fan;
                    break;
                case 3:
                    selectedDevice = ac;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            System.out.println("Choose a command: 1. Turn On  2. Turn Off  3. Adjust Settings  4. Schedule Command");
            int commandChoice = scanner.nextInt();

            switch (commandChoice) {
                case 1:
                    controller.executeCommand(new TurnOnCommand(selectedDevice));
                    System.out.println("Turned on the device.");
                    break;

                case 2:
                    controller.executeCommand(new TurnOffCommand(selectedDevice));
                    System.out.println("Turned off the device.");
                    break;

                case 3:
                    System.out.println("Enter setting name (e.g., brightness, speed, temperature): ");
                    String setting = scanner.next();
                    System.out.println("Enter value (numeric or string): ");
                    String value = scanner.next(); // Using String for simplicity
                    controller.executeCommand(new AdjustSettingCommand(selectedDevice, setting, value));
                    System.out.println("Adjusted " + setting + " to " + value + ".");
                    break;

                case 4:
                    System.out.println("Enter command type (1: Turn On, 2: Turn Off, 3: Adjust Settings): ");
                    int scheduleCommandChoice = scanner.nextInt();
                    System.out.println("Enter delay in milliseconds: ");
                    int delay = scanner.nextInt();

                    Command scheduledCommand;
                    if (scheduleCommandChoice == 1) {
                        scheduledCommand = new TurnOnCommand(selectedDevice);
                    } else if (scheduleCommandChoice == 2) {
                        scheduledCommand = new TurnOffCommand(selectedDevice);
                    } else if (scheduleCommandChoice == 3) {
                        System.out.println("Enter setting name (e.g., brightness, speed, temperature): ");
                        setting = scanner.next();
                        System.out.println("Enter value (numeric or string): ");
                        value = scanner.next();
                        scheduledCommand = new AdjustSettingCommand(selectedDevice, setting, value);
                    } else {
                        System.out.println("Invalid command type for scheduling. Try again.");
                        continue;
                    }
                    controller.scheduleCommand(scheduledCommand, delay, scheduleCommandChoice);
                    System.out.println("Scheduled command with delay of " + delay + " milliseconds.");
                    break;

                default:
                    System.out.println("Invalid command choice. Try again.");
            }
        }

        scanner.close();
    }
}
