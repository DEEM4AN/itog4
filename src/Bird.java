class Bird extends Animal {
    public Bird(String name) {
        super(name);
        commands.add("Fly");
    }

    @Override
    public String getType() {
        return "Bird";
    }
}