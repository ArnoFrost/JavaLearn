package patterns.creational.factory.absfac;

/**
 * @author ArnoFrost
 * @date 2020/8/5 17:49
 * @since 1.0
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if ("SHAPE".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else if ("COLOR".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
