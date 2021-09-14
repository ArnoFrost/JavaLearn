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
    /**
     * 初始化
     */
    abstract void initialize();

    /**
     * 开始游玩
     */
    abstract void startPlay();

    /**
     * 结束游戏
     */
    abstract void endPlay();

    /**
     * play方法模板
     * note:这个顺序一定是固定的 即方法要final修饰 子类只能修改方法
     * 却不能修改调用顺序
     */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

