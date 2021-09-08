/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.other;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static void modifyPoint(Point p1, Point p2) {
        Point tmpPoint = p1;
        p1 = p2;
        p2 = tmpPoint;
        p1.setLocation(5, 5);
        p2 = new Point(5, 5);
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        modifyPoint(p1, p2);
        System.out.println("[" + p1.x + "," + p1.y + "],[" + p2.x + "," + p2.y + "]");
    }

//    public static void main(String[] args) {
//        List<String> colorList = new ArrayList<>();
//        colorList.add("BLUE");
//        colorList.add("RED");
//        colorList.add("GRAY");
//        System.out.println(colorList);
//        removeFirst(colorList);
////        System.out.println(colorList);
//        System.out.println("hashCode = " + colorList.hashCode() + ",real value = " + colorList);
//
//    }

    private static void removeFirst(List colorList) {
        if (!colorList.isEmpty()) {
//            colorList.remove(0);
//            colorList = colorList.subList(1, 3);
            colorList = new ArrayList();
            System.out.println("hashCode = " + colorList.hashCode() + ",params value = " + colorList);
        }
        int a = 1;
        String b = "hello";
    }
}
