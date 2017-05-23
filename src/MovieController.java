import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

/**
 * Keeps references to Models and UI classes
 * 
 * @author General. Prayuth ChanOcha.
 *
 */
public class MovieController {
	private Ticket ticket = new Ticket();
	private MovieManager manager;
	private MovieTicketUI ui;
	private Map<String, Movie> movies;
	private DefaultListModel<String> movieList = new DefaultListModel<>();
	private Icon buyIcon = new ImageIcon("src\\image\\money.png");
	private JToggleButton[][] buttons;

	public MovieController(MovieTicketUI ui, MovieManager manager) {
		this.manager = manager;
		this.ui = ui;
		this.manager.readData();
		this.movies = manager.getAllMovies();
		addMovieList(movies);
	}

	public void run() {
		control();
		this.ui.run();
	}

	/**
	 * launch all method.
	 */
	public void control() {
		linkTheaterComboBox();
		linkChooseMovieButton();
		linkShowTimeComboBox();
		linkBuyButton();
		linkClearButton();
	}

	/**
	 * set Choose Button to addActionListener.
	 */
	private void linkChooseMovieButton() {
		ui.getChooseMovieButton().addActionListener(e -> chooseMovieButtonActionPerformed(e));
	}

	/**
	 * set theater combo box to addActionListener.
	 */
	private void linkTheaterComboBox() {
		ui.getTheaterComboBox().addActionListener(e -> setShowTime());
	}

	/**
	 * set show time combo box to addActionListener.
	 */
	private void linkShowTimeComboBox() {
		ui.getShowTimeComboBox().addActionListener(e -> showTimeComboBoxActionPerformed(e));
	}

	/**
	 * set buy button to addActionListener.
	 */
	private void linkBuyButton() {
		ui.getBuyButton().addActionListener(e -> buyButtonActionPerformed(e));
	}

	/**
	 * set clear button to addActionListener.
	 */
	private void linkClearButton() {
		ui.getClearButton().addActionListener(e -> clearButtonActionPerformed(e));
	}

	// action performed for each buttons.
	private void clearButtonActionPerformed(ActionEvent evt) {
		if (ticket.getCurrentMovie() != null) {
			ticket.reset();
			ui.getRowAndColumnPanel().removeAll();
			creatButtonWithEnterRowAndCol(ticket.getCurrentTheater().getRow(), ticket.getCurrentTheater().getColumn());
			ui.getSeatTextField().setText("");
			ui.getPriceTextField().setText("");
		}
	}

	private void buyButtonActionPerformed(ActionEvent evt) {
		JTextPane tempPane = new JTextPane();
		tempPane.setFont(new Font(Font.SERIF, Font.BOLD, 14));
		tempPane.setForeground(Color.black);
		if (ticket.getCurrentMovie() != null) {
			int seats = ticket.getAmount();
			double totalPrice = ticket.getTotalPrice();
			if (seats > 0) {
				tempPane.setText(String.format("Total Amount : %d\nTotal Price : %.2f Baht\n", seats, totalPrice));
				tempPane.setEditable(false);
				int n = JOptionPane.showConfirmDialog(ui, tempPane, "Confirm tickets", JOptionPane.YES_OPTION,
						JOptionPane.QUESTION_MESSAGE, buyIcon);
				if (n == 0) {
					ticket.confirm();
					reset();
				}
			}
		}
	}

	private void reset() {
		ui.getRowAndColumnPanel().removeAll();
		int row = ticket.getCurrentTheater().getRow();
		int column = ticket.getCurrentTheater().getColumn();
		creatButtonWithEnterRowAndCol(row, column);
		ui.getSeatTextField().setText(ticket.getAmount() + "");
		ui.getPriceTextField().setText(ticket.getTotalPrice() + "");
	}

