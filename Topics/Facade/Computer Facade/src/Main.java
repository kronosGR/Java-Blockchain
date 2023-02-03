class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        /* Your subsystems */
        Processor processor = new Processor();
        Keyboard keyboard = new Keyboard();
        Monitor monitor = new Monitor();

        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    /* Your subsystems */
    Processor processor;
    Keyboard keyboard;
    Monitor monitor;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        /* Write your code here */
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.processor = processor;
    }

    public void turnOnComputer() {
        /* Write your code here */
        processor.on();
        monitor.on();
        keyboard.on();
    }

    public void turnOffComputer() {
        /* Write your code here */
        keyboard.off();
        monitor.off();
        processor.off();
    }
}

class Processor {
    /* Your subsystem description */

    public void on() {
        /* Write your code here */
        System.out.println("Processor on");
    }

    public void off() {
        /* Write your code here */
        System.out.println("Processor off");
    }
}

class Monitor {
    /* Your subsystem description */

    public void on() {
        /* Write your code here */
        System.out.println("Monitor on");
    }

    public void off() {
        /* Write your code here */
        System.out.println("Monitor off");
    }
}

class Keyboard {
    /* Your subsystem description */

    public void on() {
        /* Write your code here */
        System.out.println("Keyboard on");
        this.turnOnBacklight();
    }

    public void off() {
        /* Write your code here */
        System.out.println("Keyboard off");
        this.turnOffBacklight();
    }

    private void turnOnBacklight() {
        /* Write your code here */
        System.out.println("Backlight is turned on");
    }

    private void turnOffBacklight() {
        /* Write your code here */
        System.out.println("Backlight is turned off");
    }
}