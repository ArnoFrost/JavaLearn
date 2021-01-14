package design.proxy.dynamic;

import design.proxy.IPlayerState;
import design.proxy.staticProxy.Player;

import java.lang.reflect.Proxy;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/14 16:07
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        IPlayerState playerState = new Player();
        DynamicPlayerProxy proxy = new DynamicPlayerProxy(playerState);

        ClassLoader loader = proxy.getClass().getClassLoader();
        IPlayerState state = (IPlayerState) Proxy.newProxyInstance(loader, new Class[]{IPlayerState.class}, proxy);

        state.onInit();
        state.onResume();
        state.onPause();
        state.onStop();

    }
}
