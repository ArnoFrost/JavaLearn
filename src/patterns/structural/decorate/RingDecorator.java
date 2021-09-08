package patterns.structural.decorate;

/**
 * @author ArnoFrost
 * @date 2020/4/24 15:31
 * @since 1.0
 */
public class RingDecorator implements IBeauty {
    private final IBeauty me;

    public RingDecorator(IBeauty me) {
        this.me = me;
    }

    @Override
    public int getBeautyValue() {
        return me.getBeautyValue() + 20;
    }

}
