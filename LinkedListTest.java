
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    //1. Добавьте в класс LinkedList метод удаления одного узла по его значению.
    public void LinkedListShouldDeleteFirstFromMany() {
        LinkedList linkedList = new LinkedList();

        int valueToDelete = 12;
        int valueSecond = 55;
        int valueThird = 69;
        Node node1 = new Node(valueToDelete);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        assertEquals(true, linkedList.remove(valueToDelete), "result must be true");
        assertEquals(valueSecond, linkedList.head.value, "result must be " + valueSecond);
        assertEquals(valueThird, linkedList.tail.value, "result must be " + valueThird);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldDeleteLastFromMany() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 12;
        int valueSecond = 55;
        int valueThird = 69;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        assertEquals(true, linkedList.remove(valueThird), "result must be true");
        assertEquals(valueFirst, linkedList.head.value, "result must be " + valueFirst);
        assertEquals(valueSecond, linkedList.tail.value, "result must be " + valueSecond);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldDeleteFirstFromOne() {
        LinkedList linkedList = new LinkedList();

        int valueToDelete = 12;

        Node node1 = new Node(valueToDelete);

        linkedList.addInTail(node1);


        assertEquals(true, linkedList.remove(valueToDelete), "result must be true");
        assertEquals(null, linkedList.head, "result must be null");
        assertEquals(null, linkedList.tail, "result must be null");
    }

    @Test
    public void LinkedListShouldDeleteAverageFromMany() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 12;
        int valueSecond = 55;
        int valueThird = 69;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        assertEquals(true, linkedList.remove(valueSecond), "result must be true");
        assertEquals(valueFirst, linkedList.head.value, "result must be " + valueFirst);
        assertEquals(node3, linkedList.head.next, "result must be " + valueThird);
        assertEquals(valueThird, linkedList.tail.value, "result must be " + valueThird);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    //    2. Добавьте в класс LinkedList метод удаления всех узлов по конкретному значению.
    @Test
    public void LinkedListShouldDeleteAllTwoFromMany() {
        LinkedList linkedList = new LinkedList();

        int valueToDelete = 12;
        int valueSecond = 55;

        Node node1 = new Node(valueToDelete);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueToDelete);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        linkedList.removeAll(valueToDelete);
        assertEquals(valueSecond, linkedList.head.value, "result must be "+valueSecond);
        assertEquals(valueSecond, linkedList.tail.value, "result must be " + valueSecond);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldDeleteAllOneAverageFromMany() {
        LinkedList linkedList = new LinkedList();

        int valueToDelete = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueSecond);
        Node node2 = new Node(valueToDelete);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        linkedList.removeAll(valueToDelete);
        assertEquals(valueSecond, linkedList.head.value, "result must be "+valueSecond);
        assertEquals(node3, linkedList.head.next, "result must be "+node3);
        assertEquals(valueThird, linkedList.tail.value, "result must be " + valueThird);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldDeleteAllOneOnlyLast() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        linkedList.removeAll(valueThird);
        assertEquals(valueFirst, linkedList.head.value, "result must be "+valueFirst);
        assertEquals(node2, linkedList.head.next, "result must be "+node2);
//        assertEquals(valueThird, linkedList.tail.value, "result must be " + valueThird);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldDeleteAllOneOnlyFirst() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueSecond);
        Node node2 = new Node(valueFirst);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        linkedList.removeAll(valueFirst);
        assertEquals(valueSecond, linkedList.head.value, "result must be "+valueSecond);
        assertEquals(node3, linkedList.head.next, "result must be "+node3);
//        assertEquals(valueThird, linkedList.tail.value, "result must be " + valueThird);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldClear() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueSecond);
        Node node2 = new Node(valueFirst);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        linkedList.clear();

        assertEquals(null, linkedList.head, "result must be null");
        assertEquals(null, linkedList.tail, "result must be null");
    }

    @Test
    public void LinkedListShouldCount3() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        assertEquals(3, linkedList.count(), "result must be "+3);
    }

    @Test
    public void LinkedListShouldCount2() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);


        assertEquals(2, linkedList.count(), "result must be "+2);
    }

    @Test
    public void LinkedListShouldCount1() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;

        Node node1 = new Node(valueFirst);
        linkedList.addInTail(node1);

        assertEquals(1, linkedList.count(), "result must be "+1);
    }

    @Test
    public void LinkedListShouldAddAfterFirst() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        int valuefour= 4;
        Node node4 = new Node(valuefour);
        linkedList.insertAfter(node1, node4);

        assertEquals(4, linkedList.count(), "result must be "+4);
        assertEquals(node4, linkedList.head.next, "result must be "+node4);
        assertEquals(node4.next, node2, "result must be "+node2);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldAddBeforeEmptyList() {
        LinkedList linkedList = new LinkedList();

        int valuefour= 4;
        Node node4 = new Node(valuefour);
        linkedList.insertAfter(null, node4);

        assertEquals(1, linkedList.count(), "result must be "+1);
        assertEquals(null, linkedList.head.next, "result must be null");
        assertEquals(null, linkedList.tail.next, "result must be null");
    }

    @Test
    public void LinkedListShouldAddBeforeFirst() {
        LinkedList linkedList = new LinkedList();

        int valueFirst = 1;
        int valueSecond = 2;
        int valueThird = 3;
        Node node1 = new Node(valueFirst);
        Node node2 = new Node(valueSecond);
        Node node3 = new Node(valueThird);
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);
        linkedList.addInTail(node3);

        int valuefour= 4;
        Node node4 = new Node(valuefour);
        linkedList.insertAfter(null, node4);

        assertEquals(4, linkedList.count(), "result must be "+4);
        assertEquals(node4.value, linkedList.head.value, "result must be "+node4.value);
        assertEquals(node4.next, node2, "result must be "+node2);
        assertEquals(null, linkedList.tail.next, "result must be null");
    }
}