package integeriterators;

import java.util.ArrayList;
import java.util.List;

public class ArrayIterator implements IntegerIterator
{
	List<Integer> array;
	boolean isCircular;
	int index;
	/**
	 * Creates an iterator for ar 
	 */
	public ArrayIterator(int[] ar) {
		this.array = new ArrayList<>();
        for (int j : ar) {
            this.array.add(j);
        }
		index = 0;
		this.isCircular = false;
	}
	
	/**
	 * Creates an iterator for the ar
	 * If isCircular is true, the iterator will be infinite,
	 * outputting the array in circle 
	 * ar[0],ar[1]...ar[ar.length-1],ar[0],ar[1]...ar[ar.length-1],ar[0]...
	 */
	public ArrayIterator(int[] ar, boolean isCircular) {
		this(ar); //not this.ArrayIterator(ar)
		this.isCircular = isCircular;
	}
	
	@Override
	public boolean hasNext() {
        return isCircular || index < this.array.size();
    }
	
	@Override
	public Integer next() {
		if (!isCircular) {
			if (hasNext()) {
				return this.array.get(index++);
			}
			return null;
		} else {
			if (index == this.array.size()) { //not array.size() - 1 because we're using arraylist
				index = 0;
			}
			return this.array.get(index++);
		}
    }
	
	public void reset() {
		index = 0;
	}
}
