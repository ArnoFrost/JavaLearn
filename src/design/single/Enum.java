package design.single;

/**
 * @author ArnoFrost
 * @date 2020/4/15 17:02
 * @since 1.0
 */
public enum Enum {
    INSTANCE;

    private void init() {
        System.out.println();
    }

    private void setData() {
        System.out.println("Enum.setData");
    }
}
