import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ticket {

	private Theater currentTheater;
	private Theater tempTheater;
	private Seat currentSeat;
	private Movie tempMovie;
	private Movie realObjectMovie;
	private int count;
	private Map<String, ArrayList<String>> description = new HashMap<>();

	public Ticket() {
	}

	public void setMovie(Movie movie) {
		this.resetAll();
		realObjectMovie = movie;
		tempMovie = createCopyMovie(movie);
	}

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
		printDescription();
		this.resetAll();
	}

	public void printDescription() {
		System.out.println(description);
	}

	public boolean isChecked(int row, int column) {
		if (currentSeat.isAvailable(row, column))
			return false;
		return true;
	}

	public void unbooking(int row, int column) {
		this.currentSeat.unbooking(row, column);
		description.get(this.getCurrentTheater().getName()).remove("[" + row + "," + column + "]");
		count--;
	}

	public void booking(int row, int column) {
		this.currentSeat.booking(row, column);
		if (!description.containsKey(this.getCurrentTheater().getName()))
			description.put(this.getCurrentTheater().getName(), new ArrayList<>());
		description.get(this.getCurrentTheater().getName()).add("[" + row + "," + column + "]");
		count++;
	}

	public double getTotalPrice() {
		return this.currentTheater.getPrice() * this.getAmount();
	}

	public Movie getCurrentMovie() {
		return this.tempMovie;
	}

	public Theater getCurrentTheater() {
		return this.currentTheater;
	}

	public void setCurrentShowtime(String showtime) {
		this.currentSeat = tempTheater.getSeats().get(showtime);
	}

	public Seat getCurrentShowtime() {
		return this.currentSeat;
	}

	public void setCurrentTheater(String theater) {
		this.currentTheater = this.realObjectMovie.getTheater().get(theater);
		this.tempTheater = this.tempMovie.getTheater().get(theater);
	}

	public int getAmount() {
		return this.count;
	}

	public double getPrice() {
		return this.currentTheater.getPrice();
	}

	public void resetAll() {
		if (this.tempMovie != null) {
			for (String s : this.tempMovie.getTheater().keySet()) {
				for (String x : this.tempMovie.getTheater().get(s).getSeats().keySet())
					this.tempMovie.getTheater().get(s).getSeats().get(x).unbookingAll();
			}
			count = 0;
			this.description = new HashMap<>();
		}
	}

	public void reset() {
		int number_deleted = this.currentSeat.unbookingAll();
		this.count -= number_deleted;
		this.description.remove(this.getCurrentTheater().getName());
	}

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
