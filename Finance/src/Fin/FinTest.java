package Fin;

public class FinTest {

	public static void main(String[] args) {
		Payable[] payableObjects = new Payable[6];
		payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
		payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
		payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		payableObjects[3] = new HourlyEmployee("Tijani", "Smith", "222-222-222", 5.0, 56.5);
		payableObjects[4] = new CommissionEmployee("Tope", "Gottigen", "555-555-555", 0.2, 92.4);
		payableObjects[5] = new BasePlusCommissionEmployee("Bola", "Trump", "444-333-111", 0.2, 92.4,800.00);
	
		System.out.println("Invoices and Employees Processed Polymorphically");
		
		// generically process each element in array Payable
		for(Payable currentPayable:payableObjects) {
			System.out.printf("%n%s %n%s: $%,.2f%n", currentPayable.toString(),"payment due",
					currentPayable.getPaymentAmount());
			
		}
	}
	
}
