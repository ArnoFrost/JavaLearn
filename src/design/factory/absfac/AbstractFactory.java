package design.factory.absfac;

/**
 * @Author: ArnoFrost
 * @Date: 2020/8/5 17:47
 * @Version 1.0
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
