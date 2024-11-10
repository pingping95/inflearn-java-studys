package collection.link;

public class MyLinkedListV3<E> {

    private Node<E> first;
    private int size = 0;

    public void add(E o) {
        Node<E> newNode = new Node<>(o);

        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }

        size++;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;

        // next field가 null인 Node를 찾아서 반환해야 한다.
        while (x.next != null) {
            x = x.next;
        }

        return x;
    }

    // 추가된 코드
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }


    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item;   // return 해야 함

        if (index == 0) {
            first = removeNode.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        // removeNode의 item, next field를 null로 만들어준다.
        removeNode.item = null;
        removeNode.next = null;
        size--;

        return removedItem;
    }


    public E get(int index) {
        Node<E> x = getNode(index);
        return x.item;
    }

    public Node<E> getNode(int index) {
        Node<E> x = first;

        // index번째 Node를 찾아서 반환해야 한다.
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    public int indexOf(E o) {
        int index = 0;

        // first Node부터 순차적으로 탐색하면서 o와 같은 객체를 찾아서 그 index를 반환해야 한다.
        for (Node<E> x = first; x != null; x = x.next) {
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

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> temp = this;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.item);
                if (temp.next != null) {
                    sb.append("->");
                }
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
