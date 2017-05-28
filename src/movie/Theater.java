package movie;

import java.util.HashMap;
import java.util.Map;

/**
 * The theater class that contain seats and detail of the theater.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class Theater {

	private Map<String, Seat> seatMap = new HashMap<String, Seat>();
	private String name;
	private int row;
	private int column;
	private double price;
	private String level;

	/**
	 * Constructor for initialize the theater.
	 * 
	 * @param name
	 *            is the name of the theater.
	 * @param price
	 *            is the price of the theater.
	 * @param row
	 *            is the row of the theater.
	 * @param column
	 *            is the column of the theater.
	 * @param level
	 *            is the level of the theater.
	 */
	public Theater(String name, double price, int row, int column, String level) {
		this.name = name;
		this.row = row;
		this.column = column;
		this.price = price;
		this.level = level;
	}

	/**
	 * Add the show time in the theater.
	 * 
	 * @param showTime
	 *            is the show time that you want to add.
	 */
	public void addShowTime(String showTime) {
		if (!seatMap.containsKey(showTime))
			seatMap.put(showTime, new Seat(showTime, row, column));
	}

	/**
	 * Get the price of the theater.
	 * 
	 * @return the price of the theater.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Get level of the theater.
	 * 
	 * @return level of the theater.
	 */
	public String getLevel() {
		return this.level;
	}

	/**
	 * Get Name of the theater.
	 * 
	 * @return Name of the theater.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get Row of the theater.
	 * 
	 * @return Row of the theater.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Get column of the theater.
	 * 
	 * @return column of the theater.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Get all seat of the theater with map.
	 * 
	 * @return all seat of the theater with map.
	 */
	public Map<String, Seat> getSeats() {
		return this.seatMap;
	}

}
