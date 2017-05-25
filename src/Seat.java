
/**
 * The seat class that contain detail of the seats.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class Seat {

	private int[][] seats; // 1 is available 0 otherwise.
	private String showTime;

	/**
	 * Constructor for initialize seat by show time, row and column.
	 * 
	 * @param showTime
	 *            is show time of seat.
	 * @param row
	 *            is row of seat.
	 * @param column
	 *            is column of seat.
	 */
	public Seat(String showTime, int row, int column) {
		this.showTime = showTime;
		seats = new int[row][column];
	}

	/**
	 * Check that row and column is available or not.
	 * 
	 * @param row
	 *            is the row of the seat.
	 * @param column
	 *            is the column of the seat.
	 * @return true if available, false otherwise.
	 */
	public boolean isAvailable(int row, int column) {
		if (seats[row][column] != 0)
			return false;
		return true;
	}

	/**
	 * Reserve the seat by given row and column.
	 * 
	 * @param row
	 *            is the row of the seat.
	 * @param column
	 *            is the column of the seat.
	 */
	public void booking(int row, int column) {
		if (isAvailable(row, column))
			seats[row][column] = 1;
	}

	/**
	 * Unreserve the seat by given row and column.
	 * 
	 * @param row
	 *            is the row of the seat.
	 * @param column
	 *            is the column of the seat.
	 */
	public void unbooking(int row, int column) {
		if (!isAvailable(row, column))
			seats[row][column] = 0;
	}

	/**
	 * Get the show time of that seat.
	 * 
	 * @return the show time.
	 */
	public String getShowTime() {
		return this.showTime;
	}

	/**
	 * Unreserve all the seats.
	 * 
	 * @return the number of unreserve.
	 */
	public int unbookingAll() {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (this.seats[i][j] == 1) {
					this.seats[i][j] = 0;
					count++;
				}
			}
		}
		return count;
	}

}