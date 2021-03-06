
public class LinkStrand implements IDnaStrand{

	private class Node {
	   	String info;
	   	Node next;
	   	public Node(String s) {
	      	info = s;
	      	next = null;
	   	}
	   }
	
	   private Node myFirst; 
	   private Node myLast;
	   private long mySize;
	   private int myAppends;
	   
	   private int myIndex;
	   private int myLocalIndex;
	   private Node myCurrent;

	
	   public LinkStrand(String s) {
			initialize(s);
			
			//constructs the linkstrand object using initialize method
			
			
		}
	   
	public LinkStrand(){
		this("");
		//default linkstrand constructor that uses an empty string
	}
	
	
	
	@Override
	public long size() {
		
		//returns the size of the dna
		
		return mySize;
	}

	@Override
	public void initialize(String source) {
		// initializes the instance variables for the object
		//sets up linked list
		myFirst = new Node(source);
		myLast = new Node("");
		myLast = myFirst;
		
		myFirst.next = myLast;
		myLast.next = null;
		//myFirst.info = s;
		//myFirst.next = myLast;
		//myLast.info =s;
		//myLast.next = null;
		mySize = source.length();
		myAppends = 0;
		
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
		
	}

	@Override
	public IDnaStrand getInstance(String source) {
		// makes a new linkstrand object for a given dna sequence
		return new LinkStrand(source);
	}

	@Override
	public IDnaStrand append(String dna) {
		/**
		 * adds a new node to the linkstrand
		 * object. The new node is appended
		 * to the end of the linked list.
		 * mySize and myAppend are updated accordingly,
		 * mySize adds the length of the string added
		 * and myAppend just increases by one
		 */
		Node newNode = new Node(dna);
        
        if (myFirst == null) {
            myFirst = newNode;
            myLast = newNode;
            newNode.next = null;
        }
        else {
        	myLast.next= newNode;
        	myLast = newNode;
        }
        
		
	
		mySize += dna.length();
		myAppends += 1;
		
		return this;
	}

	@Override
	public IDnaStrand reverse() {
		/**
		 * for a given linkstrand object
		 * reverse the order. First reverse the
		 * order of string contained in each node
		 * and then the order of the nodes themselves
		 */
		LinkStrand reversed = new LinkStrand();
		Node current = new Node(null);
		current = myFirst;
		
		while (current != null) {
			
			StringBuilder copy = new StringBuilder(current.info);
			copy.reverse();
			Node first = new Node(copy.toString());
			
			first.next = reversed.myFirst;
			if (reversed.myLast == null) {
				reversed.myLast = reversed.myFirst;
				reversed.myLast.next = null;
				
			}
			reversed.myFirst = first;
			reversed.mySize += copy.length();
			reversed.myAppends ++;
			
			
			current = current.next;
			
		}
		return reversed;
	}

	@Override
	public int getAppendCount() {
		// returns the number of times the linkstrand object has been appended
		return myAppends;
	}

	@Override
	public char charAt(int index) {
		/**
		 * returns the character of the LinkStrand
		 * for a particular index as if the the link
		 * strand was just one giant string. It does
		 * this by searching through each node. The time
		 * is O(1) to find the character because it 
		 * relies on three instance variables including
		 * myCurrent - the current node being searched.
		 * This means for adjacent searches you are 
		 * only need to go through the loop once.  
		 */
		if (index >= this.size()) throw new IndexOutOfBoundsException("out of bounds gah");
		if (index<0) throw new IndexOutOfBoundsException("invalid index");

		if (index<myIndex) {
			myIndex = 0;
			myLocalIndex=0;
			myCurrent = myFirst;
		}
		while (myIndex != index) {

			myIndex++;
			myLocalIndex++;
			
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				
				if (myCurrent.next.info == null) throw new IndexOutOfBoundsException("out of nodes");
				myCurrent = myCurrent.next;
				
			}
		}
        return myCurrent.info.charAt(myLocalIndex);
        }
	
	@Override
	public String toString() {
		StringBuilder strand = new StringBuilder("");
		
		Node current = new Node(null);
		current = myFirst;
		//for(int k=0; k<myAppends; k++) {
		while (current!= null) {
			strand.append(current.info);
			//System.out.print(current.info);
			current = current.next;
		}
		//System.out.print(strand.toString());
		//return "aggtccg";
		return strand.toString();
		
	}

}

