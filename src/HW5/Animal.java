public abstract class  Animal {

    protected String name;
    protected int maxRun;
    protected float maxJump;
    protected int maxSwim;

    Animal(String name){
        this.name = name;
    }

    protected String getName(){
        return name;
    }

    int getMaxRun(){
        return maxRun;
    }
    int getMaxSwim(){
        return maxSwim;
    }
    float getMaxJump(){
        return maxJump;
    }

    abstract void run(int distance);

    abstract void swim(int distance);

    abstract void jump(float height);

}
