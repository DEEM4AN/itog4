class Dog extends Animal {
    public Dog(String name) {
        super(name);
        commands.add("Sit");
        commands.add("Fetch");
    }

    @Override
    public String getType() {
        return "Dog";
    }
}
