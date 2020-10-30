package Fin;

public class Invoice implements Payable{
	private final String partNumber;
	private final String partDescription;
	private int quantity;
	private double pricePerItem;
	
	
	public Invoice (String partNumber, String partDescription,
					int quantity, double pricePerItem) {
		
		if (quantity < 0) 
			throw new IllegalArgumentException(
					"Quantity must be greater than 0");
		if(pricePerItem < 0.0) 
			throw new IllegalArgumentException(
					"each price must be > 0.0");
		
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
		this.partDescription = partDescription;
		this.partNumber = partNumber;
		
		
	}// end Constructor
	
	//get part number
	public String getPartNumber() {
		return partNumber;
	}
	
	// get partDescription
	public String getPartDescription() {
		return partDescription;
	}
	
	//set quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}
	// get quantity
	public int getQuantity() {
		return quantity;
	}
	// set price per item
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;	
	}
	
	// get price per Item
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	// return String representation of Invoice object
	@Override
	public String toString() {
		return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
				"invoice","part number", getPartNumber(),getPartDescription()
				,"quantity",getQuantity(),
				"price per item", getPricePerItem());
		
	}
	
	// meth0d required to carry out contract with interface payable
	@Override
	public double getPaymentAmount() {
		return getQuantity()*getPricePerItem();
	}
	
	
}
