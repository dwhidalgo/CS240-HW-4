/**
	A sorted list ADT using Double Linked Nodes
	.
	
	@author Drue Hidalgo
	@version 1.0
*/

public class SortedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements SortedListInterface<T>
{
    public void add(T item)
    {
        if (isEmpty())
        {
            super.add(item);
        }
        else if (nodes == 1)
        {
            if (tail.getData().compareTo(item) < 0) //tail < item
            {
                add(2, item);
            }
            else
            {
                add(1, item);
            }
        }
        else
        {
            DLNode<T> temp = tail;
            int pos = 1;
            while (temp.getData().compareTo(item) < 0 && temp.getNext() != null)
            {
                temp = temp.getNext();
                pos++;
            }
            if (head.getData().compareTo(item) < 0)
            {
                super.add(item);
            }
            else
            {
                add(pos, item);
            }
        }
    }
}
