import java.io.*;
import java.util.Scanner;

public class SlugFest {
	public static void main(String[] args) throws IOException {
		Queue line1 = new Queue();
		Queue line2 = new Queue();
		Queue line3 = new Queue();
		Queue line4 = new Queue();
		Queue line5 = new Queue();
		int time = 0;
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		customer data;
		while (in.hasNextLine()) {
			String line = in.nextLine().trim() + " ";
			String[] token = line.split("\\s+");
			data = new customer(Integer.parseInt(token[0]), token[1], Integer.parseInt(token[2]),Integer.parseInt(token[3]));
						if (data.teller == 1) {
							line1.enqueue(data);
						}
						if (data.teller == 2) {
							line2.enqueue(data);
						}
						if (data.teller == 3) {
							line3.enqueue(data);
						}
						if (data.teller == 4) {
							line4.enqueue(data);
						}
						if (data.teller == 5) {
							line5.enqueue(data);
						}
		}
						while(!line1.isEmpty() && !line2.isEmpty() && !line3.isEmpty() && !line4.isEmpty() && !line5.isEmpty()) {
							customer c1 = (customer) line1.peek();
							customer c2 = (customer) line2.peek();
							customer c3 = (customer) line3.peek();
							customer c4 = (customer) line4.peek();
							customer c5 = (customer) line5.peek();
							if(time == c1.arrivalTime || time > c1.arrivalTime) {
								System.out.println(c1.teller + c1.customerName + " begins " + c1.arrivalTime);
								out.println(c1.teller + c1.customerName + " begins " + c1.arrivalTime);
								line1.dequeue();
								if(time == c1.departureTime) {
									out.println(c1.teller + c1.customerName + " begins " + c1.departureTime);
									
								}
						}
							if(time == c2.arrivalTime || time > c2.arrivalTime) {
								System.out.println(c2.teller + c2.customerName + " begins " + c2.arrivalTime);
								out.println(c2.teller + c2.customerName + " begins " + c2.arrivalTime);
								line2.dequeue();
								if(time == c2.departureTime) {
									out.println(c2.teller + c2.customerName + " begins " + c2.departureTime);
									
								}
						}
							if(time == c3.arrivalTime || time > c3.arrivalTime) {
								System.out.println(c3.teller + c3.customerName + " begins " + c3.arrivalTime);
								out.println(c3.teller + c3.customerName + " begins " + c3.arrivalTime);
								line3.dequeue();
								if(time == c1.departureTime) {
									out.println(c3.teller + c3.customerName + " begins " + c3.departureTime);
									
								}
						}
							if(time == c4.arrivalTime || time > c4.arrivalTime) {
								System.out.println(c4.teller + c4.customerName + " begins " + c4.arrivalTime);
								out.println(c4.teller + c4.customerName + " begins " + c4.arrivalTime);
								line4.dequeue();
								if(time == c4.departureTime) {
									out.println(c4.teller + c4.customerName + " begins " + c4.departureTime);
									
								}
						}
							if(time == c5.arrivalTime || time > c5.arrivalTime) {
								System.out.println(c5.teller + c5.customerName + " begins " + c5.arrivalTime);
								out.println(c5.teller + c5.customerName + " begins " + c5.arrivalTime);
								line5.dequeue();
								if(time == c5.departureTime) {
									out.println(c5.teller + c5.customerName + " begins " + c5.departureTime);
									
								}
						}
							time++;
					}
		in.close();
		out.close();
	}
}
