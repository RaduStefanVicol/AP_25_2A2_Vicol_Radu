class Freighter extends Aircraft implements CargoCapable {

    public Freighter(String name) {
        super(name);
    }

    @Override
    public void carryCargo() {
        System.out.println(this.getName() + " is carrying cargo.");
    }

    @Override
    public void displayCargoCapable() {

    }
}