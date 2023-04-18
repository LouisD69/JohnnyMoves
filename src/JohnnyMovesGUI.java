import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.util.EventListener;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.util.ArrayList;
import javax.swing.JPasswordField;



public class JohnnyMovesGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	//JPanels
	private JPanel contentPane;
	private JPanel menuPane;
	private JPanel menuDatePanel;
	private JPanel menuOptionPanel;
	private JPanel sendParcelPane;
	private JPanel panelCheckParcel;
	private JPanel panelCheckParcelButton;
	private JPanel panelAddedItems;
	private JPanel panelAddedItemsCMB;
	private JPanel panelRemoveButton;
	private JPanel addDocumentPane;
	private JPanel panelWidthDocument;
	private JPanel panelLengthDocument;
	private JPanel panelNumberOfPages;
	private JPanel panelAddDocument;
	private JPanel addProductPane;
	private JPanel panelWidthProduct;
	private JPanel panelLengthProduct;
	private JPanel panelHeight;
	private JPanel panelIsIrregular;
	private JPanel panelAddProduct;
	private JPanel trackingPane;
	private JPanel panelTrackingNumber;
	private JPanel panelTrackResult;
	private JPanel finalizePane;
	private JPanel panelChooseParcel;
	private JPanel panelReturnFromTracking;
	private JPanel panelNameOfRecipient;
	private JPanel panelDestination;
	private JPanel panelInsure;
	private JPanel panelCheckout;
	private JPanel checkoutPane;
	private JPanel panelReturnToMenu;
	private JPanel panelSendParcelButtons;
	private JPanel loginPane;
	private JPanel menuLogoutPanel;
	private JPanel usernamePanel;
	private JPanel passwordPanel;
	private JPanel loginButtonPanel;
	private JPanel panelWeight;
	private JPanel logoutPanel;
	private JPanel logoutPasswordPanel;

	//JLabels
	private JLabel lblDate;
	private JLabel lblHeight;
	private JLabel lblisIrregular;
	private JLabel lblWidthDoc;
	private JLabel lblLengthDoc;
	private JLabel lblNumberOfPages;
	private JLabel labelWidthProduct;
	private JLabel lblLengthProduct;
	private JLabel lblChooseParcel;
	private JLabel lblEnterTracking;
	private JLabel lblNameOfRecipient;
	private JLabel lblDestination;
	private JLabel lblInsureAllItems;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblAvailableParcels;
	private JLabel lblWeight;

	//JButtons
	private JButton btnSendAParcel;
	private JButton btnTrackAParcel;
	private JButton btnAddADocument;
	private JButton btnAddAProduct;
	private JButton btnCheckParcel;
	private JButton btnRemove;
	private JButton btnAddDocument;
	private JButton btnCancelDoc;
	private JButton btnAddProduct;
	private JButton btnCancelProduct;
	private JButton btnSearch;
	private JButton btnExitTracking;
	private JButton btnCheckout;
	private JButton btnBackToItems;
	private JButton btnReturnToMenu;
	private JButton btnProceed;
	private JButton btnBackToMenu;
	private JButton btnLogout;
	private JButton btnLogin;
	private JButton btnConfirmLogout;
	private JButton btnCancelLogout;

	//JRadioButtons
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnMetroManila;
	private JRadioButton rdbtnLuzon;
	private JRadioButton rdbtnVisayas;
	private JRadioButton rdbtnMindanao;
	private JRadioButton rdbtnYesInsure;
	private JRadioButton rdbtnNoInsure;

	//ButtonGroup
	private ButtonGroup irregularGroup;
	private ButtonGroup destGroup;
	private ButtonGroup insureGroup;

	//JComboBox
	private JComboBox<Item> cmbAddedItems;
	private JComboBox<Parcel> cmbChooseParcel;
	private JComboBox<Parcel> cmbAvailableParcels;

	//JTextFields
	private JTextField tfDate;
	private JTextField tfWidthDoc;
	private JTextField tfHeight;
	private JTextField tfLengthDoc;
	private JTextField tfNumberOfPages;
	private JTextField tfWidthProduct;
	private JTextField tfLengthProduct;
	private JTextField tfTrackingNumber;
	private JTextField tfRecipientName;
	private JTextField tfUsername;
	private JTextField tfWeight;

	//Jpasswordfield

	private JPasswordField pfPassword;
	private JPasswordField pfLogout;
	//JTextAreas
	private JTextArea taTrackResult;
	private JTextArea taBreakdown;
	private JTextArea taTrackInfo;

	//final Strings
	public final String MENU = "Menu";
	public final String SENDPARCEL = "Send Parcel";
	public final String CHECKPARCEL = "Check Parcel";
	public final String ADDDOC = "Add Document";
	public final String ADDPRODUCT = "Add Product";
	public final String CHECKOUT = "Checkout";
	public final String TRACKING = "Tracking";
	public final String FINALIZE = "Finalize";
	public final String AVAILABLEPARCEL = "Available Parcel";
	public final String LOGIN = "Login";
	public final String USERNAME = "a";
	public final String PASSWORD = "b";
	public final String MENULOGOUT = "Menu Logout";
	public final String PWLOGOUT = "Password Logout";

	
	

	public JohnnyMovesGUI()
	{
		super();
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 300);
		setVisible(true);
	}
	public void init()
	{
		// CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		//LOGIN
		loginPane = new JPanel();
		contentPane.add(loginPane, LOGIN);
		loginPane.setLayout(new BoxLayout(loginPane, BoxLayout.Y_AXIS));
		
		// USERNAME PANEL -- lbl, tf
		usernamePanel = new JPanel();
		loginPane.add(usernamePanel);
		usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblUsername = new JLabel("Username:");
		usernamePanel.add(lblUsername);

		tfUsername = new JTextField();
		usernamePanel.add(tfUsername);
		tfUsername.setColumns(15);

		// PASSWORD PANEL -- lbl, pf
		passwordPanel = new JPanel();
		loginPane.add(passwordPanel);

		lblPassword = new JLabel("Password:");
		passwordPanel.add(lblPassword);

		pfPassword = new JPasswordField();
		passwordPanel.add(pfPassword);
		pfPassword.setColumns(15);

		// LOGIN BUTTON PANEL -- button only
		loginButtonPanel = new JPanel();
		loginPane.add(loginButtonPanel);

		btnLogin = new JButton("Login");
		loginButtonPanel.add(btnLogin);

		// MENU
		menuPane = new JPanel();
		contentPane.add(menuPane, MENU);
		menuPane.setLayout(new BorderLayout(0, 0));

		menuDatePanel = new JPanel();
		menuPane.add(menuDatePanel, BorderLayout.NORTH);

		lblDate = new JLabel("Date (M/D/Y): ");
		menuDatePanel.add(lblDate);

		tfDate = new JTextField();
		tfDate.setEditable(false);
		menuDatePanel.add(tfDate);
		tfDate.setColumns(10);
		
		// MENU OPTIONS 
		menuOptionPanel = new JPanel();
		menuPane.add(menuOptionPanel, BorderLayout.CENTER);
		menuOptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSendAParcel = new JButton("Send A Parcel");
		menuOptionPanel.add(btnSendAParcel);

		btnTrackAParcel = new JButton("Track A Parcel");
		menuOptionPanel.add(btnTrackAParcel);

		menuLogoutPanel = new JPanel();
		menuPane.add(menuLogoutPanel, BorderLayout.SOUTH);
		menuLogoutPanel.setLayout(new CardLayout(0, 0));
		
		// LOGOUT
		logoutPanel = new JPanel();
		menuLogoutPanel.add(logoutPanel, MENULOGOUT);
		
		btnLogout = new JButton("Logout");
		logoutPanel.add(btnLogout);
		
		logoutPasswordPanel = new JPanel();
		menuLogoutPanel.add(logoutPasswordPanel, PWLOGOUT);
		
		btnCancelLogout = new JButton("Cancel Logout");
		logoutPasswordPanel.add(btnCancelLogout);
		
		pfLogout = new JPasswordField();
		pfLogout.setColumns(15);
		logoutPasswordPanel.add(pfLogout);
		
		btnConfirmLogout = new JButton("Confirm Logout");
		logoutPasswordPanel.add(btnConfirmLogout);

		// SEND PARCEL
		sendParcelPane = new JPanel();
		contentPane.add(sendParcelPane, SENDPARCEL);
		sendParcelPane.setLayout(new BorderLayout(0, 0));

		btnAddADocument = new JButton("Add a Document");
		sendParcelPane.add(btnAddADocument, BorderLayout.WEST);

		btnAddAProduct = new JButton("Add a Product");
		sendParcelPane.add(btnAddAProduct, BorderLayout.EAST);

		panelCheckParcel = new JPanel();
		sendParcelPane.add(panelCheckParcel, BorderLayout.NORTH);
		panelCheckParcel.setLayout(new CardLayout(0, 0));

		panelCheckParcelButton = new JPanel();
		panelCheckParcel.add(panelCheckParcelButton, CHECKPARCEL);

		lblAvailableParcels = new JLabel("Available Parcels: ");
		panelCheckParcelButton.add(lblAvailableParcels);

		cmbAvailableParcels = new JComboBox<> ();
		panelCheckParcelButton.add(cmbAvailableParcels);

		btnCheckParcel = new JButton("Check Parcel");
		panelCheckParcelButton.add(btnCheckParcel);

		panelAddedItems = new JPanel();
		sendParcelPane.add(panelAddedItems, BorderLayout.CENTER);
		panelAddedItems.setLayout(new BoxLayout(panelAddedItems, BoxLayout.Y_AXIS));

		panelAddedItemsCMB = new JPanel();
		panelAddedItems.add(panelAddedItemsCMB);

		cmbAddedItems = new JComboBox<> ();;
		panelAddedItemsCMB.add(cmbAddedItems);

		panelRemoveButton = new JPanel();
		panelAddedItems.add(panelRemoveButton);

		btnRemove = new JButton("Remove");
		panelRemoveButton.add(btnRemove);

		panelSendParcelButtons = new JPanel();
		sendParcelPane.add(panelSendParcelButtons, BorderLayout.SOUTH);
		panelSendParcelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnProceed = new JButton("Proceed");
		panelSendParcelButtons.add(btnProceed);

		btnBackToMenu = new JButton("Back To Menu");
		panelSendParcelButtons.add(btnBackToMenu);

		// ADD DOCUMENT
		addDocumentPane = new JPanel();
		contentPane.add(addDocumentPane, ADDDOC);
		addDocumentPane.setLayout(new BoxLayout(addDocumentPane, BoxLayout.Y_AXIS));

		panelWidthDocument = new JPanel();
		addDocumentPane.add(panelWidthDocument);
		panelWidthDocument.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblWidthDoc = new JLabel("Width:");
		panelWidthDocument.add(lblWidthDoc);

		tfWidthDoc = new JTextField();
		panelWidthDocument.add(tfWidthDoc);
		tfWidthDoc.setColumns(4);

		panelLengthDocument = new JPanel();
		addDocumentPane.add(panelLengthDocument);
		panelLengthDocument.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblLengthDoc = new JLabel("Length:");
		panelLengthDocument.add(lblLengthDoc);

		tfLengthDoc = new JTextField();
		tfLengthDoc.setColumns(4);
		panelLengthDocument.add(tfLengthDoc);

		panelNumberOfPages = new JPanel();
		addDocumentPane.add(panelNumberOfPages);
		panelNumberOfPages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNumberOfPages = new JLabel("Number of Pages:");
		panelNumberOfPages.add(lblNumberOfPages);

		tfNumberOfPages = new JTextField();
		tfNumberOfPages.setColumns(4);
		panelNumberOfPages.add(tfNumberOfPages);

		panelAddDocument = new JPanel();
		addDocumentPane.add(panelAddDocument);

		btnAddDocument = new JButton("Add document");
		panelAddDocument.add(btnAddDocument);

		btnCancelDoc = new JButton("Cancel");
		panelAddDocument.add(btnCancelDoc);

		//ADD PRODUCT
		addProductPane = new JPanel();
		contentPane.add(addProductPane, ADDPRODUCT);
		addProductPane.setLayout(new BoxLayout(addProductPane, BoxLayout.Y_AXIS));

		panelWidthProduct = new JPanel();
		addProductPane.add(panelWidthProduct);
		panelWidthProduct.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		labelWidthProduct = new JLabel("Width:");
		panelWidthProduct.add(labelWidthProduct);

		tfWidthProduct = new JTextField();
		tfWidthProduct.setColumns(4);
		panelWidthProduct.add(tfWidthProduct);

		panelLengthProduct = new JPanel();
		addProductPane.add(panelLengthProduct);
		panelLengthProduct.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblLengthProduct = new JLabel("Length:");
		panelLengthProduct.add(lblLengthProduct);

		tfLengthProduct = new JTextField();
		tfLengthProduct.setColumns(4);
		panelLengthProduct.add(tfLengthProduct);

		panelHeight = new JPanel();
		addProductPane.add(panelHeight);

		lblHeight = new JLabel("Height:");
		panelHeight.add(lblHeight);

		tfHeight = new JTextField();
		tfHeight.setColumns(4);
		panelHeight.add(tfHeight);

		panelWeight = new JPanel();
		addProductPane.add(panelWeight);
		panelWeight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblWeight = new JLabel("Weight:");
		panelWeight.add(lblWeight);

		tfWeight = new JTextField();
		panelWeight.add(tfWeight);
		tfWeight.setColumns(4);

		panelIsIrregular = new JPanel();
		addProductPane.add(panelIsIrregular);
		panelIsIrregular.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblisIrregular = new JLabel("Product has an Irregular Shape?");
		panelIsIrregular.add(lblisIrregular);

		rdbtnYes = new JRadioButton("Yes");
		panelIsIrregular.add(rdbtnYes);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		panelIsIrregular.add(rdbtnNo);

		irregularGroup = new ButtonGroup();
		irregularGroup.add(rdbtnYes);
		irregularGroup.add(rdbtnNo);

		panelAddProduct = new JPanel();
		addProductPane.add(panelAddProduct);

		btnAddProduct = new JButton("Add Product");
		panelAddProduct.add(btnAddProduct);

		btnCancelProduct = new JButton("Cancel");
		panelAddProduct.add(btnCancelProduct);

		// FINALIZE
		finalizePane = new JPanel();
		contentPane.add(finalizePane, FINALIZE);
		finalizePane.setLayout(new BoxLayout(finalizePane, BoxLayout.Y_AXIS));

		panelChooseParcel = new JPanel();
		finalizePane.add(panelChooseParcel);
		panelChooseParcel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblChooseParcel = new JLabel("Choose Parcel:");
		panelChooseParcel.add(lblChooseParcel);

		cmbChooseParcel = new JComboBox<> ();;
		panelChooseParcel.add(cmbChooseParcel);

		panelNameOfRecipient = new JPanel();
		finalizePane.add(panelNameOfRecipient);
		panelNameOfRecipient.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNameOfRecipient = new JLabel("Name of Recipient:");
		panelNameOfRecipient.add(lblNameOfRecipient);

		tfRecipientName = new JTextField();
		panelNameOfRecipient.add(tfRecipientName);
		tfRecipientName.setColumns(10);

		panelDestination = new JPanel();
		finalizePane.add(panelDestination);

		lblDestination = new JLabel("Destination:");
		panelDestination.add(lblDestination);

		rdbtnMetroManila = new JRadioButton("Metro Manila");
		rdbtnMetroManila.setSelected(true);
		panelDestination.add(rdbtnMetroManila);

		rdbtnLuzon = new JRadioButton("Luzon");
		panelDestination.add(rdbtnLuzon);

		rdbtnVisayas = new JRadioButton("Visayas");
		panelDestination.add(rdbtnVisayas);

		rdbtnMindanao = new JRadioButton("Mindanao");
		panelDestination.add(rdbtnMindanao);

		destGroup = new ButtonGroup();
		destGroup.add(rdbtnMetroManila);
		destGroup.add(rdbtnLuzon);
		destGroup.add(rdbtnVisayas);
		destGroup.add(rdbtnMindanao);

		panelInsure = new JPanel();
		finalizePane.add(panelInsure);
		panelInsure.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblInsureAllItems = new JLabel("Insure all items? (Additional 5.00 php/item)");
		panelInsure.add(lblInsureAllItems);

		rdbtnYesInsure = new JRadioButton("Yes");
		rdbtnYesInsure.setSelected(true);
		panelInsure.add(rdbtnYesInsure);

		rdbtnNoInsure = new JRadioButton("No");
		panelInsure.add(rdbtnNoInsure);

		insureGroup = new ButtonGroup();
		insureGroup.add(rdbtnYesInsure);
		insureGroup.add(rdbtnNoInsure);

		panelCheckout = new JPanel();
		finalizePane.add(panelCheckout);
		panelCheckout.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnCheckout = new JButton("Checkout");
		panelCheckout.add(btnCheckout);

		btnBackToItems = new JButton("Back To Items");
		panelCheckout.add(btnBackToItems);

		// TRACKING

		trackingPane = new JPanel();
		contentPane.add(trackingPane, TRACKING);
		trackingPane.setLayout(new BorderLayout(0, 0));

		panelTrackingNumber = new JPanel();
		trackingPane.add(panelTrackingNumber, BorderLayout.NORTH);
		panelTrackingNumber.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblEnterTracking = new JLabel("Enter Tracking Number:");
		panelTrackingNumber.add(lblEnterTracking);

		tfTrackingNumber = new JTextField();
		panelTrackingNumber.add(tfTrackingNumber);
		tfTrackingNumber.setColumns(20);

		btnSearch = new JButton("Search");
		panelTrackingNumber.add(btnSearch);

		panelTrackResult = new JPanel();
		trackingPane.add(panelTrackResult, BorderLayout.CENTER);
		panelTrackResult.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		taTrackResult = new JTextArea();
		panelTrackResult.add(taTrackResult);

		panelReturnFromTracking = new JPanel();
		trackingPane.add(panelReturnFromTracking, BorderLayout.SOUTH);

		btnExitTracking = new JButton("Return To Menu");
		panelReturnFromTracking.add(btnExitTracking);

		// CHECKOUT PANE
		checkoutPane = new JPanel();
		contentPane.add(checkoutPane, CHECKOUT);
		checkoutPane.setLayout(new BoxLayout(checkoutPane, BoxLayout.Y_AXIS));

		taBreakdown = new JTextArea();
		taBreakdown.setBackground(Color.WHITE);
		taBreakdown.setEditable(false);
		checkoutPane.add(taBreakdown);

		taTrackInfo = new JTextArea();
		taTrackInfo.setEditable(false);
		checkoutPane.add(taTrackInfo);

		panelReturnToMenu = new JPanel();
		checkoutPane.add(panelReturnToMenu);
		panelReturnToMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnReturnToMenu = new JButton("Return To Menu");
		panelReturnToMenu.add(btnReturnToMenu);
	}

	public void addListeners(EventListener listener)
	{
		btnSendAParcel.addActionListener ((ActionListener) listener);
		btnTrackAParcel.addActionListener ((ActionListener) listener);
		btnAddADocument.addActionListener ((ActionListener) listener);
		btnAddAProduct.addActionListener ((ActionListener) listener);
		btnAddDocument.addActionListener ((ActionListener) listener);
		btnCancelDoc.addActionListener ((ActionListener) listener);
		btnAddProduct.addActionListener ((ActionListener) listener);
		btnCancelProduct.addActionListener ((ActionListener) listener);
		btnCheckParcel.addActionListener ((ActionListener) listener);
		btnRemove.addActionListener ((ActionListener) listener);
		btnProceed.addActionListener ((ActionListener) listener);
		btnBackToMenu.addActionListener ((ActionListener) listener);
		btnSearch.addActionListener ((ActionListener) listener);
		btnExitTracking.addActionListener ((ActionListener) listener);
		btnCheckout.addActionListener ((ActionListener) listener);
		btnBackToItems.addActionListener ((ActionListener) listener);
		btnReturnToMenu.addActionListener ((ActionListener) listener);
		btnLogin.addActionListener ((ActionListener) listener);
		btnLogout.addActionListener ((ActionListener) listener);
		btnConfirmLogout.addActionListener ((ActionListener) listener);
		btnCancelLogout.addActionListener ((ActionListener) listener);
	}

	public void updateContentPane (String name)
	{
		CardLayout cards = (CardLayout) contentPane.getLayout ();
		cards.show(contentPane, name);
	}
	
	public void updateLogoutPanel (String name)
	{
		CardLayout cards = (CardLayout) menuLogoutPanel.getLayout ();
		cards.show(menuLogoutPanel, name);
	}

	public void updateDate(String date)
	{
		tfDate.setText(date);
	}

	public String getUsername()
	{
		return tfUsername.getText();
	}

	public String getPassword()
	{
		return String.valueOf( pfPassword.getPassword() );
	}
	
	public String getLogoutPassword()
	{
		return String.valueOf( pfLogout.getPassword() );
	}
	
	public void resetLogoutPassword()
	{
		pfLogout.setText("");
	}
	public void resetLoginInfo()
	{
		tfUsername.setText("");
		pfPassword.setText("");
	}

	public double[][] getDocumentDimensions()
	{
		double[][] d = new double[1][3];
		d[0][0] = Double.parseDouble( tfWidthDoc.getText() );
		d[0][1] = Double.parseDouble( tfLengthDoc.getText() );
		d[0][2] = Double.parseDouble( tfNumberOfPages.getText() );
		return d;
	}

	public double[][] getProductDimensions()
	{
		double[][] d = new double[1][4];
		d[0][0] = Double.parseDouble( tfWidthProduct.getText() );
		d[0][1] = Double.parseDouble( tfLengthProduct.getText() );
		d[0][2] = Double.parseDouble( tfHeight.getText() );
		d[0][3] = Double.parseDouble( tfWeight.getText() );
		return d;
	}

	public boolean getIsIrregular()
	{
		return rdbtnYes.isSelected();
	}

	public void resetDimensions()
	{
		tfWidthDoc.setText("");
		tfLengthDoc.setText("");
		tfNumberOfPages.setText("");
		tfWidthProduct.setText("");
		tfLengthProduct.setText("");
		tfWeight.setText("");
		tfHeight.setText("");
	}

	public String getRecipientName()
	{
		return tfRecipientName.getText();
	}

	public void resetRecipientName()
	{
		tfRecipientName.setText("");
	}

	public String getDestCode()
	{
		if( rdbtnMetroManila.isSelected() )
			return "MML";
		else if (rdbtnLuzon.isSelected() )
			return "LUZ";
		else if (rdbtnVisayas.isSelected() )
			return "VIS";
		else
			return "MIN";
	}

	public String getIsInsured()
	{
		if ( rdbtnYesInsure.isSelected() )
			return "Yes";
		else
			return "No";
	}

	public String getTrackingNumber()
	{
		return tfTrackingNumber.getText();
	}

	public void updateTrackResult(String tr)
	{
		taTrackResult.setText(tr);
	}

	public void resetTracking()
	{
		tfTrackingNumber.setText("");
		taTrackResult.setText("");
	}

	public void updateBreakdown(String str)
	{
		taBreakdown.setText(str);
	}

	public void updateTrackInfo(String str)
	{
		taTrackInfo.setText(str);
	}
	public void resetBreakdown()
	{
		taBreakdown.setText("");
	}

	public int getSelectedItemIndex()
	{
		return cmbAddedItems.getSelectedIndex();
	}

	public int getSelectedParcelIndex()
	{
		return cmbChooseParcel.getSelectedIndex();
	}
	public Parcel getSelectedParcel()
	{
		return (Parcel) cmbChooseParcel.getSelectedItem();
	}

	public void updateCMBAvailableParcels(ArrayList<Parcel> parcels)
	{
		cmbAvailableParcels.removeAllItems();
		for(int i=0; i<parcels.size(); i++)
			cmbAvailableParcels.addItem( parcels.get(i) );
	}

	public void updateCMBAddedItems(ArrayList<Item> items)
	{
		cmbAddedItems.removeAllItems();
		for(int i=0; i<items.size(); i++)
			cmbAddedItems.addItem( items.get(i) );
	}

	public void updateCMBChooseParcel(ArrayList<Parcel> parcels)
	{
		cmbChooseParcel.removeAllItems();
		for(int i=0; i<parcels.size(); i++)
			cmbChooseParcel.addItem( parcels.get(i) );
	}

	public void resetCMB()
	{
		resetRecipientName();
		cmbAvailableParcels.removeAllItems();
		cmbAddedItems.removeAllItems();
		cmbChooseParcel.removeAllItems();
	}


}
