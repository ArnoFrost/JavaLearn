package patterns.structural.proxy.staticProxy;

import patterns.structural.proxy.IPlayerState;

/**
 * @author ArnoFrost
 * @date 2020/5/9 16:57
 * @since 1.0
 */
public class PlayerProxy implements IPlayerState {
    private IPlayerState mState;

    public PlayerProxy(IPlayerState mState) {
        this.mState = mState;
    }

    @Override
    public void onInit() {
        System.out.println("代理类 onInit start");
        if (mState != null) {
            mState.onInit();
        }
        System.out.println("代理类 onInit finish");
    }

    @Override
    public void onResume() {
        System.out.println("代理类 onResume");
        if (mState != null) {
            mState.onResume();
        }
    }

    @Override
    public void onPause() {
        System.out.println("代理类 onPause");
        if (mState != null) {
            mState.onPause();
        }
    }

    @Override
    public void onStop() {
        System.out.println("代理类 onStop");
        if (mState != null) {
            mState.onStop();
        }
    }
}
