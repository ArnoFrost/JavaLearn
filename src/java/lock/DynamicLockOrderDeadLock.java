package java.lock;

//可能发生动态锁顺序死锁的代码
public class DynamicLockOrderDeadLock {

    public void transferMoney(Account fromAccount, Account toAccount, Double amount) {
        synchronized (fromAccount) {
            System.out.println(Thread.currentThread().getName() + "lock fromAccount " + fromAccount.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (toAccount) {
                System.out.println(Thread.currentThread().getName() + "lock toAccount " + toAccount.getName());
                //...
                fromAccount.minus(amount);
                toAccount.add(amount);
                //...
            }
        }
    }

    private final Object myLock = new Object();

    public void transferMoneyNotLock(Account fromAccount, Account toAccount, Double amount) {

        class Helper {
            public void transfer() {
                //...
                fromAccount.minus(amount);
                toAccount.add(amount);
                //...
            }
        }
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        //手动增加顺序判断条件
        //from小
        if (fromHash < toHash) {
            synchronized (fromAccount) {
                System.out.println(Thread.currentThread().getName() + "lock fromAccount " + fromAccount.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (toAccount) {
                    System.out.println(Thread.currentThread().getName() + "lock toAccount " + toAccount.getName());
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                System.out.println(Thread.currentThread().getName() + "lock toAccount " + fromAccount.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fromAccount) {
                    System.out.println(Thread.currentThread().getName() + "lock fromAccount " + toAccount.getName());
                    new Helper().transfer();
                }
            }
        } else {
            //一致时手动维护一组顺序保证不死锁
            synchronized (myLock) {
                synchronized (fromAccount) {
                    System.out.println(Thread.currentThread().getName() + "lock fromAccount " + fromAccount.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (toAccount) {
                        System.out.println(Thread.currentThread().getName() + "lock toAccount " + toAccount.getName());
                        new Helper().transfer();
                    }
                }
            }
        }


    }

    static class Account {
        int amount = 0;
        String name;

        public Account(int amount, String name) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void minus(Double amount) {
            try {
                Thread.sleep(1000);
                this.amount -= amount;
                System.out.println(Thread.currentThread().getName() + ",doMinus");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void add(Double amount) {
            try {
                Thread.sleep(1000);
                this.amount += amount;
                System.out.println(Thread.currentThread().getName() + ",doAdd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
