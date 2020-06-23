import java.io.Serializable;

/**
 * The class LinkedList creates a doubly linked list. It has methods to add new elements, and search for or remove elements by postition,
 * and move certain elements up or down in the list.
 *
 * @author  Valerie Foster
 * @version 2/13/2018
 */
public class LinkedList<E> implements Serializable {

    // instance variables
    private Node<E> front;
    private Node<E> end;
    private int count;

    /**
     * Constructor for objects of class LinkedList
     */
    public LinkedList() {
        front = null;
        end = null;
        count = 0;
    }

    /**
     * This method clears the list and makes it empty
     */
    public void clear() {
        front = null;
        end = null;
        count = 0;
    }

    /**
     * This method returns the number of elements in the list
     *
     * @return    the count of the list
     */
    public int size() {
        return this.count;
    }

    /**
     * This method loops through the list to find the element at the given index
     *
     * @param   ind     the index of the element to return
     * @throws          IllegalArgumentException if the given index is invalid
     * @return          the element of type E found at the given index
     */
    public E getElement(int ind) {
        if (ind > count || ind < 1) {
            throw new IllegalArgumentException("The index must be between one and the size of the list.");
        }
        Node<E> current = front;
        for (int idx = 1; idx < ind; idx++) {
            current = current.next;
        }
        return current.data;
    }
    
    /**
     * This method adds a given value at the front of the list, has differnt cases if it is the first element in the list or not
     *
     * @param   value   a given value of type E to add to the list
     */
    public void addAtFront(E value) {
        Node<E> newNode = new Node<E>(value);
        if (front == null) {
            front = newNode;
            end = newNode;
        } else {
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
        }
        count++;
    }
    
    /**
     * This method adds a given value at the end of the list, has differnt cases if it is the first element in the list or not
     *
     * @param   value   a given value of type E to add to the list
     */
    public void addAtEnd(E value) {
        Node<E> newNode = new Node<E>(value);
        if (front == null) {
            front = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            newNode.prev = end;
            end = newNode;
        }
        count++;
    }

    /**
     * This method adds a given value to the list at the given index, uses addAtFront or addAtEnd if the index specified is a the front or the end
     *
     * @param   ind     the index of the element to add
     * @param   value   a given value of type E to add to the list
     * @throws          IllegalArgumentException if the given index is invalid
     */
    public void addAtPos(int ind, E value) {
        if (ind > count + 1 || ind < 1) {
            throw new IllegalArgumentException("The index must be between one and the size of the list plus one.");
        }
        if (ind == count + 1) {
            this.addAtEnd(value);
        } else if (ind == 1) {
            this.addAtFront(value);
        } else {
            Node<E> newNode = new Node<E>(value);
            Node<E> current = front;
            for (int idx = 1; idx < ind; idx++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            count++;
        }
    }

    /**
     * This method removes an element at the given index, has differnt cases if the element is the only element in the list,
     * or if it is at the front, at the end, or somewhere in the middle of the list
     *
     * @param   ind     the index of the element to remove
     * @throws          IllegalArgumentException if the given index is invalid  
     */
    public void remove(int ind) {
        if (ind > count || ind < 1) {
            throw new IllegalArgumentException("The index must be between one and the size of the list.");
        }
        Node<E> current = front;
        for (int idx = 1; idx < ind; idx++) {
            current = current.next;
        }
        if (current.next == null && current.prev == null) {
            front = null;
            end = null;
        } else if (current.prev == null) {
            current.next.prev = null;
            front = current.next;
        } else if (current.next == null) {
            current.prev.next = null;
            end = current.prev;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        count--;
    }

    /**
     * This method takes in a value of type E and if it finds the value from the second in the list down to the end,
     * it returns true and moves the value up, otherwise it returns false an does nothing
     *
     * @param   value   a given value of type E to move up in the list
     * @return          a boolean variable that expresses whether the given value was moved up or not
     */
    public boolean moveUp(E value) {
        boolean flag = false;
        if (front == null || front.next == null) {
            // do nothing
        } else {
            Node<E> current = front.next;
            while (current.next != null && current.data != value) {
                current = current.next;
            }
            if (current.data == value) {
                if (current.prev.prev == null && current.next == null) {
                    current.prev.next = null;
                    current.prev.prev = current;
                    end = current.prev;
                    front = current;
                    current.next = current.prev;
                    current.prev = null;
                } else if (current.prev.prev == null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    front = current;
                    current.prev.prev = current;
                    current.next = current.prev;
                    current.prev = null;
                } else if (current.next == null) {
                    current.next = current.prev;
                    current.prev = current.prev.prev;
                    current.prev.next = current;
                    end = current.next;
                    current.next.prev = current;
                    current.next.next = null;
                } else {
                    current.prev.prev.next = current;
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    current.prev = current.prev.prev;
                    current.next.prev.prev = current;
                    current.next = current.next.prev;
                }
                flag = true;
            } else {
                // do nothing
            }
        }
        return flag;
    }

    /**
     * This method takes in a value of type E and if it finds the value from the beginning of the list to the second from the bottom,
     * it returns true and moves the value down, otherwise it returns false an does nothing
     *
     * @param   value   a given value of type E to move down in the list
     * @return          a boolean variable that expresses whether the given value was moved down or not
     */
    public boolean moveDown(E value) {
        boolean flag = false;
        if (front == null || front.next == null) {
            // do nothing
        } else {
            Node<E> current = front;
            while (current.next.next != null && current.data != value) {
                current = current.next;
            }
            if (current.data == value) {
                if (current.prev == null && current.next.next == null) {
                    current.next.next = current;
                    current.next.prev = null;
                    front = current.next;
                    end = current;
                    current.prev = current.next;
                    current.next = null;
                } else if (current.prev == null) {
                    current.next.next.prev = current;
                    front = current.next;
                    current.prev = current.next;
                    current.next = current.next.next;
                    current.prev.next = current;
                    current.prev.prev = null;
                } else if (current.next.next == null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.prev = current.next;
                    current.next.next = current;
                    end = current;
                    current.next = null;
                } else {
                    current.next.next.prev = current;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.prev = current.next;
                    current.next = current.next.next;
                    current.prev.next = current;
                }
                flag = true;
            } else {
                // do nothing
            }
        }
        return flag;
    }

    /** 
     * Creates and returns a string representation of this LinkedList
     * 
     * @return  a String showing basic information about the linked list
     */
    @Override
    public String toString() {
        String listOutput = "List contents: ";
        if (front == null) {
            listOutput += "(0 nodes)";
        } else {
            listOutput += "(" + count + " nodes):\n";
            Node<E> current = front;
            listOutput += current;
            while (current.next != null) {
                current = current.next;
                listOutput += current;
            }
        }
        return listOutput;
    }

    private class Node<E> implements Serializable {

        // instance variables
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }

        public String toString() {
            String str = "";
            str += data;
            return str;
        }

    }

}
