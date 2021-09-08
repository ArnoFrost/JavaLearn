package patterns.creational.prototype;

import java.util.List;

/**
 * @author ArnoFrost
 * @date 2021/9/2 19:31
 * @since 1.0
 */
public class OrderTest {
    public static void main(String[] args) {
        PersonalOrder personalOrder = new PersonalOrder();
        personalOrder.setOrderName("手机");
        personalOrder.setOrderUserName("ArnoFrost");
        personalOrder.setOrderNumber(2);

        EnterpriseOrder enterpriseOrder = new EnterpriseOrder();
        enterpriseOrder.setOrderName("电脑");
        enterpriseOrder.setOrderCompany("Sina");
        enterpriseOrder.setOrderNumber(666);

        List<IOrder> orders = OrderService.getOrder(enterpriseOrder);
        for (IOrder iOrder : orders) {
            System.out.println("订单信息:" + iOrder.toString());
        }
    }
}
