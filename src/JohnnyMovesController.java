import java.awt.event.*;
import javax.swing.JOptionPane;



public class JohnnyMovesController implements ActionListener
{
	private JohnnyMoves jm;
	private JohnnyMovesGUI gui;

	public JohnnyMovesController(JohnnyMoves jm, JohnnyMovesGUI gui)
	{
		this.gui = gui;
		this.jm = jm;
		gui.addListeners (this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		if( e.getActionCommand().equals("Send A Parcel") )
		{
			gui.updateContentPane(gui.SENDPARCEL);
		}
		else if( e.getActionCommand().equals("Track A Parcel") )
		{
			gui.updateContentPane(gui.TRACKING);
		}

		else if( e.getActionCommand().equals("Logout") )
		{
			gui.updateLogoutPanel(gui.PWLOGOUT);

		}
		else if( e.getActionCommand().equals("Cancel Logout") )
		{
			gui.updateLogoutPanel(gui.MENULOGOUT);
		}
		else if( e.getActionCommand().equals("Confirm Logout") )
		{
			if ( gui.getLogoutPassword().equals( gui.PASSWORD ) )
			{
				jm.generateDailyFile();
				jm.generateMainTransacFile();
				jm.nextDay();
				gui.updateLogoutPanel(gui.MENULOGOUT);
				gui.updateContentPane( gui.LOGIN);
				reset();
				JOptionPane.showMessageDialog(null, "Report Generated",
					"Logged Out", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You entered an unauthorized username or password",
						"Access Denied", JOptionPane.ERROR_MESSAGE);
				gui.resetLogoutPassword();
			}
		}
		else if( e.getActionCommand().equals("Login") )
		{
			if( !gui.getUsername().equals(gui.USERNAME) || !gui.getPassword().equals(gui.PASSWORD) )
			{
				JOptionPane.showMessageDialog(null, "You entered an unauthorized username or password",
						"Access Denied", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				gui.updateDate( jm.dateToString() );
				gui.updateContentPane(gui.MENU);
			}
			gui.resetLoginInfo();
		}
		else if( e.getActionCommand().equals("Add a Document") )
		{
			gui.updateContentPane(gui.ADDDOC);
		}
		else if( e.getActionCommand().equals("Add a Product") )
		{
			gui.updateContentPane(gui.ADDPRODUCT);
		}
		else if( e.getActionCommand().equals("Check Parcel") )
		{
			jm.checkParcelOptions();
			gui.updateCMBAvailableParcels( jm.getParcelOptions() );
			gui.updateCMBAddedItems(jm.getItemQueue());
			if( jm.getParcelOptions().isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "Sorry, we do not have a parcel that can accomodate all of your items",
									"No Parcel Available", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if( e.getActionCommand().equals("Remove") )
		{
			if( jm.getItemQueue().isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "No item can be removed. Please add items first.",
						"No Items Added!", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				jm.getItemQueue().remove( gui.getSelectedItemIndex() ) ;
				gui.updateCMBAddedItems(jm.getItemQueue() );
			}
		}
		else if( e.getActionCommand().equals("Proceed") )
		{
			if( jm.getItemQueue().isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "You did not add an item to be shipped. Please add an item first",
						"No Items Added!", JOptionPane.ERROR_MESSAGE);
			}
			else if( jm.getParcelOptions().isEmpty() )
			{
				JOptionPane.showMessageDialog(null, "Sorry, we do not have a parcel that can accomodate all of your items",
						"No Parcel Available", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				jm.checkParcelOptions();
				gui.updateCMBChooseParcel( jm.getParcelOptions() );
				gui.updateContentPane(gui.FINALIZE);
			}
		}
		else if( e.getActionCommand().equals("Back To Menu") )
		{
			reset();
			gui.updateContentPane(gui.MENU);
		}
		else if( e.getActionCommand().equals("Add document") )
		{
			double[][] d = gui.getDocumentDimensions();
			jm.getItemQueue().add( new Document(d[0][0], d[0][1], (int) d[0][2]) );
			gui.updateCMBAddedItems(jm.getItemQueue());
			gui.resetDimensions();
			gui.updateContentPane(gui.SENDPARCEL);
		}
		else if( e.getActionCommand().equals("Add Product") )
		{
			double[][] d = gui.getProductDimensions();
			jm.getItemQueue().add( new Product(d[0][0], d[0][1], d[0][2], d[0][3], gui.getIsIrregular()) );
			gui.updateCMBAddedItems(jm.getItemQueue());
			gui.resetDimensions();
			gui.updateContentPane(gui.SENDPARCEL);
		}
		else if( e.getActionCommand().equals("Cancel") )
		{
			gui.resetDimensions();
			gui.updateContentPane(gui.SENDPARCEL);
		}

		else if( e.getActionCommand().equals("Checkout") )
		{
			Parcel p;
			if ( gui.getSelectedParcel() instanceof FLTParcel)
				p = new FLTParcel( gui.getSelectedParcel().getLength(), gui.getSelectedParcel().getWidth(),
					 gui.getSelectedParcel().getHeight(), ((FLTParcel) gui.getSelectedParcel()).computeBaseRate() );
			else
				p = new BOXParcel( gui.getSelectedParcel().getLength(), gui.getSelectedParcel().getWidth(),
					 gui.getSelectedParcel().getHeight() );


			p.toString();
			p.resetParcelContents();
			p.addItems( jm.getItemQueue() );
			jm.addTracker( p, gui.getRecipientName(), gui.getDestCode(),
					gui.getIsInsured(), jm.getSequence() );
			p.setTracker( jm.getLatestTracker() );
			jm.resetItemQueue();
			gui.updateBreakdown( p.breakdown() );
			gui.updateTrackInfo( jm.getLatestTracker().toString() );
			// compute fee, give the breakdown
			gui.updateContentPane(gui.CHECKOUT);
		}

		else if( e.getActionCommand().equals("Back To Items") )
		{
			gui.updateContentPane(gui.SENDPARCEL);
		}
		else if( e.getActionCommand().equals("Search") )
		{
			gui.updateTrackResult( jm.searchTracker( gui.getTrackingNumber() ) );
		}
		else if( e.getActionCommand().equals("Return To Menu") )
		{
			reset();
			gui.updateContentPane(gui.MENU);
		}

	}

	public void reset()
	{
		jm.resetItemQueue();
		jm.resetParcelOptions();
		gui.resetCMB();
		gui.resetBreakdown();
		gui.resetTracking();
		gui.resetLogoutPassword();

	}



}
