package design.factory.absfac;

/**
 * @author ArnoFrost
 * @date 2020/8/5 17:45
 * @since 1.0
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
