package patterns.structural.decorate;

public class Client {
    public static void main(String[] args) {
        IHouse house = new House();
        house.live();


        IStickyHookHouse stickyHookHouse = new StickyHoodDecorator(house);
        stickyHookHouse.live();
        stickyHookHouse.hangThings();
    }
}
