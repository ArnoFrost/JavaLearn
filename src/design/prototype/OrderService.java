package design.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArnoFrost
 * @date 2021/9/2 19:25
 * @since 1.0
 */
public class OrderService {
    public static List<IOrder> getOrder(IOrder order) {
        List<IOrder> orderList = new ArrayList<>();
        IOrder newOrder = null;
        while (order.getOrderNumber() > 100) {
            newOrder = (IOrder) order.orderClone();
            newOrder.setOrderNumber(100);
            orderList.add(newOrder);
            order.setOrderNumber(order.getOrderNumber() - 100);
        }
        orderList.add(order);
        return orderList;
    }
}
