public class Cat extends Animal{

    Cat(String name){
        super(name);
        this.maxJump = (float)(Math.random() * 4.5 + 0.5);
        this.maxRun = (int)(Math.random() * 900 + 100);
        this.maxSwim = 0;
    }

    @Override
    void run(int distance){
        if(distance > maxRun){
            System.out.println("Котейка не может бежать так много");
        } else {
            System.out.println("Котик пробежал!");
        }
    }

    @Override
    void jump(float height){
        if(height > maxJump){
            System.out.println("Кот не может перепрыгнуть такое высокое препядствие");
        } else {
            System.out.println("Кот перепрыгнул!");
        }
    }

    @Override
    void swim(int distance){
        System.out.println("Коты не умеют плавать");
    }




}
