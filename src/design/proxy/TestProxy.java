package design.proxy;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/9 16:59
 * @Version 1.0
 */
public class TestProxy {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerProxy playerProxy = new PlayerProxy(player);
        playerProxy.onInit();
        playerProxy.onResume();
        playerProxy.onPause();
        playerProxy.onStop();
    }
}
