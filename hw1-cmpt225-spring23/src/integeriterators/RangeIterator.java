package integeriterators;

public class RangeIterator implements IntegerIterator
{
	int initialValue;
	int currentValue; //automatically be initialized = 0
	int endValue;
	boolean isFinite = false;
	/**
	 * Creates an iterator for the infinite sequence 0,1,2,...
	 */
	public RangeIterator() {
		this(0);
    }
	
	/**
	 * Creates an iterator for the infinite sequence s,s+1,s+2...
	 */
	public RangeIterator(int s) {
		initialValue = s;
		currentValue = initialValue;
	}
	
	/**
	 * Creates an iterator for the finite sequence [s,s+1,s+2...t-1]
	 * @throws IllegalArgumentException if t<s
	 */
	public RangeIterator(int s, int t) {
		this(s);
		endValue = t;
		isFinite = true;
		if (initialValue > endValue){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public boolean hasNext() {
		if (isFinite){
            return currentValue < endValue;
		}
		return true;
	}
	
	@Override
	public Integer next() {
		if (hasNext()){
			return currentValue++;
		}
		return null;
    }
	
	public void reset() {
		currentValue = initialValue;
	}
}
