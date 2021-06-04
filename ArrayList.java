// package arrayList;

@SuppressWarnings("hiding")
public class ArrayList<Integer> { //TODO Generics
	// fields
	int index;
	int size;
	int capacity;
	int[ ] list;
	
	// methods
	ArrayList(){
		index = -1;
		size = 0;
		capacity = 10;
		list = new int[capacity];
	}
	ArrayList(int initialCapacity) { //overloading
		index = -1;
	    size = 0;
	    capacity = initialCapacity;
	    if  (capacity < 0) throw new IllegalArgumentException();
	    else if (capacity == 0) {
	    	list = new int[] {};
	    } else {
	    	list = new int[capacity];
	    }
	}

	public void set(int idx, int val) {
		if (idx >= list.length || idx < 0) throw new IndexOutOfBoundsException();
		list[idx] = val;
	}

	public int get(int idx) {
		if (idx >= 0 && idx < list.length) return  list[idx]; 
		else { 
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void add(int val) {
		index++;
		size++;
		if (index >= capacity) {
			int[ ] newArr = grow();
            newArr[index] = val;
            list = newArr;
		} else { 
			list[index] = val;
		}
	}

	public void add(int idx, int val) { // overloading
		if (idx >= list.length || idx < 0) throw new IndexOutOfBoundsException();
		else { // shift each element one position to the back
			index++;
			size++;
			if (idx >= capacity) {
				int[ ] newArr = grow();
				int temp = newArr[idx];
				newArr[idx] = val;
				for (int i = idx + 1; i < newArr.length; i++) {
					int nextVal = newArr[i];
					newArr[i] = temp;
					temp = nextVal;
				}
				list = newArr;
			} else {
				int temp = list[idx];
				list[idx] = val;
				for (int i = idx + 1; i < list.length; i++) {
					int nextVal = list[i];
					list[i] = temp;
					temp = nextVal;
				}
			}
		}
	}

	public void remove(int idx) {
		// shift each element one position to the front
		if (idx >= list.length || idx < 0) throw new IndexOutOfBoundsException();
		for (int i = idx; i < list.length - 1; i++) {
			list[i] = list[i + 1];
		}
		index--;
		size--;
	}

	public boolean isEmpty() {
		return (list.length == 0) ? true : false;
	}
	
	public int size() {
		return size;
	}

	private int[] grow() { // expand the fixed array size
		// initialize a new array
		// copy value from original array to the new one
		capacity = capacity * 2;
		System.out.println("Now capacity is " + capacity);
		int[] newArr = new int[capacity];
		for (int i = 0; i < list.length; i++) {
			newArr[i] = list[i];
		}
		return newArr;
	}
	
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(12);
		System.out.println("First val: " + al.get(0));
		System.out.println("Size: " + al.size());
		
		ArrayList arrl = new ArrayList(3);
		arrl.add(0);
		arrl.add(2);
		arrl.add(4);
		System.out.println(arrl.get(2));
		arrl.set(2, 20);
		System.out.println(arrl.get(2)); // 20
		System.out.println("ArrayList is now: " + arrl.get(0) + " " + arrl.get(1) + " " + arrl.get(2));
		
		// After growing capacity
		arrl.add(8);
		System.out.println("ArrayList is now: " + arrl.get(0) + " " + arrl.get(1) + " " + arrl.get(2) + " " + arrl.get(3));
		
		arrl.add(3, 6);
		System.out.println("ArrayList is now: " + arrl.get(0) + " " + arrl.get(1) + " " + arrl.get(2) + " " + arrl.get(3) + " " + arrl.get(4));
		
		arrl.remove(2);
		System.out.println(arrl.get(2)); // 6
		System.out.println(arrl.get(3)); // 8
		System.out.println("ArrayList is now: " + arrl.get(0) + " " + arrl.get(1) + " " + arrl.get(2) + " " + arrl.get(3) + " " + arrl.get(4));
	}
}

