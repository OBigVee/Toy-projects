package Fin;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
			double commissionRate, double grossSales,double baseSalary){
		
		super(firstName,lastName,socialSecurityNumber,commissionRate,grossSales);
		if(baseSalary<0.0) throw new IllegalArgumentException(""
				+ "Base Salary must be >=0.0");
		this.baseSalary = baseSalary;
	}
	
	public void setBaseSalary(double baseSalary) {
		if(baseSalary<0.0) throw new IllegalArgumentException(""
				+ "Base Salary must be >=0.0");
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	@Override
	public double getPaymentAmount() {
		return getBaseSalary()+super.getPaymentAmount();
	}
	
	@Override
	public String toString() {
		return String.format(" %s%n %s%n %s:$%,.2f%n %s:$%,.2f",
				"Based-salaried",super.toString(),"Base Salary",getBaseSalary()
				,"Payment Amount",getPaymentAmount());
	}
}
