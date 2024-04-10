class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (currentNode == tail) {
            tail.next = newNode;
            tail = newNode;
        } else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public void removeAfter(Node currentNode) {
        if (currentNode == null && head != null) {
            // Special case: remove head
            Node succeedingNode = head.next;
            head = succeedingNode;
            if (succeedingNode == null) {
                // Last item was removed
                tail = null;
            }
        } else if (currentNode.next != null) {
            Node succeedingNode = currentNode.next.next;
            currentNode.next = succeedingNode;
            if (succeedingNode == null) {
                // Remove tail
                tail = currentNode;
            }
        }
    }

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to populate the list with primes up to n
    public void populatePrimes(int n) {
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                append(new Node(i));
            }
        }
    }

    // Function to create a new list containing primes with digit '3'
    public LinkedList getPrimesWithDigitThree(LinkedList originalList) {
        LinkedList newList = new LinkedList();
        Node current = originalList.head;
        while (current != null) {
            // Check if the number has digit '3' (convert to string and check)
            if (Integer.toString(current.data).indexOf('3') != -1) {
                newList.append(new Node(current.data));
            }
            current = current.next;
        }
        return newList;
    }

    // Function to calculate the sum of elements in a linked list
    public int getSum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}
