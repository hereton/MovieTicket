import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.*;

/**
 * MovieManager class that read the movie and theater data with CsvReader.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class MovieManager {

	private Map<String, Movie> movies = new HashMap<String, Movie>();
	private Map<String, Theater> theaters = new HashMap<String, Theater>();
	private CsvReader products;
	private CsvWriter csvOutput;
	private String outputFile = "ticket_number";
	private int count = 1;

	/**
	 * Read all data with CsvReader and collect in map.
	 */
	public void readData() {
		try {
			// read all theaters.
			products = new CsvReader("Theater.csv");
			products.readHeaders();
			while (products.readRecord()) {
				String theater = products.get("Theater");
				int row = Integer.parseInt(products.get("Row"));
				int column = Integer.parseInt(products.get("Column"));
				double price = Double.parseDouble(products.get("Price"));
				String level = products.get("Level");
				theaters.put(theater, new Theater(theater, price, row, column, level));
			}
			// read all movies.
			products = new CsvReader("Movie.csv");
			products.readHeaders();
			while (products.readRecord()) {
				String theater = products.get("Theater");
				String movie = products.get("Movie");
				String description = products.get("Description");
				String length = products.get("Length");
				String Show_Time = products.get("Show Time");
				String[] splitTime = Show_Time.split(" ");
				for (String s : splitTime)
					addMovie(movie, description, length, theater, s);
			}
			products.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write the information to text file.
	 * 
	 * @param ticket
	 *            is the ticket object.
	 */
	public void writeFile(Ticket ticket) {
		String fileName = outputFile + count + ".txt";
		try {
			csvOutput = new CsvWriter(new FileWriter(fileName), '\n');
			csvOutput.write("Movie : " + ticket.getCurrentMovie().getTitle() + "\n");
			csvOutput.endRecord();
			for (String des : ticket.getDescription()) {
				String[] splitDetail = des.split("-");
				csvOutput.write("Theater : " + splitDetail[0]);
				csvOutput.endRecord();
				csvOutput.write("Show time : " + splitDetail[1]);
				csvOutput.endRecord();
				csvOutput.write("Row,Column : " + splitDetail[2]);
				csvOutput.endRecord();
				csvOutput.write("Price : " + splitDetail[3]);
				csvOutput.endRecord();
				csvOutput.write("-----------------------------");
				csvOutput.endRecord();
			}
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		count++;
	}

	/**
	 * Add the movie in map.
	 * 
	 * @param name
	 *            is name of the movie.
	 * @param des
	 *            is description of the movie.
	 * @param length
	 *            is length of the movie.
	 * @param theater
	 *            is the theater of the movie.
	 * @param showTime
	 *            is the show time of the movie.
	 */
	private void addMovie(String name, String des, String length, String theater, String showTime) {
		if (!movies.containsKey(name))
			movies.put(name, new Movie(name, des, length));
		if (theaters.containsKey(theater)) {
			Theater temp = theaters.get(theater);
			movies.get(name).addTheater(temp.getName(), temp.getPrice(), temp.getRow(), temp.getColumn(),
					temp.getLevel());
			movies.get(name).addShowtime(theater, showTime);
		}
	}

	/**
	 * Return all movies in map.
	 * 
	 * @return map of the movie.
	 */
	public Map<String, Movie> getAllMovies() {
		return this.movies;
	}

	/**
	 * Return all exists theater.
	 * 
	 * @return all exists theater.
	 */
	public Map<String, Theater> getAllTheaters() {
		return this.theaters;
	}

}