/**
	An Interface of an ADT SORTLIST
	
	@author Drue Hidalgo
	@version 1.0
*/

public interface SortedListInterface<T>
{
	/**
		This adds an item to the bottom of the list.
		Must add the item in the appropriate place in order to keep list sorted.
		Size of the list will increase by 1.
		@param item the item that we are adding.
	 */
	public void add(T item);
	
	
	/**
		This removes a specific position in the list.
		Must resort the list after the item is removed.
		Size of the list will decrease by 1.
		@param position the position of the item that is being removed.
		@return the item that was removed.
		@throws EmptyListException if the list is empty.
	 */
	public T remove(int position) throws EmptyListException;
	
	
	/**
		Replaces the item in a certain poistion.
		@param position the position of the item that is being replaced.
		@param item the item that is replacing the item already in the list.
		@return the item that was replaced.
		@throws EmptyListException if the list is empty.
	 */
	public T replace(int position, T item) throws EmptyListException;
	
	
	/**
		Views an Item in a certain position.
		@param position the position of the item that is being viewed.
		@return the item at the specified position.
		@throws EmptyListException if the list is empty.
	 */
	public T view(int position) throws EmptyListException;
	
	/**
		Clears the list of all entries.
	 */
	public void clear();
	
	
	/**
		Check if there is a certain item in the list.
		@param item the item that is being checked.
		@return true if the item is in the list, false otherwise.
	 */
	public boolean contains(T item);
	
}