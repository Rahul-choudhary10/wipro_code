package day23;

public class Pair <T,U> {

	 private T first;
	    private U second;

	    public Pair(T first, U second) {
	        this.first = first;
	        this.second = second;
	    }

	    public T getFirst() {
	        return first;
	    }

	    public U getSecond() {
	        return second;
	    }

	    public void setFirst(T first) {
	        this.first = first;
	    }

	    public void setSecond(U second) {
	        this.second = second;
	    }

	    public Pair<U, T> getReversedPair() {
	        return new Pair<>(second, first);
	    }

	    @Override
	    public String toString() {
	        return "Pair{" +
	                "first=" + first +
	                ", second=" + second +
	                '}';
	    }

	    public static void main(String[] args) {
	        Pair<String, Integer> originalPair = new Pair<>("Hello", 123);
	        System.out.println("Original Pair: " + originalPair);

	        Pair<Integer, String> reversedPair = originalPair.getReversedPair();
	        System.out.println("Reversed Pair: " + reversedPair);
	    }
}
