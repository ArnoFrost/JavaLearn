package design.factory.absfac;

/**
 * @author ArnoFrost
 * @date 2020/8/5 17:47
 * @since 1.0
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
