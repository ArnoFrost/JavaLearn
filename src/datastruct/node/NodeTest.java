package datastruct.node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArnoFrost
 * @date 2020/4/2 17:51
 * @since 1.0
 */
public class NodeTest {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //1.删除单链表中指定元素的节点
//    public static Node deleteNode(Node head, Node data) {
//        System.out.println("head = " + head + ", data = " + data);
//        if (head == null || data == null) {
//            return null;
//        }
//        //遍历
//        Node firstNode = head;
//        Node preNode = null;
//        while (head.next != null) {
//            //删除
//            if (head.data == data.data) {
//                //第一个
//                if (preNode == null) {
//                    firstNode = head.next;
//                } else {
//                    preNode.next = head.next;
//                }
//                break;
//            }
//            //记录当前
//            preNode = head;
//            //向后查找
//            head = head.next;
//        }
//
//        return firstNode;
//    }
    public static Node deleteNode(Node head, Node data) {
        System.out.println("head = " + head + ", data = " + data);
        if (head == null || data == null) {
            return null;
        }
        Node fistNode = head;
        //如果是尾节点
        if (data.next == null) {
            while (head.next != data) {
                head = head.next;
            }
            head.next = null;

        } else if (head == getInitNode()) {
            //如果是头结点
//            head = null;
            return null;
        } else {
            //普通节点 做拷贝
            Node next = data.next;
            data.data = next.data;
            data.next = next.next;
        }
        return fistNode;
    }

    public static void main(String[] args) {


        Node head;
        head = new Node(0);
        Node firstNode = head;
        Node secondNode = head;
        for (int i = 1; i < 10; i++) {
            head.next = new Node(i);
            head = head.next;
        }


        printNode(firstNode);
        printNode(deleteNode(firstNode, new Node(4)));

    }

    public int lengthOfLongestSubstring03(String s) {
        int length = s.length(), uniqueLength = 0;
        //创建map窗口,i为左区间，j为右区间，右边界移动
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < length; j++) {
            // 如果窗口中包含当前字符，
            if (map.containsKey(s.charAt(j))) {
                //左边界移动到 相同字符的下一个位置和i当前位置中更靠右的位置，这样是为了防止i向左移动
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            uniqueLength = Math.max(uniqueLength, j - i + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j + 1);
        }
        return uniqueLength;
    }

    private static Node getInitNode() {
        Node head;
        head = new Node(0);
        Node firstNode = head;
        for (int i = 1; i < 10; i++) {
            head.next = new Node(i);
            head = head.next;
        }

        return firstNode;
    }

    public static void printNode(Node node) {
        if (node == null) {
            System.out.println("error is empty");
            return;
        }
        do {
            System.out.println("datastruct.node data = " + node.data);
            node = node.next;
        }
        while (node.next != null);
    }


}
