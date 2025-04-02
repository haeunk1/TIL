package strategy;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck realDuck = new MallardDuck();
        realDuck.display();
        realDuck.performFly();
        realDuck.performQuack();

        Duck fackDuck = new ModelDuck();
        fackDuck.display();
        fackDuck.performFly();
        fackDuck.performQuack();
    }
}
