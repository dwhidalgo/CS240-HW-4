/**
	A list ADT using Nodes.
	
	@author Drue Hidalgo
	@version 1.0
*/

public class ListLinkedData<T> implements ListInterface<T>
{
	private int size = 0;
	private Node top = null;
	private Node bottom = null;
	
	public void add(Object newItem) 
	{
		Node<T> newNode = new Node(newItem, null);
		if(top == null)
		{
			top = newNode;
			bottom = newNode;
			newNode.setNext(null);
		}
		else
		{
			newNode.setNext(bottom);
			bottom = newNode;
		}
		
		size++;
	}

	public T remove(int position) throws EmptyListException 
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}
		
		Node<T> Node = bottom;
		
		for(int i = size; i > position + 1; i--)
		{
			Node = Node.getNext();
		}
		
		Node<T> removed = Node.getNext();
		
		if(Node == bottom)
			bottom = bottom.getNext();
		
		else if(Node.getNext().getNext() == null)
		{
			top.setData(null);
			top = Node;
		}
		
		else
		{
			Node.getNext().setData(null);
			Node.setNext(Node.getNext().getNext()); 
		}
		
		size--;
		
		return removed.getData();
		
	}


	public T view(int position) throws EmptyListException 
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}
		
		Node<T> viewNode = top;
		
		for(int i=1;i<position;i++)
		{
			viewNode = viewNode.getNext();
		}
		
		return viewNode.getData();
	}


	public boolean contains(T item) 
	{	
		boolean isThere = false;
		Node<T> temp = top;
		
		for(int i=0;i<size;)
		{
			if(temp == item)
				isThere = true;
			temp = temp.getNext();
		}
		
		return isThere;
	}


	public int getLength() 
	{
		return size;
	}

	public boolean isEmpty() 
	{
		return (size == 0);
	}


	public T replace(int position, T item) throws EmptyListException 
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}
		
		Node<T> temp = bottom;
		
		for(int i=size;i>position+1;i--)
		{
			temp = temp.getNext();
		}
		T replace = (temp.getNext()).getData();
		(temp.getNext()).setData(item);
		
		
		return replace;
	}

	
	public void clear() 
	{
		Node<T> clearer = bottom;
		Node<T> previous = clearer;
		int i=1;
		while(!isEmpty())
		{
			clearer = clearer.getNext();
			previous = null;
			previous = clearer;
			size--;
		}
		size = 0;
		clearer = null;
	}
	
	public class Node<T>
	{
		private T data;
		private Node<T> next;
		
		public Node(T d, Node<T> n)
		{
			data = d;
			next = n;
		}
		
		public Node()
		{
			data = null;
			next = null;
		}
		
		public T getData()
		{
			return data;
		}
		
		public Node<T> getNext()
		{
			return next;
		}
		
		public void setNext(Node<T> n)
		{
			next = n;
		}
		
		public void setData(T d)
		{
			data = d;
		}
		
	}
	
}