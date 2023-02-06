public class App {
	
	String name;
	String gender;
	double weight;
	int numOfJowa;

	public App(String n, String g, double w, int noj) {
		name = n;
		gender = g;
		weight = w;
		numOfJowa = noj;
		System.out.println("Name: " + n + "\nGender: " + g + "\nWeight: " + w + "\nNumber of Jowa: " + noj + "\n");
	}
	
	public static void main (String[] args) {
		new App("Alex", "Male", 66.8, 2);
		new App("David", "Male", 78, 8);
		new App("Robbie", "Male", 60, 0);
	}
} 
