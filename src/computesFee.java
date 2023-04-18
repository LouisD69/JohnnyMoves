/**	The class computesFee is an interface that is used by the Parcel class. This interface includes abstract computations
 	for the Base Rate, Insurance fee, Destination fee, and the Total fee of the Parcel. The interface also generates a
 	breakdown of the cost of the parcel.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/

import java.text.DecimalFormat;

public interface computesFee
{
	//methods
	/**	This method is an abstract method for the computation of the Parcel's Base Rate.
	 	Note: This abstract method is to be overriden by the FLTParcel Class and BOXParcel class.

	 	@return a double base rate value
	*/
	public abstract double computeBaseRate(); // overridden in FLTParcel and BOXParcel Class

	/**	This method is an abstract method for the computation of the Parcel's Insurance Fee.
	 	Note: This abstract method is to be overriden by the Parcel Class.

	 	@return a double Insurance Fee value
	*/
	public abstract double computeInsuranceFee(); // overridden in Parcel Class

	/**	This method is an abstract method for the computation of the Parcel's Destination Fee.
	 	Note: This abstract method is to be overriden by the Parcel class.

	 	@return a double base Destination Fee value
	*/
	public abstract double computeDestinationFee(); // overridden in Parcel Class

	/**	This method computes for the total fee of the Parcel.

	 	@return a double total fee value
	*/
	public default double computeTotalFee()
	{
		return computeBaseRate() + computeInsuranceFee() + computeDestinationFee();
	}

	/**	This method shows the breakdown of costs of the Parcel.

	 	@return a String concatenation of the Parcel's Base Rate, Insurance Fee, Destination Fee, and Total Fee
	*/
	public default String breakdown()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return "Parcel Base Rate: " + df.format( computeBaseRate() ) + " php \n" +
			"Added price based on destination: " + df.format( computeDestinationFee() ) + " php \n" +
			"Insurance fee: " + df.format( computeInsuranceFee() )+ " php \n" +
			"Total fee: " + df.format( computeTotalFee() ) + " php \n";
	}
}
