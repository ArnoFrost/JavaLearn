package patterns.structural.decorate;

public class House implements IHouse {

    @Override
    public void live() {
        System.out.println(" 原有功能");
    }
}
