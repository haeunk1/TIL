package decorator;

public class StarbuzzCoffee {
    public static void main(String args[]){

        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + ": $" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Milk(darkRoast);

        System.out.println(darkRoast.getDescription() + ": $" + darkRoast.cost());
    }
}
