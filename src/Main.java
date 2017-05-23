public class Main {

	public static void main(String[] args) {
		MovieManager mm = new MovieManager();
		MovieTicketUI ui = new MovieTicketUI();
		MovieController mvc = new MovieController(ui, mm);
		mvc.run();
	}
}
