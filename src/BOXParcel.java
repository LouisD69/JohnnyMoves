/**	The class BOXParcel is an extension of the Parcel class, that inherits the attributes of the Parcel class.
 	The BOXParcel class also represents a Box Parcel object that has a boolean attribute as to whether the
 	Box Parcel contains an irregular object or not. the Box Parcel also has a regular rate, volumetric weight rate,
 	and actual weight rate.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/
public class BOXParcel extends Parcel
{
	//constructor
	/**	This constructor gets the Box Parcel's width, length, and height.
	 	Note: the constructor of the Box Parcel uses the constructor of the abstract
	 		  class Parcel.

	 	@param w a double width value
	 	@param l a double length value
	 	@param h a double height value
	*/
	public BOXParcel(double l, double w, double h)
	{
		super(l,w,h);
	}

	//methods
	/**	This method gets the condition of the Box Parcel as to whether the Box Parcel contains an Irregular shaped Product or not.

	 	@return a boolean condition for the Irregular Product inside the Box Parcel
	*/
	public boolean containsIrregular()
	{
		int i = 0;
		boolean found = false;

		while(i<items.size() && !found)
		{
			if(items.get(i) instanceof Product)
				if( ((Product) items.get(i)).isIrregular() )
					found = true;

			i++;
		}

		return found;
	}

	/**	 This method overrides the toString() of the Object class
	     and will return all the values of the object as a String

		 @return String concatenation of the length, width, and height of the Box Parcel
	*/
	public String toString()
	{
		return "Box Parcel dimensions: (" + length + " x " + width
				+ " x " + height + " )";
	}

	/**	This method computes for the base rate of the Box Parcel.

	 	@return a double base rate value
	*/
	@Override
	public double computeBaseRate()
	{
		if( containsIrregular() )
		{
			double d=0, temp1, temp2;

			for(int i=0; i<items.size(); i++)
			{
				if( items.get(i) instanceof Document )
					d += ( Math.ceil( items.get(i).getWeight() ) * RR );
				else if( items.get(i) instanceof Product )
				{
					if( ((Product) items.get(i)).isIrregular() )
					{
						temp1 = ((Product) items.get(i)).getVolumetricWeight() * VWR;
						temp2 = items.get(i).getWeight() * AWR;
						if( temp1 > temp2 )
							d += temp1;
						else
							d += temp2;
					}
					else
						d += ( items.get(i).getWeight() * RR );
				}
			}
			return d;
		}
		else
			return RR * Math.ceil( getTotalItemWeight() );
	}
	//attributes
	public static final double RR = 40.0; // regular rate
	public static final double VWR = 30.0; // volumetric weight rate
	public static final double AWR = 40.0; // actual weight rate
}
