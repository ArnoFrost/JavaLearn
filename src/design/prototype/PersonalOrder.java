package design.prototype;

/**
 * @author ArnoFrost
 * @date 2021/9/2 19:28
 * @since 1.0
 */
public class PersonalOrder implements IOrder{
    private String orderName;
    private String orderUserName;
    private int orderNumber;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    @Override
    public void setOrderNumber(int number) {
        this.orderNumber = number;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public IOrderCloneable orderClone() {
        PersonalOrder personalOrder = new PersonalOrder();
        personalOrder.setOrderName(orderName);
        personalOrder.setOrderUserName(orderUserName);
        return personalOrder;
    }

    @Override
    public String toString() {
        return "PersonalOrder{" +
                "orderName='" + orderName + '\'' +
                ", orderUserName='" + orderUserName + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
