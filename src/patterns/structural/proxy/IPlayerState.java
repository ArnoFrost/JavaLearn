package patterns.structural.proxy;

/**
 * @author ArnoFrost
 * @date 2020/5/9 16:56
 * @since 1.0
 */
public interface IPlayerState {
    void onInit();

    void onResume();

    void onPause();

    void onStop();
}
