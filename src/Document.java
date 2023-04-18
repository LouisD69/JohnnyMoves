/**	The class Document is an extension of the Item class, that inherits the attributes of the Item class.
 	The Document class also represents a Document object that has a number of pages.
 	
 	@author Giann Jericho Marasigan
 	@author Alexis Louis Dela Cruz
 	
 	@version 1.00 2019/8/1
*/
public class Document extends Item
{
	//constructor
	/**	This constructor gets the Document's width, length, and number of pages the 
	 	Document has.
	 	Note: the constructor of the Document uses the constructor of the abstract
	 		  class Item.
	 	
	 	@param w a double width value
	 	@param l a double length value
	 	@param nPages an integer number of pages
	*/
	public Document(double w, double l, int nPages)
	{
		super(w, l);
		this.nPages = nPages;
		weight = nPages * 0.008;
		height = nPages * 0.04;
	}
	
	//methods
	/**	This method gets the number of pages the document has.
	 	
	 	@return an integer number of pages
	*/
	public int getNumPages()
	{
		return nPages;
	}

	/**	 This method overrides the toString() of the Object class
	     and will return all the values of the object as a String
		  
		 @return String concatenation of the width, length, number of pages, and
		 weight of the Document.
	*/
	public String toString()
	{
		return "Document (" + getLength()  + " x " + getWidth() + "). No. of Pages: " + getNumPages() + ". Weight: " + getWeight() + " kg";
	}
	//attributes
	private int nPages;
}


