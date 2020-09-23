
public class Dog extends Animal{

    Dog(String name){
        super(name);
        this.maxJump = (float)(Math.random() * 4.7 + 0.3);
        this.maxRun = (int)(Math.random() * 1800 + 200);
        this.maxSwim = (int)(Math.random() * 35 + 5);
    }

    @Override
    void run(int distance){
        if(distance > maxRun){
            System.out.println("Пёсель не может бежать так много");
        } else {
            System.out.println("Пёсель пробежал!");
        }
    }

    @Override
    void jump(float height){
        if(height > maxJump){
            System.out.println("Пёсель не может перепрыгнуть такое высокое препядствие");
        } else {
            System.out.println("Пёсель перепрыгнул!");
        }
    }

    @Override
    void swim(int distance){
        if(distance > maxSwim){
            System.out.println("Пёсель не может переплыть такую дистанцию");
        } else {
            System.out.println("Пёсель переплыл!");
        }
    }

}