	private void chooseMovieButtonActionPerformed(ActionEvent evt) {
		if (ui.getMovieJList().getSelectedValue() == null)
			JOptionPane.showMessageDialog(ui, "Please select movie");
		else {
			if (ticket.getCurrentMovie() == null)
				setChoosedMovie();
			else if (!ui.getMovieJList().getSelectedValue().equals(ticket.getCurrentMovie().getTitle())) {
				int i = JOptionPane.showConfirmDialog(null, "Do you want to change the movie ?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (i == 0)
					setChoosedMovie();
			} else
				setChoosedMovie();
		}
	}

	private void showTimeComboBoxActionPerformed(ActionEvent evt) {
		if (ui.getShowTimeComboBox().getSelectedItem() != null) {
			ui.getRowAndColumnPanel().removeAll();
			ticket.setCurrentShowtime(ui.getShowTimeComboBox().getSelectedItem().toString());
			creatButtonWithEnterRowAndCol(ticket.getCurrentTheater().getRow(), ticket.getCurrentTheater().getColumn());
		}
	}

	private void setChoosedMovie() {
		ticket.setMovie(movies.get(ui.getMovieJList().getSelectedValue()));
		for (String s : movies.keySet()) {
			if (s.equalsIgnoreCase(ui.getMovieJList().getSelectedValue())) {
				ui.getMovieTextField().setText(ticket.getCurrentMovie().getTitle());
				ui.getLengthTextField().setText(ticket.getCurrentMovie().getLength());
				ui.getDescriptionTextArea().setText(ticket.getCurrentMovie().getDescription());
				ui.getTheaterComboBox().removeAllItems();
				Map<String, Theater> test = ticket.getCurrentMovie().getTheater();
				for (String theater : test.keySet())
					ui.getTheaterComboBox().addItem(theater);
			}
		}
	}

	private void setShowTime() {
		if (ui.getTheaterComboBox().getSelectedItem() != null) {
			String theater = ui.getTheaterComboBox().getSelectedItem().toString();
			ticket.setCurrentTheater(theater);
			if (ticket.getCurrentTheater().getLevel().equalsIgnoreCase("4D"))
				ui.getIconTheaterLabel().setIcon(new ImageIcon("src/image/4D.png"));
			else if (ticket.getCurrentTheater().getLevel().equalsIgnoreCase("3D"))
				ui.getIconTheaterLabel().setIcon(new ImageIcon("src/image/3D.png"));
			else
				ui.getIconTheaterLabel().setIcon(null);
			ui.getPricePerSeatTextField().setText(ticket.getPrice() + "");
			ui.getShowTimeComboBox().removeAllItems();
			for (String showTime : ticket.getCurrentTheater().getSeats().keySet())
				ui.getShowTimeComboBox().addItem(showTime);
			ui.getRowAndColumnPanel().removeAll();
			ui.revalidate();
			ui.repaint();
			creatButtonWithEnterRowAndCol(ticket.getCurrentTheater().getRow(), ticket.getCurrentTheater().getColumn());
		}
	}

	private boolean isTimePassedShowtime(String selectedDate) {
		String currentDate = ui.getCurrentTimeLabel().getText().substring(0, 5).replace('.', ':');
		LocalTime time = LocalTime.parse(currentDate);
		LocalTime other = LocalTime.parse(selectedDate.replace('.', ':'));
		if (time.isAfter(other))
			return true;
		return false;
	}

	private void creatButtonWithEnterRowAndCol(int row, int col) {
		buttons = new JToggleButton[row][col];
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0));
		GridLayout gl = new GridLayout(row, col);
		gl.setHgap(10);
		gl.setVgap(5);
		pane.setLayout(gl);
		// create button arrays.
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JToggleButton();
				buttons[i][j].setActionCommand(i + " " + j);
				buttons[i][j].setPreferredSize(new Dimension(30, 30));
				String selectedShowTime = ui.getShowTimeComboBox().getSelectedItem().toString();
				if (isTimePassedShowtime(selectedShowTime)) {
					buttons[i][j].setIcon(new ImageIcon("src/image/seatAvailable.jpg"));
					buttons[i][j].setEnabled(false);
				} else if (!checkIsAvailable(i, j)) {
					buttons[i][j].setIcon(new ImageIcon("src\\image\\seatFull.jpg"));
				} else if (ticket.isChecked(i, j)) {
					buttons[i][j].setIcon(new ImageIcon("src\\image\\seatSelected.png"));
					buttons[i][j].addActionListener(buttonActions);
				} else {
					buttons[i][j].setIcon(new ImageIcon("src/image/seatAvailable.jpg"));
					buttons[i][j].addActionListener(buttonActions);
				}
				pane.add(buttons[i][j]);
			}
		}
		ui.getRowAndColumnPanel().add(pane);
		ui.validate();
	}

	private boolean checkIsAvailable(int row, int column) {
		return ticket.getCurrentTheater().getSeats().get(ui.getShowTimeComboBox().getSelectedItem()).isAvailable(row,
				column);
	}

	private ActionListener buttonActions = (ActionEvent ae) -> {
		JToggleButton button = (JToggleButton) ae.getSource();
		if (button.isSelected()) {
			button.setIcon(new ImageIcon("src\\image\\seatSelected.png"));
			int[] temp = arrStringToInt(button.getActionCommand());
			ticket.booking(temp[0], temp[1]);
		} else {
			button.setIcon(new ImageIcon("src\\image\\seatAvailable.jpg"));
			int[] temp = arrStringToInt(button.getActionCommand());
			ticket.unbooking(temp[0], temp[1]);
		}
		ui.getSeatTextField().setText(ticket.getAmount() + "");
		ui.getPriceTextField().setText(ticket.getTotalPrice() + "");
	};

	private int[] arrStringToInt(String string) {
		String[] tempString = string.split(" ");
		int[] tempInt = new int[2];
		tempInt[0] = Integer.parseInt(tempString[0]);
		tempInt[1] = Integer.parseInt(tempString[1]);
		return tempInt;
	}

	/**
	 * add all movies into list in left hand side.
	 *
	 * @param inputMovies
	 *            map of movies.
	 */
	private void addMovieList(Map<String, Movie> inputMovies) {
		for (String s : inputMovies.keySet())
			movieList.addElement(inputMovies.get(s).getTitle());
		ui.getMovieJList().setModel(movieList);
	}
}
