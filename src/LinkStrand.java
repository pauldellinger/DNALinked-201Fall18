
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
			
			
			
			
		}
	   
	public LinkStrand(){
		this("");
	}
	
	
	
	@Override
	public long size() {
		// TODO Auto-generated method stub
		
		
		return mySize;
	}

	@Override
	public void initialize(String source) {
		// TODO Auto-generated method stub
		myFirst = new Node(source);
		
		
		
		myFirst.next = myLast;
		
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
		// TODO Auto-generated method stub
		return new LinkStrand(source);
	}

	@Override
	public IDnaStrand append(String dna) {
		// TODO Auto-generated method stub
		Node newNode = new Node(dna);
        //newNode.info = null;
        if (myFirst == null) {
            myFirst = newNode;
            myLast = newNode;
            newNode.next = null;
        }
        else {
        	myFirst.next= newNode;
        	myLast = newNode;
        }
        
		
	
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
	
		while (current != null) {
			StringBuilder copy = new StringBuilder(current.info);
			copy.reverse();
			Node first =new Node(copy.toString());
			
			first.next = reversed.myFirst;
			reversed.myFirst = first;
			//reversed.append(copy.toString());
			//reversed.myFirst = reversed.myLast.next;
			current = current.next;
			
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
