class Drone extends Aircraft implements CargoCapable {

    public Drone(String name) {
        super(name);
    }

    @Override
    public void carryCargo() {
        System.out.println(getName() + " is carrying cargo.");
    }

    @Override
    public void displayCargoCapable() {

    }
}