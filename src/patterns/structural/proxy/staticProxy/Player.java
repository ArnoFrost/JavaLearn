package patterns.structural.proxy.staticProxy;

import patterns.structural.proxy.IPlayerState;

/**
 * @author ArnoFrost
 * @date 2020/5/9 16:56
 * @since 1.0
 */
public class Player implements IPlayerState {
    @Override
    public void onInit() {
        System.out.println("Player.onInit");
    }

    @Override
    public void onResume() {
        System.out.println("Player.onResume");
    }

    @Override
    public void onPause() {
        System.out.println("Player.onPause");
    }

    @Override
    public void onStop() {
        System.out.println("Player.onStop");
    }
}
