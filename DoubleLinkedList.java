/**
	A list ADT using Double Linked Nodes.
	
	@author Drue Hidalgo
	@version 1.0
*/

public class DoubleLinkedList<T> implements ListInterface<T>
{
	private Node<T> bottom = new Node(null, null, null);
	private Node<T> top = new Node(null, null, null);
	private int size = 0;
	
	public DoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
	
	public void add(T newItem) 
	{
		Node<T> newNode = new Node(newItem, null, null);
		if(top == null)
		{
			head = newNode;
			tail = newNode;
		}
		
		else
		{
			head.setNext(newNode);
            newNode.setPrev(head);
            head = newNode;
		}
		size++;
	}

	public T remove(int position) throws EmptyListException
	{
		if(position < 1 || position > size)
		{
			throw new EmptyListException();
		}
		
		else
		{
			DLNode<T> before = tail;
			T temp;
			
			if(size == 1)
			{
				DLNode<T> before = tail;
				clear();
			}
			
			else if (position == 1)
            {
                DLNode<T> newTail = tail.getNext();
                temp = tail.getData();
                tail.setData(null);
                newTail.setPrev(null);
                tail.setNext(null);
                tail = newTail;
                nodes--;
            }
            else
            {
                DLNode<T> remove = tail.getNext();
                for (int i=2; i<position; i++)
                {
                    before = before.getNext();
                    remove = before.getNext();
                }
                temp = remove.getData();
                if (remove.getNext() == null)
                {
                    before.setNext(null);
                    remove.setPrev(null);
                    head = before;
                }
                else
                {
                    remove.getNext().setPrev(before);
                    before.setNext(remove.getNext());
                    remove.setPrev(null);
                    remove.setNext(null);
                }
                remove.setData(null);
                nodes--;
            }
            return temp;
		}
	}


	public T view(int position) throws EmptyListException
	{
		if(position < 1 || position > size)
		{
			throw new EmptyListException();
		}
		
		else
        {
            DLNode<T> temp = tail;
            for (int i=1; i< position; i++)
            {
                temp = temp.getNext();
            }
            return temp.getData();
        }
	}

	public int getLength() 
	{
		return size;
	}

	public boolean isEmpty() 
	{
		return (size == 0);
	}

	public void clear() 
	{
		Node<T> temp = top;
		while(!isEmpty())
		{
			temp.setPrevious(null);
			canGo = true;
			temp = temp.getNext();
		}
		
		size = 0;
		top = null;
		bottom = null;
		temp = null;
	}
	
	
	
	class Node<T>
	{
		private T data;
		private Node<T> previous;
		private Node<T> next;
		
		public Node(T d, Node<T> p, Node<T> n)
		{
			data = d;
			previous = p;
			next = n;
		}
		
		public T getData()
		{
			return data;
		}
		
		public Node<T> getPrevious()
		{
			return previous;
		}
		
		public Node<T> getNext()
		{
			return next;
		}
		
		public void setData(T d)
		{
			data = d;
		}
		
		public void setPrevious(Node<T> p)
		{
			previous = p;
		}
		
		public void setNext(Node<T> n)
		{
			next = n;
		}
	}
}