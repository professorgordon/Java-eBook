import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListJavaAPIDemo
{
    public static void main(String[] args)
    {
        LinkedList< Integer > intList = new LinkedList< Integer >();
        intList.add(555555);
        intList.add(666666);
        intList.add(888888);
        intList.add(999999);
        intList.add(111111);
        printList(intList);
        intList.addFirst(222222);
        printList(intList);
        intList.removeFirstOccurrence(888888);
        intList.removeFirstOccurrence(222222);
        intList.removeFirstOccurrence(111111);
        printList(intList);
    }

    private static void printList(LinkedList< Integer > intList)
    {
        Iterator< Integer > it = intList.iterator();
        System.out.print("List: ");
        while (it.hasNext())
        {
            System.out.print(it.next() + " -> ");
        }
        System.out.println("null");
    }
}