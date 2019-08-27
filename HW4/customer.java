
public class customer {
	int arrivalTime, transectionTime, departureTime, teller;
	String customerName;
	
	public customer(int Teller, String Name, int Arr, int Tran) {
		customerName = Name;
		arrivalTime = Arr;
		transectionTime = Tran;
		departureTime = Arr + Tran;
		teller = Teller;
		
	}
	
	public String getName() {
		return customerName;
	}
	
	public int getArrival() {
		return arrivalTime;
	}
	
	public int getTransection() {
		return transectionTime;
	}
	
	public int getDeparture() {
		return departureTime;
	}
	
	public int getTeller() {
		return teller;
	}
}
