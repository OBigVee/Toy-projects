package Fin;

public class HourlyEmployee extends Employee{
	private double hour;
	private double wages;
	public HourlyEmployee(String firstName,String lastName, String socialSecurityNumber,double hour, double wages) {
		super(firstName, lastName, socialSecurityNumber);
		
		if (hour<0.0) throw new IllegalArgumentException("hour can't be < 0.00");
		this.hour = hour;
		if (wages<0.0) throw new IllegalArgumentException("wages can't be < 0.0");
		this.wages = wages;
			
	}
	
	public void setWages(double wages) {
		if (wages<0.0) throw new IllegalArgumentException("wages can't be < 0.0");
		this.wages = wages;
	}
	public double getWages() {
		return wages;
	}
	public void setHour(double hour) {
		
		if (hour<0.0) throw new IllegalArgumentException("hour can't be < 0.00");
		this.hour = hour;
	}
	public double getHour() {
		return hour;
	}
	public double getPaymentAmount() {
		if (getHour()<=40){
			return getHour()*getWages();
		}else {
			return 40 * getWages() + (getHour() - 40) * getWages() * 1.5;
		}
	}
	public String toString() {
		
		return String.format("Hourly-employee:%n%s%n%s$%,.1f%n%s:$%,.2f%n%s: $%,.2f",
				super.toString(),"hours-worked-for:",getHour(),"wages",getWages(),
							"Payment-Amount",getPaymentAmount());
	}
}
