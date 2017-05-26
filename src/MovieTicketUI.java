import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * user interface of the MovieTicket by using NetBean to design.
 *
 * @author Wongsathorn Panichkurkul and Totsapon Menkul
 */
public class MovieTicketUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel bottomPanel;
	private JButton buyButton;
	private JPanel buyPanel;
	private JButton chooseMovieButton;
	private JButton clearButton;
	private JLabel currentTimeLabel;
	private JTextArea descriptionTextArea;
	private JPanel infoPanel;
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JPanel leftPanel;
	private JLabel lengthLabel;
	private JTextField lengthTextField;
	private JLabel logoLabel;
	private JList<String> movieJList;
	private JLabel movieNameLabel;
	private JLabel movieScreenLabel;
	private JTextField movieTextField;
	private JLabel priceLabel;
	private JTextField priceTextField;
	private JPanel rowAndColumnPanel;
	private JPanel seatPanel;
	private JTextField seatTextField;
	private JPanel showAndTheaPanel;
	private JComboBox<String> showTimeComboBox;
	private JLabel showTimeLabel;
	private JComboBox<String> theaterComboBox;
	private JLabel theaterLabel;
	private JPanel topPanel;
	private JLabel pricePerSeatLabel;
	private JLabel iconTheaterLabel;
	private JTextField pricePerSeatTextField;

	/**
	 * Creates new form MovieTicketUI
	 */
	public MovieTicketUI() {
		initComponents();
	}

	/**
	 * created by using NetBeans design.
	 */
	private void initComponents() {

		leftPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		movieJList = new javax.swing.JList<>();
		chooseMovieButton = new javax.swing.JButton();
		topPanel = new javax.swing.JPanel();
		infoPanel = new javax.swing.JPanel();
		movieNameLabel = new javax.swing.JLabel();
		movieTextField = new javax.swing.JTextField();
		lengthLabel = new javax.swing.JLabel();
		lengthTextField = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		descriptionTextArea = new javax.swing.JTextArea();
		showAndTheaPanel = new javax.swing.JPanel();
		theaterLabel = new javax.swing.JLabel();
		theaterComboBox = new javax.swing.JComboBox<>();
		showTimeLabel = new javax.swing.JLabel();
		showTimeComboBox = new javax.swing.JComboBox<>();
		currentTimeLabel = new javax.swing.JLabel();
		logoLabel = new javax.swing.JLabel();
		bottomPanel = new javax.swing.JPanel();
		seatPanel = new javax.swing.JPanel();
		rowAndColumnPanel = new javax.swing.JPanel();
		movieScreenLabel = new javax.swing.JLabel();
		buyPanel = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		seatTextField = new javax.swing.JTextField();
		priceLabel = new javax.swing.JLabel();
		priceTextField = new javax.swing.JTextField();
		buyButton = new javax.swing.JButton();
		clearButton = new javax.swing.JButton();
		iconTheaterLabel = new javax.swing.JLabel();
		pricePerSeatLabel = new javax.swing.JLabel();
		pricePerSeatTextField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setCurrentTime();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("MovieTicket");
		setBackground(new java.awt.Color(255, 102, 0));
		setBounds(new java.awt.Rectangle(2, 2, 1440, 800));
		setMinimumSize(new java.awt.Dimension(1440, 800));
		setName("fame"); // NOI18N
		setPreferredSize(new java.awt.Dimension(1440, 800));
		setSize(new java.awt.Dimension(1440, 800));

		leftPanel.setBackground(new java.awt.Color(0, 0, 0));
		leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		movieJList.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Movie today\n",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Maiandra GD", 1, 14))); // NOI18N
		movieJList.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jScrollPane1.setViewportView(movieJList);

		chooseMovieButton.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/image/chooseButton.png"))); // NOI18N

		javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
		leftPanel.setLayout(leftPanelLayout);
		leftPanelLayout
				.setHorizontalGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								leftPanelLayout.createSequentialGroup().addContainerGap()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(leftPanelLayout.createSequentialGroup().addGap(39, 39, 39)
								.addComponent(chooseMovieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		leftPanelLayout.setVerticalGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
						.addComponent(chooseMovieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		topPanel.setBackground(new java.awt.Color(0, 0, 0));
		topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		infoPanel.setBackground(new java.awt.Color(0, 0, 0));
		infoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		movieNameLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		movieNameLabel.setForeground(new java.awt.Color(255, 255, 255));
		movieNameLabel.setText("MOVIE NAME : ");

		movieTextField.setEditable(false);
		movieTextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

		lengthLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		lengthLabel.setForeground(new java.awt.Color(255, 255, 255));
		lengthLabel.setText("LENGTH: ");

		lengthTextField.setEditable(false);
		lengthTextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

		descriptionTextArea.setEditable(false);
		descriptionTextArea.setColumns(20);
		descriptionTextArea.setRows(5);
		descriptionTextArea.setMargin(new Insets(2, 2, 10, 0));
		jScrollPane2.setViewportView(descriptionTextArea);

		javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
		infoPanel.setLayout(infoPanelLayout);
		infoPanelLayout.setHorizontalGroup(infoPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(infoPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(movieNameLabel).addComponent(lengthLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(movieTextField).addComponent(lengthTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(infoPanelLayout.createSequentialGroup().addContainerGap().addGroup(infoPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane2)
						.addGroup(infoPanelLayout.createSequentialGroup().addGroup(infoPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(movieNameLabel).addComponent(movieTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lengthLabel)
												.addComponent(lengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));

		showAndTheaPanel.setBackground(new java.awt.Color(0, 0, 0));
		showAndTheaPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		theaterLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		theaterLabel.setForeground(new java.awt.Color(255, 255, 255));
		theaterLabel.setText("THEATER");

		showTimeLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		showTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
		showTimeLabel.setText("SHOW TIME");

		currentTimeLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		currentTimeLabel.setForeground(new java.awt.Color(255, 255, 255));

		logoLabel.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/image/Logo.jpg"))); // NOI18N

		javax.swing.GroupLayout showAndTheaPanelLayout = new javax.swing.GroupLayout(showAndTheaPanel);
		showAndTheaPanel.setLayout(showAndTheaPanelLayout);
		showAndTheaPanelLayout.setHorizontalGroup(showAndTheaPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(showAndTheaPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(showAndTheaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(theaterLabel).addComponent(theaterComboBox,
										javax.swing.GroupLayout.PREFERRED_SIZE, 90,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(showAndTheaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										showAndTheaPanelLayout.createSequentialGroup()
												.addComponent(showTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
														90, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(57, 57, 57).addComponent(logoLabel).addContainerGap())
								.addGroup(showAndTheaPanelLayout.createSequentialGroup().addComponent(showTimeLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(currentTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
												javax.swing.GroupLayout.PREFERRED_SIZE)))));
		showAndTheaPanelLayout.setVerticalGroup(showAndTheaPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(showAndTheaPanelLayout.createSequentialGroup()
						.addGroup(showAndTheaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(showAndTheaPanelLayout.createSequentialGroup().addContainerGap()
										.addGroup(showAndTheaPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(theaterLabel).addComponent(showTimeLabel)))
								.addComponent(currentTimeLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(showAndTheaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(showAndTheaPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(theaterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(showTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(logoLabel))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(topPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(showAndTheaPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(topPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(showAndTheaPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		bottomPanel.setBackground(new java.awt.Color(0, 0, 0));
		bottomPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		seatPanel.setBackground(new java.awt.Color(102, 102, 102));
		seatPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		rowAndColumnPanel.setBackground(new java.awt.Color(0, 0, 0));
		rowAndColumnPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		movieScreenLabel.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/image/movieScreen.png"))); // NOI18N
		movieScreenLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		movieScreenLabel.setMaximumSize(new java.awt.Dimension(1900, 1200));
		movieScreenLabel.setPreferredSize(new java.awt.Dimension(760, 76));

		javax.swing.GroupLayout seatPanelLayout = new javax.swing.GroupLayout(seatPanel);
		seatPanel.setLayout(seatPanelLayout);
		seatPanelLayout
				.setHorizontalGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(seatPanelLayout.createSequentialGroup().addContainerGap()
								.addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(rowAndColumnPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(movieScreenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 900,
												Short.MAX_VALUE))
								.addContainerGap()));
		seatPanelLayout
				.setVerticalGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								seatPanelLayout.createSequentialGroup().addContainerGap()
										.addComponent(movieScreenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(rowAndColumnPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));

		buyPanel.setBackground(new java.awt.Color(0, 0, 0));
		buyPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("Seats");

		seatTextField.setEditable(false);
		seatTextField.setBackground(new java.awt.Color(255, 255, 255));
		seatTextField.setColumns(5);
		seatTextField.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N

		priceLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		priceLabel.setForeground(new java.awt.Color(255, 255, 255));
		priceLabel.setText("Total Price");

		priceTextField.setEditable(false);
		priceTextField.setBackground(new java.awt.Color(255, 255, 255));
		priceTextField.setColumns(5);
		priceTextField.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N

		buyButton.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/image/buyTicket.jpg"))); // NOI18N

		clearButton.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/image/clearButton.png"))); // NOI18N

		pricePerSeatLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
		pricePerSeatLabel.setForeground(new java.awt.Color(255, 255, 255));
		pricePerSeatLabel.setText("Price/Seat");

		pricePerSeatTextField.setEditable(false);
		pricePerSeatTextField.setBackground(new java.awt.Color(255, 255, 255));
		pricePerSeatTextField.setColumns(5);
		pricePerSeatTextField.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N

		javax.swing.GroupLayout buyPanelLayout = new javax.swing.GroupLayout(buyPanel);
		buyPanel.setLayout(buyPanelLayout);
		buyPanelLayout.setHorizontalGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						buyPanelLayout.createSequentialGroup()
								.addComponent(iconTheaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(buyPanelLayout.createSequentialGroup().addContainerGap().addGroup(buyPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buyPanelLayout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE).addGroup(buyPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												buyPanelLayout.createSequentialGroup().addGroup(buyPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel3))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(
																buyPanelLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(seatTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(priceTextField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												buyPanelLayout.createSequentialGroup().addGroup(buyPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE,
																100, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(buyPanelLayout.createSequentialGroup()
																.addGap(12, 12, 12).addComponent(clearButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 70,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(18, 18, 18))))
						.addGroup(buyPanelLayout.createSequentialGroup().addComponent(pricePerSeatLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(pricePerSeatTextField)))
						.addContainerGap()));
		buyPanelLayout.setVerticalGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buyPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(seatTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(priceLabel).addComponent(priceTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pricePerSeatLabel).addComponent(pricePerSeatTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(iconTheaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(clearButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)));

		javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
		bottomPanel.setLayout(bottomPanelLayout);
		bottomPanelLayout
				.setHorizontalGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(bottomPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(seatPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(14, 14, 14)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buyPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		bottomPanelLayout
				.setVerticalGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(bottomPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(seatPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(55, 55, 55))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								bottomPanelLayout.createSequentialGroup().addContainerGap().addComponent(buyPanel,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGroup(bottomPanelLayout.createSequentialGroup().addGap(25, 25, 25)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addContainerGap()));

		pack();
	}// </editor-fold>

	/**
	 * set current time in curremtTimeLabel.
	 */
	private void setCurrentTime() {
		int delay = 1000; // milliseconds
		ActionListener setCurrentTimeListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String date = new java.text.SimpleDateFormat("HH:mm:ss")
						.format(new java.util.Date(System.currentTimeMillis()));
				currentTimeLabel.setText(date);
			}
		};
		new Timer(delay, setCurrentTimeListener).start();
	}

	/**
	 * get ChooseMoiveButton.
	 * 
	 * @return ChooseMovieButton.
	 */
	public JButton getChooseMovieButton() {
		return chooseMovieButton;
	}

	/**
	 * get clearButton.
	 * 
	 * @return clearButton.
	 */
	public JButton getClearButton() {
		return clearButton;
	}

	/**
	 * get buyButton.
	 * 
	 * @return buyButton.
	 */
	public JButton getBuyButton() {
		return this.buyButton;
	}

	/**
	 * get currentTimeLabel.
	 * 
	 * @return currentTimeLabel.
	 */
	public JLabel getCurrentTimeLabel() {
		return this.currentTimeLabel;
	}

	/**
	 * get movieJList.
	 * 
	 * @return movieJList.
	 */
	public JList<String> getMovieJList() {
		return this.movieJList;
	}

	/**
	 * get movieTextField.
	 * 
	 * @return movieTextField.
	 */
	public JTextField getMovieTextField() {
		return this.movieTextField;
	}

	/**
	 * get lengthTextField.
	 * 
	 * @return lengthTextField.
	 */
	public JTextField getLengthTextField() {
		return this.lengthTextField;
	}

	/**
	 * get seatTextField.
	 * 
	 * @return seatTextField.
	 */
	public JTextField getSeatTextField() {
		return this.seatTextField;
	}

	/**
	 * get priceTextField.
	 * 
	 * @return priceTextField.
	 */
	public JTextField getPriceTextField() {
		return this.priceTextField;
	}

	/**
	 * get descriptionTextArea.
	 * 
	 * @return descriptionTextArea.
	 */
	public JTextArea getDescriptionTextArea() {
		return this.descriptionTextArea;
	}

	/**
	 * get theaterComboBox.
	 * 
	 * @return theaterComboBox.
	 */
	public JComboBox<String> getTheaterComboBox() {
		return this.theaterComboBox;
	}

	/**
	 * get showTimeComboBox.
	 * 
	 * @return showTimeComboBox.
	 */
	public JComboBox<String> getShowTimeComboBox() {
		return this.showTimeComboBox;
	}

	/**
	 * get iconTheaterLabel.
	 * 
	 * @return iconTheaterLabel.
	 */
	public JLabel getIconTheaterLabel() {
		return this.iconTheaterLabel;
	}

	/**
	 * get rowAndColumnPanel.
	 * 
	 * @return rowAndColumnPanel.
	 */
	public JPanel getRowAndColumnPanel() {
		return this.rowAndColumnPanel;
	}

	/**
	 * get pricePerSeatTextField.
	 * 
	 * @return pricePerSeatTextField.
	 */
	public JTextField getPricePerSeatTextField() {
		return this.pricePerSeatTextField;
	}

	/**
	 * Run the program.
	 */
	public void run() {
		this.setVisible(true);
	}
}
