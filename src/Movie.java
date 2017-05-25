import java.util.HashMap;
import java.util.Map;

/**
 * movie class contain a movie details.
 * 
 * @author Wongsathorn Panichkurkul and Totsapon Menkul
 *
 */
public class Movie implements Cloneable {

	private String title;
	private String description;
	private String price;
	private String length;
	// private List<Theater> theater = new ArrayList<Theater>();
	private Map<String, Theater> theaterMap = new HashMap<String, Theater>();

	public Movie(String title, String des, String length) {
		this.title = title;
		this.description = des;
		this.length = length;
	}

	/**
	 * add showtime in show
	 * 
	 * @param nameTheater
	 * @param showTime
	 */
	public void addShowtime(String nameTheater, String showTime) {
		if (theaterMap.containsKey(nameTheater))
			this.theaterMap.get(nameTheater).addShowTime(showTime);
	}

	public void addTheater(String nameTheater, double price, int row, int column, String level) {
		if (!theaterMap.containsKey(nameTheater))
			this.theaterMap.put(nameTheater, new Theater(nameTheater, price, row, column, level));
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Map<String, Theater> getTheater() {
		return this.theaterMap;
	}

}
