package strategy;

public abstract class Duck{
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public void setQuackBehabior(QuackBehavior qb){
        this.quackBehavior = qb;
    }
    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior = fb;
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    abstract void display();
}