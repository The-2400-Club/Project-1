/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    INCOMPLETE DEFINITION; includes definitions for the methods add,
    toArray, isEmpty, and getCurrentSize.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public final class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode = null;
      numberOfEntries = 0;
	} // end default constructor

	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                                 // (firstNode is null if chain is empty)
      firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
      
		return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      } // end while
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. */
	public int getCurrentSize()
	{
		return numberOfEntries;
	} // end getCurrentSize

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
	public T remove()
   {
       T result = null;
    if (firstNode != null)
    {
         result = firstNode.getData();
         firstNode = firstNode.getNextNode(); // Remove first node from chain
         numberOfEntries--;
     } // end if
      
     return result;
   } // end remove
   
   /** Removes one occurrence of a given entry from this bag, if possible.
   @param anEntry  The entry to be removed.
   @return  True if the removal was successful, or false otherwise. */
   public boolean remove(T anEntry)
   {
     boolean result = false;
     Node nodeN = getReferenceTo(anEntry);
     
     if (nodeN != null)
      {
        // Replace located entry with entry in first node
        nodeN.setData(firstNode.getData()); 
        // Remove first node
        firstNode = firstNode.getNextNode(); 
        numberOfEntries--;
        
        result = true;
      } // end if
 
     return result;
    } // end remove
	
	/** Locates a given entry within this bag.
         Returns a reference to the node containing the 
         entry, if located, or null otherwise.*/ 
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while
                 
        return currentNode;
    } // end getReferenceTo

    /** Removes all entries from this bag. */
	public void clear()
   {
     while(!isEmpty())
     {
        remove();
     }
   } // end clear
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
   {
       int frequency = 0;

      int counter = 0;
      Node currentNode = firstNode;
      while((counter < numberOfEntries) && (currentNode != null))
      {
          if(anEntry.equals(currentNode.getData()))
          {
              frequency++;
          } // end if

          counter++;
          currentNode = currentNode.getNextNode();
      } // end while

      return frequency;
   } // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to locate.
		 @return  True if the bag contains anEntry, or false otherwise. */
	public boolean contains(T anEntry)
   {
      boolean found = false;
      Node currentNode = firstNode;

      while(!found && (currentNode != null))
      {
          if(anEntry.equals(currentNode.getData()))
          {
              found = true;
          }
          else
          {
              currentNode = currentNode.getNextNode();
          }
      }// end while
      return found;
   } // end contains

   public BagInterface<T> union(BagInterface<T> bag2)
   {
      LinkedBag<T> result = new LinkedBag<T>();

      T[] bagArray2 = bag2.toArray(); //Convert to an array
      for (int i = 0; i < bagArray2.length; i++)
      {
         result.add(bagArray2[i]); //Iterate through the array and add to new bag
      }

      T[] bagArray1 = this.toArray();  //Repeat again with bag2
      for (int i = 0; i < bagArray1.length; i++)
      {
         result.add(bagArray1[i]);
      }

      return result;
   } 

   public BagInterface<T> intersection(BagInterface<T> bag2)
   {
      LinkedBag<T> result = new LinkedBag<T>(); //create new bag

      T[] bagArray1 = this.toArray();  //convert to arrays
      T[] bagArray2 = bag2.toArray();

      for (int i = 0; i < bagArray1.length; i++)
      {
         for(int j = 0; j < bagArray2.length; j++)
         {
             if(bagArray1[i] == bagArray2[j])
             {
                 result.add(bagArray1[i]); //add shared entries
             }
         }
      }

      return result;
   } 

   public BagInterface<T> difference(BagInterface<T> bag2)
   {
      LinkedBag<T> result = this;

          T[] bagArray1 = this.toArray(); //convert to arrays
          T[] bagArray2 = bag2.toArray();

          for (int i = 0; i < bagArray1.length; i++)
          {
             for(int j = 0; j < bagArray2.length; j++)
             {
                 if(bagArray1[i] != bagArray2[j])
                 {
                     result.add(bagArray1[i]); //add entries not shared by both arrays
                 }
             }
          }

          return result;
   } 

	private class Node
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor

		private T getData()
		{
		    return data;
		} // end getData

		private void setData(T newData)
		{
		    data = newData;
		} // end setData

		private Node getNextNode()
		{
		    return next;
		} // end getNextNode

		private void setNextNode(Node nextNode)
		{
		    next = nextNode;
		} // end setNextNode

  	  } // end Node
} // end LinkedBag
