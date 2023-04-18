/**	The class FLTParcel is an extension of the Parcel class, that inherits the attributes of the Parcel class.
 	The FLTParcel class also represents a Flat Parcel object that has a Weight and a baseRate.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/
public class FLTParcel extends Parcel
{
	//constructor

	/**	This constructor gets the Flat Parcel's width, length, height, and rate.
	 	Note: the constructor of the Flat Parcel uses the constructor of the abstract
	 		  class Parcel.
	 		  
		@param l a double length value
	 	@param w a double width value
	 	@param h a double height value
	 	@param r a double rate value
	*/
	public FLTParcel(double l, double w, double h, double r)
	{
		super(l,w,h);
		baseRate = r;
	}

	//methods
	/**	This method returns the base rate of the Flat parcel.
	 	
	 	@return a double base rate value
	*/ 
	@Override
	public double computeBaseRate() 
	{
		return baseRate;
	}

	/**	 This method overrides the toString() of the Object class
	     and will return all the values of the object as a String

		 @return String concatenation of the width, length, and height of the Flat Parcel
	*/
	public String toString()
	{
		return "Flat Parcel dimensions: (" + length + " x " + width
			+ " x " + height + " )";
	}
	//attributes
	public static final double WEIGHT = 3.0;
	private final double baseRate;
}
