import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                nodes.add(node);
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node node = this.head;
        if (node == null)
            return false;
        Node previousNode = null;
        boolean isFounded = false;
        while (node != null) {
            if (node.value == _value) {
                isFounded = true;
                if(node == this.head && node == this.tail)
                {
                    this.head = null;
                    this.tail = null;
                    return true;
                }
                else {
                    if (node == this.head) {
                        this.head = node.next;
                        node.next = null;
                        return true;
                    } else {
                        if (node == this.tail) {
                            previousNode.next = null;
                            this.tail = previousNode;
                            return true;
                        } else {
                            previousNode.next = node.next;
                            node.next = null;
                            return true;
                        }
                    }
                }
            }
            previousNode = node;
            node = node.next;
        }
        if(!isFounded)
            return false;
        else
        return true; // если узел был удалён
    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
//        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        if (node == null)
            return;
        Node previousNode = null;
//        boolean isFounded = false;
        while (node != null) {
            if (node.value == _value) {
//                isFounded = true;
                if (IsHeadAndTailEqual(node)) return;
                else {
                    if (node == this.head) {
                        this.head = node.next;
//                        node.next = null;
                        previousNode = node;
                        node = node.next;
                    } else {
                        if (node == this.tail) {
                            previousNode.next = null;
                            this.tail = previousNode;
                            return;
                        } else {
                            previousNode.next = node.next;
                            node = node.next;
//                            node.next = null;
                        }
                    }

                }
            }
            else {
                previousNode = node;
                node = node.next;
            }
        }
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
        Node node = this.head;
        if (node == null)
         return;
//        Node previousNode = null;
        boolean isFoundTail = false;
        while (node != null) {
            if (IsHeadAndTailEqual(node)) return;
            if(isFoundTail)
            {
                isFoundTail = false;
                node = this.head;
            }
            if(node.next == this.tail)
            {
                node.next = null;
                this.tail = node;
                isFoundTail = true;
            }
            else {
//                previousNode = node;
                node = node.next;
            }
        }
    }

    private boolean IsHeadAndTailEqual(Node node) {
        if(node == this.head && node == this.tail)
        {
            this.head = null;
            this.tail = null;
            return true;
        }
        return false;
    }

    public int count() {
        Node node = this.head;

        if (node ==null)
            return 0;
        if(node == this.head && node == this.tail) {
            return 1;
        }
        int count = 1;
        while (node != null) {
            if (node.next != this.tail) {
                count++;
            } else {
                count++;
                return count;
            }
            node = node.next;
        }
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного
        if(_nodeAfter == null && _nodeToInsert == null) {
            return;
        }else
        {
            // если _nodeAfter = null и список пустой,
            // добавьте новый элемент первым в списке
            if (_nodeAfter == null && count()==0) {
                addInTail(_nodeToInsert);
            }
            else
            {
                Node node = this.head;
                while (node != null) {
                    if(node == _nodeAfter)
                    {
                        Node tempNode = node;
                        _nodeToInsert.next = node.next;
                        node.next =   _nodeToInsert ;
                        node.next =_nodeToInsert;
                        return;
                    }
                    else {
                        node = node.next;
                    }
                }
            }
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}