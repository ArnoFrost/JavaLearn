/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package patterns.behavioral.template;

/**
 * 创建一个抽象类，它的模板方法被设置为 final。
 *
 * @author ArnoFrost
 * @date 2021/9/3 09:59
 * @since 1.0
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    /**
     * play方法模板
     */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

