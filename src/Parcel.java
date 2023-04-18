import java.util.ArrayList;
/**	The class Parcel is an abstract class that represents a Parcel object that has a width, length,height, and a tracker.
 	The Parcel object can also add a list of items in the Parcel, as well as get the number of items inside it, and the total weight of the item.
 	The Parcel object can also compute its destination fee, and insurance fee.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/
public abstract class Parcel implements computesFee
{
	//constructor
	/**	This constructor gets the Parcel's width, length, and height.

		@param l a double length value
	 	@param w a double width value
	 	@param h a double height value
	*/
	public Parcel(double l, double w, double h)
	{
		length = l;
		width = w;
		height = h;
		tracker = null;
		items = new ArrayList<Item>();
	}

	//methods
	/**	This method returns the Width of the Parcel.

		@return	a double width value
	*/
	public double getWidth()
	{
		return width;
	}

	/**	This method returns the Length of the Parcel.

		@return a double length value
	*/
	public double getLength()
	{
		return length;
	}

	/**	This method returns the Height of the Parcel.

	 	@return a double height value
	*/
	public double getHeight()
	{
		return height;
	}

	/**	This method adds the list of items to the Parcel.

	 	@param itemList an ArrayList of items from the Item class
	*/
	public void addItems(ArrayList<Item> itemList)
	{
		for(int i=0; i<itemList.size(); i++)
			items.add(itemList.get(i));
	}

	/**	This method gets the number of items inside the parcel.

		@return an integer item size
	*/
	public int getNumItems()
	{
		return items.size();
	}

	/**	This method gets the total weight of the items inside the parcel.

	 	@return a double total item weight value
	*/
	public double getTotalItemWeight()
	{
		double d=0;
		for(int i=0; i<items.size(); i++)
		{
			d += items.get(i).getWeight();
		}

		return d;
	}

	/**	This method reset/deletes the contents of the parcel.
	*/
	public void resetParcelContents()
	{
		if( items.size() == 0)
			items.clear();
	}

	/**	This method computes for the Destination fee of the Parcel.

	 	@return a double Destination fee value
	*/
	@Override
	public double computeDestinationFee()
	{
		double fee=0, temp1, temp2, temp3, temp4;


		if( tracker.getDestCode().equalsIgnoreCase("MML") )
			fee = 50;
		else if( tracker.getDestCode().equalsIgnoreCase("LUZ") )
			fee = 100;
		else if( tracker.getDestCode().equalsIgnoreCase("VIS") )
		{
			temp1 = getTotalItemWeight() * 0.10;
			temp2 = 1000;
			temp3 = length * width * height / 305 * 0.10;

			if(temp1 >= temp2 && temp1 >= temp3)
				fee = temp1;
			else if(temp2 > temp1 && temp2 >= temp3)
				fee = temp2;
			else
				fee = temp3;
		}
		else if( tracker.getDestCode().equalsIgnoreCase("MIN") )
		{
			temp1 = getTotalItemWeight() * 0.25;
			temp2 = 3000;
			temp3 = length * width * height / 305 * 0.25;

			if(temp1 >= temp2 && temp1 >= temp3)
				fee = temp1;
			else if(temp2 > temp1 && temp2 >= temp3)
				fee = temp2;
			else
				fee = temp3;
		}

		return fee;
	}

	/**	This method computes for the Insurance fee of the parcel.

	 	@return a double insurance fee value
	*/
	public double computeInsuranceFee()
	{
		if (tracker.isParcelInsured().equalsIgnoreCase("Yes") )
			return items.size() * 5;
		else
			return 0;
	}

	/**	This method gets the tracker of the Parcel.

	 	@return a Tracker object
	*/
	public Tracker getTracker()
	{
		return tracker;
	}

	/**	This method sets the value of the tracker t to the tracker of parcel.

	 	@param t a Tracker object
	*/
	public void setTracker(Tracker t)
	{
		tracker = t;
	}
	//attributes
	protected final double width;
	protected final double length;
	protected final double height;
	protected Tracker tracker;
	protected ArrayList<Item> items;
}