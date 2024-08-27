import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Завести новое животное");
            System.out.println("2. Определить животное в правильный класс");
            System.out.println("3. Увидеть список команд животного");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try (Counter counter = new Counter()) {
                        System.out.println("Введите имя животного:");
                        String name = scanner.nextLine();

                        System.out.println("Введите тип животного (Dog/Cat/Bird):");
                        String type = scanner.nextLine();

                        Animal newAnimal = null;
                        if (type.equalsIgnoreCase("Dog")) {
                            newAnimal = new Dog(name);
                        } else if (type.equalsIgnoreCase("Cat")) {
                            newAnimal = new Cat(name);
                        } else if (type.equalsIgnoreCase("Bird")) {
                            newAnimal = new Bird(name);
                        } else {
                            System.out.println("Неправильный тип животного!");
                            break;
                        }

                        registry.addAnimal(newAnimal);
                        counter.add();

                        System.out.println("Животное добавлено успешно.");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    // Здесь мы уже определяем животное при заведении
                    break;
                case 3:
                    System.out.println("Введите имя животного:");
                    String animalName = scanner.nextLine();
                    Animal animal = registry.findAnimalByName(animalName);
                    if (animal != null) {
                        System.out.println("Команды, которые выполняет животное " + animal.getName() + ": " + animal.getCommands());
                    } else {
                        System.out.println("Животное не найдено");
                    }
                    break;
                case 4:
                    System.out.println("Введите имя животного:");
                    String animalForTrainingName = scanner.nextLine();
                    Animal animalForTraining = registry.findAnimalByName(animalForTrainingName);
                    if (animalForTraining != null) {
                        System.out.println("Введите новую команду:");
                        String newCommand = scanner.nextLine();
                        animalForTraining.learnCommand(newCommand);
                        System.out.println("Животное обучено новой команде.");
                    } else {
                        System.out.println("Животное не найдено");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Неправильный выбор, попробуйте снова.");
                    break;
            }
        }
        scanner.close();
    }
}