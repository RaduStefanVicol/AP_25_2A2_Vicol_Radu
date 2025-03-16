class Airliner extends Aircraft implements PassengerCapable {

    public Airliner(String name) {
        super(name);
    }

    @Override
    public void carryPassengers() {
        System.out.println(this.getName() + " is carrying passengers.");
    }

    @Override
    public void displayPassengerCapable() {

    }
}