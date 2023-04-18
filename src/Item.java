/**	The class Item is an abstract class that represents an Item object that has a width, length,
 	weight, and height, and can also rotate its orientation.

 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz

 	@version 1.00 2019/8/1
*/
public abstract class Item
{
	//constructors
	/**	This constructor gets the width and length of the Item.

		@param w a double width value
		@param l a double length value
	*/
	public Item(double w, double l)
	{
		width = w;
		length = l;
	}

	/**	This constructor gets the width, length, and height of the Item.

		@param w a double width value
		@param l a double length value
		@param h a double height value
	*/
	public Item(double w, double l, double h)
	{
		this(w,l);
		height = h;
	}

	//methods
	/**	This method gets the Width of the Item.

	 	@return a double width value
	*/
	public double getWidth()
	{
		return width;
	}

	/**	This method gets the Length of the Item.

	 	@return a double length value
	*/
	public double getLength()
	{
		return length;
	}

	/**	This method gets the Height of the Item.

	 	@return a double height value
	*/
	public double getHeight()
	{
		return height;
	}

	/**	This method gets the Weight of the Item.

	 	@return a double weight value
	*/
	public double getWeight()
	{
		return weight;
	}
	
	/**	This method rotates the orientation of the Item.
	*/
	public void Rotate()
	{
		double max=0, min=0, mid=0;

		if( length >= width && length >= height)
		{
			// if l is greater or equal to both w and h, it is max
			max = length;

			if(width >= height)
			{

				mid = width;
				min = height;
			}
			else
			{
				mid = height;
				min = width;
			}
		}

		else if( length <= width && length >= height)
		{
			// if l is less than/equal w but greater than/equal h it is mid
			mid = length;
			max = width;
			min = height;
		}

		else if( length >= width && length <= height)
		{
			// if l is less than/equal h but greater than/equal w it is mid
			mid = length;
			max = height;
			min = width;
		}

		else if( length <= width && length <= height)
		{
			// if l is less than both w and h then it is min
			min = length;

			if(width >= height)
			{
				max = width;
				mid = height;
			}
			else
			{
				max = height;
				mid = width;
			}
		}

		length = max;
		width = mid;
		height = min;
		// Product tp = new Product(max, mid, min, weight, isIrregular);
	}
	//attributes
	protected double width;
	protected double length;
	protected double weight;
	protected double height;
}

