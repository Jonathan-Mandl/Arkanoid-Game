/**
 * public class Counter.
 * this class handles the counters in the game
 */
public class Counter {
    private int count;

    /**
     * public Counter(int count).
     * @param count
     * this method is a constructor
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * public void increase(int number).
     *
     * @param number the input
     *               this method increases the count by an int number.
     */
    public void increase(int number) {
        this.count = this.count + number;

    }


    /**
     * public void decrease(int number).
     * @param number
     * this method subtracts number from current count.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * public int getValue().
     * @return count
     * gets current count.
     */
    public int getValue() {
        return this.count;
    }
}