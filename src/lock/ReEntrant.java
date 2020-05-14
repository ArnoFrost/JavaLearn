package lock;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/13 19:38
 * @Version 1.0
 */
public class ReEntrant {
    public static void main(String[] args) {
        ReEntrant entrant = new ReEntrant();
        try {
            entrant.setA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized void setA() throws Exception {
        Thread.sleep(1000);
        setB();
    }

    synchronized private void setB() throws Exception {
        Thread.sleep(1000);
    }
}
