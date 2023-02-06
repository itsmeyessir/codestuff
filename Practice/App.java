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
		System.out.println("Name: " + n + "\nGender: " + g + "\nWeight: " + w + "\nNumber of Jowa: " + noj);
	}
	
	public static void main (String[] args) {
		App x = new App("Alex", "Male", 66.8, 2);
		App y = new App("David", "Male", 78, 8);
		App z = new App("Robbie", "Male", 60, 0);
	}
} 
