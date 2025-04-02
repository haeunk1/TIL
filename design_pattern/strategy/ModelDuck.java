package strategy;

public class ModelDuck extends Duck{
    
    public ModelDuck(){
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("가짜 오리");
    }
    
}
