import java.util.HashMap;
import java.util.Map;

/**
 * Movie class that contain a movie details.
 * 
 * @author Wongsathorn Panichkurkul and Totsapon Menkul
 *
 */
public class Movie implements Cloneable {

	private String title;
	private String description;
	private String length;
	private Map<String, Theater> theaterMap = new HashMap<String, Theater>();

	/**
	 * Constructor that Initialize the Movie.
	 * 
	 * @param title
	 *            is title of movie.
	 * @param des
	 *            is description of movie.
	 * @param length
	 *            is the length of movie.
	 */
	public Movie(String title, String des, String length) {
		this.title = title;
		this.description = des;
		this.length = length;
	}

	/**
	 * Add Show time in theater by given name of theater and show time.
	 * 
	 * @param nameTheater
	 *            is the name of theater that you want to add.
	 * @param showTime
	 *            is the show time of the movie.
	 */
	public void addShowtime(String nameTheater, String showTime) {
		if (theaterMap.containsKey(nameTheater))
			this.theaterMap.get(nameTheater).addShowTime(showTime);
	}

	/**
	 * Add the theater of the movie.
	 * 
	 * @param nameTheater
	 *            is name of the theater.
	 * @param price
	 *            is the price of the theater.
	 * @param row
	 *            is row of the theater.
	 * @param column
	 *            is column of the theater.
	 * @param level
	 *            is level of the theater.
	 */
	public void addTheater(String nameTheater, double price, int row, int column, String level) {
		if (!theaterMap.containsKey(nameTheater))
			this.theaterMap.put(nameTheater, new Theater(nameTheater, price, row, column, level));
	}

	/**
	 * Set the title of the movie.
	 * 
	 * @param title
	 *            is the title that you want to change to.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Set the description of the movie.
	 * 
	 * @param description
	 *            is the description of the movie.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the title of the movie.
	 * 
	 * @return the title of the movie.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Get the description of the movie.
	 * 
	 * @return the description of the movie.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Get length of the movie.
	 * 
	 * @return Length of the movie.
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Set length of the movie.
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * Get all the theater of the movie with map.
	 * 
	 * @return all the theater of the movie with map.
	 */
	public Map<String, Theater> getTheater() {
		return this.theaterMap;
	}

}
