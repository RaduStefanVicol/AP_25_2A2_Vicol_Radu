public class Main {
    public static void main(String[] args) {
        // Create an array of Aircraft objects
        Aircraft[] aircrafts = new Aircraft[] {
                new Airliner("Airliner1"),
                new Freighter("Freighter1"),
                new Drone("Drone1")
        };

        // Loop through the array and check if the aircraft can carry passengers or cargo
        for (Aircraft aircraft : aircrafts) {
            // Check if the aircraft can carry passengers
            if (aircraft instanceof PassengerCapable) {
                ((PassengerCapable) aircraft).carryPassengers();
            }

            // Check if the aircraft can carry cargo
            if (aircraft instanceof CargoCapable) {
                ((CargoCapable) aircraft).carryCargo();
            }
        }

        // Create an array of only cargo-capable aircraft
        Aircraft[] cargoAircrafts = new Aircraft[aircrafts.length];
        int index = 0;

        // Fill the cargo Aircrafts array with only CargoCapable aircraft
        for (Aircraft aircraft : aircrafts) {
            if (aircraft instanceof CargoCapable) {
                cargoAircrafts[index++] = aircraft;
            }
        }

        // Print cargo-capable Aircrafts
        System.out.println("\nCargo-capable aircraft:");
        for (Aircraft aircraft : cargoAircrafts) {
            if (aircraft != null) {
                System.out.println(aircraft.getName());
            }
        }
    }
}