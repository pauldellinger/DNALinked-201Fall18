
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
		// returns the number the linkstrand object has been appended
		return myAppends;
	}

	@Override
	public char charAt(int index) {
		if (index >= this.size()) throw new IndexOutOfBoundsException("out of bounds gah");
		//System.out.print("my node: " + myCurrent.info+ "\n");
		//System.out.print("my NEXT node: " + myCurrent.next.info);
		
		while (myIndex != index) {
			//System.out.print("up 1 "+"\n");
			
			if (index<myIndex) {
				myIndex = 0;
				myLocalIndex=0;
				myCurrent = myFirst;
			}
			
			myIndex++;
			myLocalIndex++;
			
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				//System.out.println("my char: " +myCurrent.info.charAt(myLocalIndex) + "\n");
				if (myCurrent.next.info == null) throw new IndexOutOfBoundsException("out of nodes");
				myCurrent = myCurrent.next;
				//while(myCurrent.info == "") myCurrent = myCurrent.next;
				//System.out.print("next node: "+ myCurrent.info);
				//System.out.print("\n"+"do we get here?");
				
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

