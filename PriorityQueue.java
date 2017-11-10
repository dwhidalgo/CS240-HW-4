/**
   An ADT Priority Queue implemented using singly-linked nodes.
   @author Drue Hidalgo
   @version 1.0
*/

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>
{
	private Node<T> front; 
	private Node<T> back; 
	private int size;
	
	public PriorityQueue()
	{
		front.setNext(null);
		back.setNext(null);
		size = 0;
	}
	
	public void add(T newEntry)
	{
		Node<T> newNode = new Node<T>(newEntry, back);
		Node<T> backNode = back;
		Node<T> frontNode = back;
		
		if(size == 0)
		{
			front = newNode;
			back = newNode;
		}
		
		else if(newNode.compareTo(front) <=0)
		{
			front.setNext(newNode);
			newNode.setNext(null);
			front = newNode;
		}
		
		else
		{
			while(newNode.compareTo(frontNode) < 0)
			{
				backNode = frontNode;
				frontNode = frontNode.getNext();
			}
		
			newNode.setNext(frontNode); 
			backNode.setNext(newNode); 
		}
		
		size++;
	}
	
	public T remove()
	{
		Node<T> checker = back;
		T removed = front.getData();
		if(size == 1)
		{
			clear(); 
			return removed;
		}
		
		while(checker.getNext() != front)
		{
			checker = checker.getNext();
		}
		
		checker.setNext(null);
		front = checker;
		
		size--;
		
		return removed;
	}
	
	public T peek()
	{
		return front.getData();
	}
	
	public void clear()
	{
		
		Node<T> checker = back;
		Node<T> remover = back;
		
		while(checker.getNext()!=null)
		{
			remover = checker;
			checker = checker.getNext();
			remover.setNext(null);
			remover = null;
		}
		
		front = null;
		back = null;
		
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	public int getSize()
	{
		return size;
	}

	
	public class Node<T extends Comparable<T>> implements Comparable<Node<T>>
	{
		private T data;
		private Node<T> next;
		
		public Node(T d, Node<T> n)
		{
			data = d;
			next = n;
		}
		
		public int compareTo(Node<T> n) 
		{
			T front = this.getData();
			T behind = this.getData();
			return (behind.compareTo(front)); 
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