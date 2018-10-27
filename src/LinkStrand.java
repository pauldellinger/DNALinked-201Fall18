
public class LinkStrand implements IDnaStrand{

	private class Node {
	   	String info;
	   	Node next;
	   	public Node(String s) {
	      	info = s;
	      	next = null;
	   	}
	   }
	   private Node myFirst, myLast;
	   private long mySize;
	   private int myAppends;
	   
	   private int myIndex;
	   private int myLocalIndex;
	   private Node myCurrent;

	
	
	public LinkStrand(){
		this("");
	}
	
	public LinkStrand(String s) {
		initialize(s);
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}
	
	@Override
	public long size() {
		// TODO Auto-generated method stub
		
		
		return mySize;
	}

	@Override
	public void initialize(String source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IDnaStrand getInstance(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDnaStrand append(String dna) {
		// TODO Auto-generated method stub
		myLast.next = new Node(dna);
		myLast = new Node(dna);
		mySize += dna.length();
		myAppends += 1;
		
		return this;
	}

	@Override
	public IDnaStrand reverse() {
		// TODO Auto-generated method stub
		LinkStrand reversed = new LinkStrand();
		Node current = new Node(null);
		current = myFirst;
		Node first =new Node(null);
		
		
		while (current.next != null) {
			StringBuilder copy = new StringBuilder(current.info);
			copy.reverse();
			
			reversed.append(copy.toString());
			reversed.myFirst = reversed.myLast.next;
			/**
			 * 
			 
			Node new_first = new Node(null);
			new_first.next = first;	
			new_first.info = copy.toString();
			*/
			
			
		}
		
			
		return reversed;
	}

	@Override
	public int getAppendCount() {
		// TODO Auto-generated method stub
		return myAppends;
	}

	@Override
	public char charAt(int index) {
		
		int myIndex = 0;
		int myLocalIndex = 0;
		
		while (myIndex != index) {
			myIndex++;
			myLocalIndex++;
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
		}
           return myCurrent.info.charAt(myLocalIndex);
        }
	
	@Override
	public String toString() {
		StringBuilder strand = new StringBuilder();
		
		Node current = new Node(null);
		current = myFirst;
		while (current.next != null) {
			strand.append(myFirst.info);
			current = current.next;
		}
		
		return strand.toString();
	}

}
