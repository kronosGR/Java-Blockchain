class Vehicle {

    private String name;

    // create constructor

    public Vehicle(String name){
        this.name = name;
    }

    class Engine {

        // add field horsePower
        // create constructor

        int hp = 0;

        public Engine(int hp) {
            this.hp = hp;
        }

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

        // create method printHorsePow
        void printHorsePower() {
            System.out.println("Vehicle " + name + " has " + this.hp + " horsepower.");
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(15);
        engine.printHorsePower();
    }
}