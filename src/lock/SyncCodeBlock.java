package lock;

public class SyncCodeBlock {

    public int i;

    public void syncTask() {
        //同步代码库
        synchronized (this) {
            i++;
        }
    }

    public static void main(String[] args) {

    }

}