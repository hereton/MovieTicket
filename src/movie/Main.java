package movie;

/**
 * The Main class for run the program.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class Main {

	/**
	 * main method for create an object and run the program.
	 * 
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {
		Ticket mm = new Ticket();
		MovieTicketUI ui = new MovieTicketUI();
		MovieController mvc = new MovieController(ui, mm);
		mvc.run();
	}
}
