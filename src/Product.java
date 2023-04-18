/**	The class Product is an extension of the Item class, that inherits the attributes of the Item class.
 	The Product class also represents a Product object that has a boolean attribute as to whether the
 	product is irregular or not.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/
public class Product extends Item
{
	//constructor
	/**	This constructor gets the Product's width, length, height, weight, and
	 	a boolean checker as to whether the Product is irregular or not.
	 	Note: the constructor of the Product uses the constructor of the abstract
	 		  class Item.

	 	@param w a double width value
	 	@param l a double length value
	 	@param h a double height value
	 	@param kg a double weight value
	 	@param isIrreg a boolean checker for irregularity value
	*/
	public Product(double w, double l, double h, double kg, boolean isIrreg)
	{
		super(l, w, h);
		weight = kg;
		this.isIrreg = isIrreg;
	}

	//method
	/**	This method gets the condition of the product as to whether the product is irregularly shaped or not.

	 	@return a boolean condition for irregularity of Product
	*/
	public boolean isIrregular()
	{
		return isIrreg;
	}

	/**	 This method overrides the toString() of the Object class
	     and will return all the values of the object as a String

		 @return String concatenation of the width, length, height, and
		 weight of the Product.
	*/
	public String toString()
	{
		if( isIrreg)
			return "Product (" + getLength()  + " x " + getWidth() + " x " + getHeight() + "). Weight: " + getWeight() + " kg. Vol. Weight: + Irregular.";
		else
			return "Product (" + getLength()  + " x " + getWidth() + " x " + getHeight()+ "). Weight: " + getWeight() + " kg.";
	}

	public double getVolumetricWeight()
	{
		return length * width * height / 305;
	}


	//attributes
	private boolean isIrreg;
}