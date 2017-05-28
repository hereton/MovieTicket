package movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Ticket class that perform and get information of the selected movie.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class Ticket {

	private Theater currentTheater;
	private Theater tempTheater;
	private Seat currentSeat;
	private Movie tempMovie;
	private Movie realObjectMovie;
	private int count; // count the number of booking.
	private List<String> description = new ArrayList<>();

	/**
	 * Set the current movie.
	 * 
	 * @param movie
	 *            is the movie that you want to set.
	 */
	public void setMovie(Movie movie) {
		this.resetAll();
		realObjectMovie = movie;
		tempMovie = createCopyMovie(movie);
	}

	/**
	 * Handle when user confirm to buy the ticket.
	 */
	public void confirm() {
		for (String s : this.tempMovie.getTheater().keySet())
			for (String x : this.tempMovie.getTheater().get(s).getSeats().keySet()) {
				int row = this.tempMovie.getTheater().get(s).getRow();
				int column = this.tempMovie.getTheater().get(s).getColumn();
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						if (!this.tempMovie.getTheater().get(s).getSeats().get(x).isAvailable(i, j))
							this.realObjectMovie.getTheater().get(s).getSeats().get(x).booking(i, j);
					}
				}
			}
		this.resetAll();
	}

	/**
	 * Get all descriptions of booking.
	 * 
	 * @return all descriptions with an array of String.
	 */
	public String[] getDescription() {
		String[] allDescription = new String[this.description.size()];
		return this.description.toArray(allDescription);
	}

	/**
	 * Check that seat has been clicked or not.
	 * 
	 * @param row
	 *            is the row of the seat.
	 * @param column
	 *            is the column of the seat.
	 * @return true if has clicked, false otherwise.
	 */
	public boolean isChecked(int row, int column) {
		if (currentSeat.isAvailable(row, column))
			return false;
		return true;
	}

	/**
	 * Handle clear button for unbooking all the seat in that show time.
	 * 
	 * @param row
	 *            is the row of the seat.
	 * @param column
	 *            is the column of the seat.
	 */
	public void unbooking(int row, int column) {
		this.currentSeat.unbooking(row, column);
		description.remove(currentTheater.getName() + "-" + currentSeat.getShowTime() + "-" + (row + 1) + ","
				+ (column + 1) + "-" + currentTheater.getPrice());
		count--;
	}

	/**
	 * Booking the given seat.
	 * 
	 * @param row
	 *            is the row of the seat.
	 * @param column
	 *            is the column of the seat.
	 */
	public void booking(int row, int column) {
		this.currentSeat.booking(row, column);
		description.add(currentTheater.getName() + "-" + currentSeat.getShowTime() + "-" + (row + 1) + ","
				+ (column + 1) + "-" + currentTheater.getPrice());
		count++;
	}

	/**
	 * Get the total price.
	 * 
	 * @return the current theater price.
	 */
	public double getTotalPrice() {
		return this.currentTheater.getPrice() * this.getAmount();
	}

	/**
	 * Get the current movie.
	 * 
	 * @return the current movie.
	 */
	public Movie getCurrentMovie() {
		return this.tempMovie;
	}

	/**
	 * Get the current theater object.
	 * 
	 * @return the current theater object.
	 */
	public Theater getCurrentTheater() {
		return this.currentTheater;
	}

	/**
	 * set the current show time.
	 */
	public void setCurrentShowtime(String showtime) {
		this.currentSeat = tempTheater.getSeats().get(showtime);
	}

	/**
	 * Get the current show time.
	 * 
	 * @return the current show time.
	 */
	public Seat getCurrentShowtime() {
		return this.currentSeat;
	}

	/**
	 * Set the current theater.
	 * 
	 * @param theater
	 *            is theater that you want to set.
	 */
	public void setCurrentTheater(String theater) {
		this.currentTheater = this.realObjectMovie.getTheater().get(theater);
		this.tempTheater = this.tempMovie.getTheater().get(theater);
	}

	/**
	 * Get the number of clicked seat.
	 * 
	 * @return the number of clicked seat.
	 */
	public int getAmount() {
		return this.count;
	}

	/**
	 * Get the current theater price.
	 * 
	 * @return the current theater price.
	 */
	public double getPrice() {
		return this.currentTheater.getPrice();
	}

	/**
	 * Reset all clicked seats.
	 */
	public void resetAll() {
		if (this.tempMovie != null) {
			for (String s : this.tempMovie.getTheater().keySet()) {
				for (String x : this.tempMovie.getTheater().get(s).getSeats().keySet())
					this.tempMovie.getTheater().get(s).getSeats().get(x).unbookingAll();
			}
			count = 0;
			this.description = new ArrayList<>();
		}
	}

	/**
	 * Reset all clicked seats in current show time.
	 */
	public void reset() {
		int number_deleted = this.currentSeat.unbookingAll();
		this.count -= number_deleted;
		for (int i = 0; i < this.description.size(); i++)
			if (description.get(i).contains(this.currentTheater.getName()))
				description.remove(i);
	}

	/**
	 * Create a copy of movie object.
	 * 
	 * @param movie
	 *            is the Movie object that you want to copy.
	 * @return the movie object
	 */
	public Movie createCopyMovie(Movie movie) {
		Movie copy = new Movie(movie.getTitle(), movie.getDescription(), movie.getLength());
		// add theater to copy
		for (String s : movie.getTheater().keySet()) {
			String copyName = s;
			double copyPrice = movie.getTheater().get(s).getPrice();
			int copyRow = movie.getTheater().get(s).getRow();
			int copyColumn = movie.getTheater().get(s).getColumn();
			String copyLevel = movie.getTheater().get(s).getLevel();
			copy.addTheater(copyName, copyPrice, copyRow, copyColumn, copyLevel);
		}
		// add show time in theater to copy
		for (String s : movie.getTheater().keySet())
			for (String x : movie.getTheater().get(s).getSeats().keySet()) {
				String copyShowtime = movie.getTheater().get(s).getSeats().get(x).getShowTime();
				copy.addShowtime(s, copyShowtime);
				// add information of each seat
				int row = movie.getTheater().get(s).getRow();
				int column = movie.getTheater().get(s).getColumn();
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						if (movie.getTheater().get(s).getSeats().get(x).isAvailable(i, j))
							copy.getTheater().get(s).getSeats().get(x).unbooking(i, j);
						else
							copy.getTheater().get(s).getSeats().get(x).booking(i, j);
					}
				}
			}
		return copy;
	}

}