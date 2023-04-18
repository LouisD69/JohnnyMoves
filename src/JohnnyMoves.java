import java.util.Calendar;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.*;
/**	The JohnnyMoves Class represents a JohnnyMoves object that has an Arraylist of Items, Parcels, and Trackers. The JohnnyMoves object can
 	add and remove Items from the queue, as well as add and search trackers on the Parcels. The object can also generate A transaction report for the day
 	based on the transactions made. The object can also check for Parcels available for the items in queue.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/
public class JohnnyMoves
{
	//constructor
	/**	This constructor initializes the attributes of JohnnyMoves.
	*/
	public JohnnyMoves()
	{
		parcelOptions = new ArrayList<>();
		itemQueue = new ArrayList<>();
		trackers = new ArrayList<>();
		sequence = 001;
		cal = Calendar.getInstance();
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		year = cal.get(Calendar.YEAR);
		fileNames = new ArrayList<String>();
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			//date = sdf.format(cal.getTime() );
	}

	//methods
	/**	This method generates the Main transaction file, which reads the daily transaction files.
	 	Note: This method also catches possible errors/exceptions that the file generation can have.
	*/
	public void generateMainTransacFile()
	{
		String filename = "Transaction_Report_MAIN.txt";
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			BufferedReader br;
			
			bw.write("Recipient\t\t" + "Tracking Number\t\t" + "Status");
			bw.newLine();
			bw.newLine();
			//input transactions made
			for (int i = 0; i < fileNames.size(); i++)
			{
				br = new BufferedReader (new FileReader(fileNames.get(i) ) );
				String content;
				while ( (content = br.readLine() ) != null )
				{
					if (!content.equalsIgnoreCase("Recipient\t\t" + "Tracking Number\t\t" + "Status") )
					{
						bw.write(content);
						bw.newLine();
					}
				}
				bw.newLine();
				bw.newLine();
			}
			bw.flush();
		
			bw.close();
			osw.close();
			fos.close();
		}

		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage() );
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage() );
		}
	}
	
	/**	This method generates a text file that contains the transaction report for the day.
		Note: This method also catches possible errors/exceptions that the file generation can have.
	*/
	public void generateDailyFile()
	{
		String filename = "Transaction_Report_";
		String file = filename + month + "-" + day + "-" + year + ".txt";
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("\t\t\tAs of " + dateToString() );
			bw.newLine();
			bw.newLine();
			bw.write("Recipient\t\t" + "Tracking Number\t\t" + "Status");
			bw.newLine();
			bw.newLine();
			//input transactions made
			for (int i = 0; i < trackers.size(); i++)
			{
				if(!(trackers.get(i).getStatus().equalsIgnoreCase("Delievered") ) )
				{
					String name = trackers.get(i).getRecipient();
					String num = trackers.get(i).getTrackNum();
					String stat = trackers.get(i).getStatus();
					
					bw.write(name + "\t\t\t" + num + "\t\t" + stat);
					bw.newLine();
				}
			}
			bw.flush();

			bw.close();
			osw.close();
			fos.close();
			
			fileNames.add(file);
		}

		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage() );
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage() );
		}
	}
	
	/**	This method adds items to the queue.

	 	@param item an Item object
	*/
	public void addItem(Item item)
	{
		itemQueue.add(item);
	}

	/**	This method removes items from the queue.

	 	@param item an Item object
	*/
	public void removeItem(Item item)
	{
		if( !itemQueue.isEmpty() )
		{
			itemQueue.remove(item);
		}
	}

	/** Adds a Tracker object t to ArrayList of Tracker trackers.

		@param parcel a Parcel object
		@param recipient a String name of the recipient
		@param destCode a String destination code
		@param isInsured a String status as to whether the Parcel is insured or not
		@param sequence an integer sequence
	*/
	public void addTracker(Parcel parcel, String recipient, String destCode, String isInsured, int sequence)
	{
		String type[] = { "FLT", "BOX"};
		Tracker t;
		if( parcel instanceof FLTParcel)
			t = new Tracker(type[0], recipient, destCode, isInsured, sequence, parcel.getNumItems(), cal);
		else
			t = new Tracker(type[1], recipient, destCode, isInsured, sequence, parcel.getNumItems(), cal);

		String mm, dd;
		String pattern = "00";
		DecimalFormat df = new DecimalFormat(pattern);

		mm = df.format(month);
		dd = df.format(day);
		String temp = mm;
		temp = new String(temp.concat(dd)); // creates the string mmdd, a part of track number
		t.setMMDD(temp); // sets the mmdd which was just created
		t.generateTrackNum(); // because i have the mmdd, i can now generate the track number
		trackers.add(t); // tracker is now complete. add it to the list of trackers
		this.sequence++; // increment sequence ofc
	}

	/**	This method checks for Parcel options that can be used to store the Items in queue.
	*/
	public void checkParcelOptions()
	{
		resetParcelOptions(); // always reset the options

		if( !itemQueue.isEmpty() )
		{
			int i;
			itemQueue.get(0).Rotate();
			double maxL = itemQueue.get(0).getLength();
			double maxW = itemQueue.get(0).getWidth();
			double maxH = itemQueue.get(0).getHeight();
			double maxKG = itemQueue.get(0).getWeight();

			for(i=1; i<itemQueue.size(); i++)
			{
				itemQueue.get(i).Rotate() ;
			}

			for(i=1; i<itemQueue.size(); i++)
			{
				if(itemQueue.get(i).getLength() > maxL)
					maxL = itemQueue.get(i).getLength();
				if(itemQueue.get(i).getWidth() > maxW)
					maxW = itemQueue.get(i).getWidth();
				maxH += itemQueue.get(i).getHeight();
				maxKG += itemQueue.get(i).getWeight();
			}

			for(i=0; i<2; i++)
				if( maxL <= parcels[i].getLength() && maxW <= parcels[i].getWidth() && maxH <= parcels[i].getHeight() && maxKG <= FLTParcel.WEIGHT )
					parcelOptions.add(parcels[i]);
			for(i=2; i<6; i++)
				if( maxL <= parcels[i].getLength() && maxW <= parcels[i].getWidth() && maxH <= parcels[i].getHeight() )
					parcelOptions.add(parcels[i]);
		}
	}

	/** This method gets the sequence of parcels that are to be sent within one day

		@return integer value sequence
	*/
	public int getSequence()
	{
		return sequence;
	}

	/** This method returns the results of a search based on a track number for a previously sent parcel along with its tracking information.

		@param tracknum a String represenation of a track number which will be used as the search key

		@return String representation of the results of search. If tracker was found, returns toString() output of that tracker. Otherwise, return "Parcel not found!"
	*/
	public String searchTracker(String tracknum)
	{
		int i=0;
		boolean found = false;
		String temp = "Parcel not found!";
		while(!found && i<trackers.size() )
		{
			if(tracknum.equals(trackers.get(i).getTrackNum()) )
			{
				temp = new String(trackers.get(i).toString());
				found = true;
			}

			i++;
		}
		return temp;
	}

	/** This method clears the Array List of Documents as well as Array List of Products.
	*/
	public void resetItemQueue()
	{
		itemQueue.clear();
	}

	/**	This method resets the Array List of Parcels.
	*/
	public void resetParcelOptions()
	{
		parcelOptions.clear();
	}

	/** This method returns the Array List of Parcel that can fit the Documents in ArrayList docs.

		@return an ArrayList of FLTParcels
	*/
	public ArrayList<Parcel> getParcelOptions()
	{
		return parcelOptions;
	}

	/**	This method gets the List of items in queue.

	 	@return an ArrayList item queue
	*/
	public ArrayList<Item> getItemQueue()
	{
		return itemQueue;
	}

	/**	This method gets the number of items in queue.

	 	@return an integer number of items in queue
	*/
	public int getItemQueueSize()
	{
		return itemQueue.size();
	}

	/**	This method gets a Calendar object.

	 	@return a Calendar object
	*/
	public Calendar getCalendar()
	{
		return cal;
	}

	/** This method returns the string representation of the date in the class

		@return a String concatenation of month, day, and year to represent a date
	*/
	public String dateToString()
	{
		return String.valueOf(month) + '-' + String.valueOf(day) + '-' + String.valueOf(year);
	}

	/**	This method gets the Latest Tracker generated.

	 	@return a Tracker object
	*/
	public Tracker getLatestTracker()
	{
		return trackers.get( trackers.size() - 1);
	}

	/** This method simulates having a next day, where the date has moved by one day, and the sequence number is reset to 1.
		This will also affect the status of trackers/
	*/
	public void nextDay()
	{
		cal.add(Calendar.DATE, 1);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		year = cal.get(Calendar.YEAR);
		sequence = 1;

		int i;
		for(i=0; i < trackers.size(); i++)
			trackers.get(i).updateStatus(month, day, year);

		resetItemQueue();
	}
	//attributes
	private ArrayList<String> fileNames;
	private ArrayList<Item> itemQueue;
	private ArrayList<Parcel> parcelOptions;
	private ArrayList<Tracker> trackers;
	private int sequence;
	private Calendar cal;
	private int year;
	private int month;
	private int day;

	public static final Parcel[] parcels =
	{
		new FLTParcel(14, 9, 1, 30),
		new FLTParcel(18, 12, 3, 50),
		new BOXParcel(12, 10, 5),
		new BOXParcel(14, 11, 7),
		new BOXParcel(18, 12, 9),
		new BOXParcel(20, 16, 12)
	};

}





















