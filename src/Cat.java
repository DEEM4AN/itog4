class Cat extends Animal {
    public Cat(String name) {
        super(name);
        commands.add("Meow");
    }

    @Override
    public String getType() {
        return "Cat";
    }
}