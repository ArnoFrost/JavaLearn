package design.factory.absfac;

/**
 * @Author: ArnoFrost
 * @Date: 2020/8/5 17:49
 * @Version 1.0
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
