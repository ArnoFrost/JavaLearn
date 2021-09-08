package design.prototype;

/**
 * @author ArnoFrost
 * @date 2021/9/2 19:24
 * @since 1.0
 */
public interface IOrder extends IOrderCloneable {
    void setOrderNumber(int number);

    int getOrderNumber();
}
