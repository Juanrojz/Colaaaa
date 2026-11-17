public class Queue implements QueueInterface {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    public Queue(boolean isPriorityQueue) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.isPriorityQueue = isPriorityQueue;
    }

    public Queue() {
        this(false);
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object extract() {
        if (isEmpty()) {
            return null;
        }
        Object obj = head.object;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return obj;
    }

    public boolean insert(Object obj) {
        if (obj == null || isPriorityQueue) {
            return false;
        }
        QueueNode nvo = new QueueNode();
        nvo.object = obj;
        if (isEmpty()) {
            head = nvo;
            tail = nvo;
        } else {
            tail.next = nvo;
            tail = nvo;
        }
        size++;
        return true;
    }

    public boolean insert(Object obj, int pri) {
        if (obj == null || !isPriorityQueue) {
            return false;
        }
        QueueNode nvo = new QueueNode();
        nvo.object = obj;
        nvo.priority = pri;
        if (isEmpty()) {
            head = nvo;
            tail = nvo;
        } else if (pri > head.priority) {
            nvo.next = head;
            head = nvo;
        } else {
            QueueNode aux = head;
            while (aux.next != null && aux.next.priority >= pri) {
                aux = aux.next;
            }
            nvo.next = aux.next;
            aux.next = nvo;
            if (nvo.next == null) {
                tail = nvo;
            }
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean search(Object obj) {
        QueueNode aux = head;
        while (aux != null) {
            if (aux.object.equals(obj)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public String toString() {
        String res = "[";
        QueueNode aux = head;
        while (aux != null) {
            res += aux.object;
            if (isPriorityQueue) {
                res += "(" + aux.priority + ")";
            }
            if (aux.next != null) {
                res += ", ";
            }
            aux = aux.next;
        }
        res += "]";
        return res;
    }

}