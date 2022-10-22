package Arrays;

public class med59 {
    public static void main(String[] args) {

    }

    public class NodeList{
        int val;
        NodeList next;
        public NodeList(){
        }
        public NodeList(int val) {
            this.val = val;
        }
    }
    int size;
    NodeList head;

    public void MyLinkedList() {
        head = new NodeList(0);
        size = 0;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            return -1;
        }
        NodeList tmp = head.next;

        while (index-- != 0){
            tmp = tmp.next;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        NodeList new_head = head;
        head.val = val;
        head.next = new_head;
        size++;
    }

    public void addAtTail(int val) {
        NodeList new_tmp = new NodeList();
        new_tmp.val = val;
        NodeList tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new_tmp;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(size <= index) {
            return;
        }
        NodeList new_tmp = new NodeList(val);
        NodeList tmp = head;
        while (index-- > 0) {
            tmp = tmp.next;
        }

        new_tmp.next = tmp.next;
        tmp.next = new_tmp;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size <= index || index < 0) {
            return;
        }
        NodeList tmp = head;
        while (index-- > 0) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
    }
}
