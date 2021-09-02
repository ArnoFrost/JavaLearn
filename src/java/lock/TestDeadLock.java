package java.lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/7/22 20:33
 * @Version 1.0
 */
public class TestDeadLock {
    public static void main(String[] args) {
//        StaticLockOrderDeadLock staticLockOrderDeadLock = new StaticLockOrderDeadLock();
//        new Thread(staticLockOrderDeadLock::a).start();
//        new Thread(staticLockOrderDeadLock::b).start();

        DynamicLockOrderDeadLock dynamicLockOrderDeadLock = new DynamicLockOrderDeadLock();
        DynamicLockOrderDeadLock.Account accountA = new DynamicLockOrderDeadLock.Account(10, "AccountA");
        DynamicLockOrderDeadLock.Account accountB = new DynamicLockOrderDeadLock.Account(100, "AccountB");

//        new Thread(() -> dynamicLockOrderDeadLock.transferMoney(accountA, accountB, 10.0)).start();
//        new Thread(() -> dynamicLockOrderDeadLock.transferMoney(accountB, accountA, 20.0)).start();

        new Thread(() -> dynamicLockOrderDeadLock.transferMoneyNotLock(accountA, accountB, 10.0)).start();
        new Thread(() -> dynamicLockOrderDeadLock.transferMoneyNotLock(accountB, accountA, 20.0)).start();
    }
}
