
public class Seat {

	private int[][] seats;
	private String showTime;
	private int row;
	private int column;

	// 1 is available 0 otherwise.

	public Seat(String showTime, int row, int column) {
		this.showTime = showTime;
		seats = new int[row][column];
		this.row = row;
		this.column = column;
	}

	public boolean isAvailable(int row, int column) {
		if (seats[row][column] != 0)
			return false;
		return true;
	}

	public void booking(int row, int column) {
		if (isAvailable(row, column))
			seats[row][column] = 1;
	}

	public void unbooking(int row, int column) {
		if (!isAvailable(row, column))
			seats[row][column] = 0;
	}

	public String getShowTime() {
		return this.showTime;
	}

	public int unbookingAll() {
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (this.seats[i][j] == 1) {
					this.seats[i][j] = 0;
					count++;
				}
			}
		}
		return count;
	}

}