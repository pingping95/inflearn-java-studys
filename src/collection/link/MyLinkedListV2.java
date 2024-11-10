package collection.link;

public class MyLinkedListV2 {

    private Node first;
    private int size = 0;

    public void add(Object o) {
        Node newNode = new Node(o);

        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }

        size++;
    }

    private Node getLastNode() {
        Node x = first;

        // next field가 null인 Node를 찾아서 반환해야 한다.
        while (x.next != null) {
            x = x.next;
        }

        return x;
    }

    // 추가된 코드
    public void add(int index, Object e) {
        Node newNode = new Node(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }


    public Object set(int index, Object element) {
        Node x = getNode(index);
        Object oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public Object remove(int index) {
        Node removeNode = getNode(index);
        Object removedItem = removeNode.item;   // return 해야 함

        if (index == 0) {
            first = removeNode.next;
        } else {
            Node prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        // removeNode의 item, next field를 null로 만들어준다.
        removeNode.item = null;
        removeNode.next = null;
        size--;

        return removedItem;
    }


    public Object get(int index) {
        Node x = getNode(index);
        return x.item;
    }

    public Node getNode(int index) {
        Node x = first;

        // index번째 Node를 찾아서 반환해야 한다.
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    public int indexOf(Object o) {
        int index = 0;

        // first Node부터 순차적으로 탐색하면서 o와 같은 객체를 찾아서 그 index를 반환해야 한다.
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

}
