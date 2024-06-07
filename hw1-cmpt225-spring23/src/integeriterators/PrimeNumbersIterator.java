package integeriterators;

public class PrimeNumbersIterator implements IntegerIterator {
	int initialValue;
	int currentValue;
	public PrimeNumbersIterator() {
		this(2);
	}
	
	public PrimeNumbersIterator(int n) {
		if (isNotPrime(n)){
			initialValue = getNextPrime(n);
		}
		else {
			initialValue = n;
		}
		currentValue = initialValue;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}
	
	@Override
	public Integer next() {
		Integer result = currentValue;
		currentValue = getNextPrime(currentValue);
		return result;
	}
	
	public void reset() {
		currentValue = initialValue;
	}
	private Integer getNextPrime(int n){
		int nextNumber = n + 1;
		while (isNotPrime(nextNumber)) {
			nextNumber++;
		}
		return nextNumber;
	}
	private boolean isNotPrime(int n){
		if (n <= 1){
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++){
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}
}
