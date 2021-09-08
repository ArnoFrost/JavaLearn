package design.prototype;

/**
 * @author ArnoFrost
 * @date 2021/9/2 19:28
 * @since 1.0
 */
public class EnterpriseOrder implements IOrder {
    private String orderName;
    private String orderCompany;
    private int orderNumber;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderCompany() {
        return orderCompany;
    }

    public void setOrderCompany(String orderCompany) {
        this.orderCompany = orderCompany;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int number) {
        this.orderNumber = number;
    }

    @Override
    public IOrderCloneable orderClone() {
        EnterpriseOrder personalOrder = new EnterpriseOrder();
        personalOrder.setOrderName(orderName);
        personalOrder.setOrderCompany(orderCompany);
        return personalOrder;
    }

    @Override
    public String toString() {
        return "EnterpriseOrder{" +
                "orderName='" + orderName + '\'' +
                ", orderCompany='" + orderCompany + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
