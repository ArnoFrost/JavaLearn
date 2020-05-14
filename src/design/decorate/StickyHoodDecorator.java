package design.decorate;

public class StickyHoodDecorator implements IStickyHookHouse {
    private final IHouse house;

    public StickyHoodDecorator(IHouse house) {
        this.house = house;
    }

    @Override
    public void hangThings() {
        System.out.println("增加的东西");
    }

    @Override
    public void live() {
        house.live();
    }
}
