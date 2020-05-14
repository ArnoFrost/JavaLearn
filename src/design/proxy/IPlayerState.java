package design.proxy;

/**
 * @Author: ArnoFrost
 * @Date: 2020/5/9 16:56
 * @Version 1.0
 */
public interface IPlayerState {
    void onInit();

    void onResume();

    void onPause();

    void onStop();
}
