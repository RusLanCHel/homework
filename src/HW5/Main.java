public class Main {

    private static Dog dog0 = new Dog("Bob");
    private static Cat cat0 = new Cat("Sharlin");

    public static void main(String[] args){
        System.out.println(dog0.getName() + " " + dog0.getMaxRun());
        System.out.println(cat0.getName() + " " + cat0.getMaxJump());

        dog0.run(150);
        cat0.swim(200);

    }

}
