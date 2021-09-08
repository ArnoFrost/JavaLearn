package datastruct.node;

/**
 * @author ArnoFrost
 * @date 2020/5/19 12:44
 * @since 1.0
 */
public class DeleteNode {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }

    public static Node deleteNode(Node head, Node node) {
        if (head == null || node == null) {
            return head;
        }
        Node headNode = head;
        //删除头结点
        if (head == node) {
            head.next = null;
        } else if (node.next == null) {
            //要删除的是尾结点 顺序查找
            while (head.next != node) {
                head = head.next;
            }
            head.next = null;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
        }


        return headNode;
    }

    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.data != num) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.data == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
