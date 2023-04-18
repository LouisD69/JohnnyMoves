import java.text.DecimalFormat;
import java.util.Calendar;
/**	The class Tracker represents a Tracker Object that keeps track of the status and keeps necessary information
 *	regarding a parcel shipped by Johnny Moves Class.
 *
 *	@author Giann Jericho Marasigan
 *	@author Alexis Louis Dela Cruz
 *
 *	@version 1.00 2019/8/1
*/
public class Tracker
{
	//constructor
  	/** Constructs a Tracker Object

		@param parcelType a String type of Parcel
		@param recipient a String name of recipient
		@param destCode a String 3-letter representation of destinations
		@param isInsured a String representation of whether a parcel is insured or not
		@param sequence an integer sequence denoting the order in which the parcel was sent in a certain day
		@param nItems an integer nItems denoting the number of items in the parcel
		@param cal an object of Calendar class
	*/
	public Tracker(String parcelType, String recipient, String destCode, String isInsured, int sequence, int nItems, Calendar cal)
	{
		this.recipient = recipient;
		this.destCode = destCode;
		this.isInsured = isInsured;
		this.sequence = sequence;
		this.nItems = nItems;
		this.parcelType = parcelType; // for now, manual set.
		statusInd = 0;

		// start date and arrival date
		int i = 0;
		this.cal = (Calendar) cal.clone();
		Calendar temp = (Calendar) cal.clone();

		if(destCode.equals("MML"))
			i = 1;
		else if(destCode.equals("LUZ"))
			i = 2;
		else if(destCode.equals("VIS"))
			i = 4;
		else if(destCode.equals("MIN"))
			i = 7;

		startMonth = cal.get(Calendar.MONTH) + 1;
		startDay = cal.get(Calendar.DAY_OF_MONTH);
		startYear = cal.get(Calendar.YEAR);

		temp.add(Calendar.DATE, i); //adds days to start date depending on destcode, to create arrival date
		arrivalMonth = temp.get(Calendar.MONTH) + 1;
		arrivalDay = temp.get(Calendar.DAY_OF_MONTH);
		arrivalYear = temp.get(Calendar.YEAR);
	}

	//methods
  	/** Returns the name of the recipient of the parcel

		@return String recipient
	*/
	public String getRecipient()
	{
		return recipient;
	}

  	/** Returns the destination code of the parcel

		@return String destCode
	*/
	public String getDestCode()
	{
		return destCode;
	}

  	/** Returns the number of items in the parcel
		@return integer nItems;
	*/
	public int getNItems()
	{
		return nItems;
	}

  	/** Creates a unique track number associated with a parcel with the purpose of tracking it.
	*/
	public void generateTrackNum()
	{
		String pattern1 = "000"; // to format int sequence in 3 digits
		String pattern2 = "00"; // to format int nItems in 2 digits
		DecimalFormat df1 = new DecimalFormat(pattern1);
		DecimalFormat df2 = new DecimalFormat(pattern2);

		String temp;
		temp = parcelType;
		temp = new String(temp.concat(mmdd) );
		temp = new String(temp.concat(destCode) );
		temp = new String(temp.concat(df2.format(nItems)) );
		temp = new String(temp.concat(df1.format(sequence)) );

		trackNum = temp;
	}

  	/** Returns the track number of the parcel

		@return String trackNum;
	*/
	public String getTrackNum()
	{
		return trackNum;
	}

	/**	This method returns the status of the parcel using the tracker.

	 	@return a String status of the parcel
	*/
	public String getStatus()
	{
		return status[statusInd];
	}

  	/** This method overrides the toString() of the Object class
	    and will return necessary values of the object as a String

		@return String concatenation of recipient, track number, starting month, starting day, starting year, arrival month, arrival day, arrival year
	*/
	public String toString()
	{
		return "Parcel Recipient: " + recipient + "\nParcel Insured: " + isInsured + "\nTrack no.: " + trackNum + "\nDestination: " + destCode + "\nStart Date: "
		+ startMonth + '-' + startDay + '-' + startYear + "\nArrival Date: " + arrivalMonth + '-' + arrivalDay + '-' + arrivalYear
		+ "\nStatus: " + status[statusInd];
	}

  	/** Sets the mmdd code of the Tracker, which will be used to generate a Tracking number

		@param mmdd a String representing 2-digit month code, and 3-digit sequence code
	*/
	public void setMMDD(String mmdd)
	{
		this.mmdd = mmdd;
	}

  	/** Updates the status of a tracker from "Preparing" to "Shipping" or "Delivered" based on arrival date of the parcel

		@param currMonth an integer which is the current month set in Johnny Moves Class
		@param currDay an integer which is the current day set in Johnny Moves Class
		@param currYear an integer which is the current year set in Johnny Moves Class
	*/
	public void updateStatus(int currMonth, int currDay, int currYear)
	{
		if(statusInd != 2) // if status is already delivered, no need to update the status
		{
			if( !destCode.equals("MML") ) // if not delivering to MML, a difference in current day and start day means the status should change from preparing to delivering
				if( currDay != startDay)
					statusInd = 1;
			if( currMonth == arrivalMonth && currDay == arrivalDay && currYear == arrivalYear) // if all date fields are equal, then the parcel has arrived to the destination
				statusInd = 2;
		}
	}

	public String isParcelInsured()
	{
		return isInsured;
	}
    //attributes
    private String recipient;
    private String destCode;
	private String isInsured;
	private String trackNum;
	private String parcelType;
	private int nItems;
	private int sequence;
	private String mmdd;
	private Calendar cal;
	private int startMonth;
	private int startDay;
	private int startYear;
	private int arrivalMonth;
	private int arrivalDay;
	private int arrivalYear;
	private static final String[] status =
	{
		"Preparing",
		"Shipping",
		"Delivered"
	};
	private int statusInd;
}