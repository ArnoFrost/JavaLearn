package design.proxy;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/9 16:57
 * @Version 1.0
 */
public class PlayerProxy implements IPlayerState {
    private IPlayerState mState;

    public PlayerProxy(IPlayerState mState) {
        this.mState = mState;
    }

    @Override
    public void onInit() {
        if (mState != null) {
            mState.onInit();
        }
    }

    @Override
    public void onResume() {
        if (mState != null) {
            mState.onResume();
        }
    }

    @Override
    public void onPause() {
        if (mState != null) {
            mState.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mState != null) {
            mState.onStop();
        }
    }
}
