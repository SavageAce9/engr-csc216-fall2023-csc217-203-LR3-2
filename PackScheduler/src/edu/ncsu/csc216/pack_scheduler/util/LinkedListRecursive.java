package edu.ncsu.csc216.pack_scheduler.util;


/**
 * This is a custom implementation of a recursive linked list that doesn’t allow
 * for null elements or duplicate elements as defined by the equals() method.
 * It is used for Faculty objects.
 * @param <E> the type of the list
 * @author Warren Long, David Mond
 */
public class LinkedListRecursive<E> {
	/**
	 * the size of the list
	 */
	private int size;
	/**
	 * the front list node of the list
	 */
	private ListNode front;
	
	/**
	 * Constructor for LinkedListRecursive, initializes the state to represent an empty list.
	 */
	public LinkedListRecursive() {
		front = null;
		size = 0;
	}
	
	/**
	 * Getter for getting the size of the list.
	 * @return returns an integer, size of the list.
	 */
	public int size() {
		return size;
	}
	/**
	 * Method to check if the size of the list is zero, returns true if empty, false if not.
	 * @return Returns a boolean to determine if size of list is empty.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * Gets the data in the list node at a specific index.
	 * @param idx index to get the data from.
	 * @return Returns an element of the data in the list node.
	 */
	public E get(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		return front.getData(idx);
	}
	/**
	 * This implementation will have a public/private pair of methods. The public
	 * method is LinkedListRecursive.contains(E element) and returns a boolean. The
	 * private method is ListNode.contains(E element). The public method handles the
	 * special case of an empty list. If the list is not empty, then the public
	 * method transfers the flow of control to the private ListNode.contains(E
	 * element) method, which completes the recursion to check the elements in the
	 * list.
	 * 
	 * @param value the value for the list to see if it contains
	 * @return true if it contains the value
	 */
	public boolean contains(E value) {
		return contains(front, value);
	}
	
	private boolean contains(ListNode current, E value) {
		if (current == null) {
			return false;
		} else if (current.data == value) {
			return true;
		} else {
			ListNode c = current.next;
			return contains(c, value);
		}
	}

	/**
	 * This implementation will have a public/private pair of methods. The public
	 * method is LinkedListRecursive.add(E element) and returns a boolean. 
	 * 
	 * The
	 * private method is ListNode.add(E element). The public method checks that the
	 * element isn’t already in the list (an IllegalArgumentException is thrown if
	 * the element already exists) and handles the special case of adding a node to
	 * an empty list. 
	 * 
	 * If the list is not empty, then the public method transfers the
	 * flow of control to the private ListNode.add(E element) method, which
	 * completes the recursion to add to element to the end of the list.
	 * 
	 * Don’t forget to increment size on all paths where the element is added!
	 * 
	 * @param value the value to add to the list
	 * @return true if it was added, false otherwise
	 */
	public boolean recursiveAdd(E value) {
		if (size == 0) {
			front = new ListNode(value);
			size++;
			return true;
		} 
		return recursiveAdd(front, value);
	}
	
	private boolean recursiveAdd(ListNode current, E value) {
		// return false if is same
		if (current.data.equals(value)) {
			return false;
		}
		if (current.next == null) {
			current.next = new ListNode(value);
			size++;
			return true;
		} else {
			ListNode c = current.next;
			return recursiveAdd(c, value);
		}
	}
	/**
	 * Class representing a single element in this linked list. Holds data and a single reference to the next element.
	 * 
	 * @author Sam McDonald, Joey Hughes, Winston Cheaz
	 */
	private class ListNode {
		/** The data the node holds */
		private E data;
		/** The next node in the list */
		private ListNode next;
		/**
		 * Creates a new ListNode with only data
		 * @param data Data to put in the listNode
		 */
		public ListNode(E data) {
			this.data = data;
			next = null;
		}
		
		/**
		 * Inserts a ListNode into a list given data and the next node in the list
		 * @param data Data to put in the listNode
		 * @param next The next node in the list
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
		/**
		 * Gets the data in the list node at a specific index.
		 * @param idx index to get the data from.
		 * @return Returns an element of the data in the list node.
		 */
		private E getData(int idx) {
			for(int i = 0; i < idx; i++) {
				front = front.next;
			}
			return front.data;
		}
		
	}
}
