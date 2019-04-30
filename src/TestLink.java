/**
 * @Author: ArnoFrost
 * @Date: 2019-04-30 10:33
 * @Version 1.0
 */
public class TestLink {
    public static void main(String[] args) {
//        Node node = revertSingleLinknode(readyNode());
//        Node node = reverse3(readyNode());
//        Node node = reverseLinkedList(readyNode());
        Node node = removeNthFromEnd(readyNode(), 2);
        System.out.println("node final = [" + node + "]");

    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node data = " + data + ",node next =" + next;
        }
    }

    private static Node readyNode() {
        Node linkNode1 = new Node(1);
        Node linkNode2 = new Node(2);
        Node linkNode3 = new Node(3);
        Node linkNode4 = new Node(4);
        Node linkNode5 = new Node(5);
        Node linkNode6 = new Node(6);

        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;

        System.out.println("node start = [" + linkNode1 + "]");
        return linkNode1;

    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        //dummy.next -> head
        dummy.next = head;
        int length = 0;
        //first -> head
        Node first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        // first - > dummy - > head;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
            System.out.println("first = " + first);
        }

        first.next = first.next.next;

        return dummy.next;
    }


    /**
     * 单链表翻转
     */
    private static Node revertSingleLinknode(Node node) {
        Node prev = null;
        Node now = node;
        while (now != null) {
            Node next = now.next;
            now.next = prev;
            prev = now;
            now = next;
            System.out.println("now =" + now);
            System.out.println("prev =" + prev);
        }

        return prev;
    }

    private Node reverse2(Node node, Node prev) {
        if (node.next == null) {
            node.next = prev;
            return node;
        } else {
            Node re = reverse2(node.next, node);
            node.next = prev;
            return re;
        }
    }

    public static Node reverse3(Node node) {
        if (node.next == null) {
            System.out.println("node null = [" + node + "]");
            return node;
        }
        Node next = node.next;
        node.next = null;
        Node re = reverse3(next);
        next.next = node;
        System.out.println("node = [" + node + "]");
        return re;
    }

    public static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            System.out.println("node null = [" + node + "]");
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            System.out.println("node = [" + node + "]");
            return headNode;
        }
    }
}
