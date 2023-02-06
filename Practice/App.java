public class App {
	
	private String name;
	private String gender;
	private double weight;
	private int numOfJowa;

	public static void main (String[] args) {
		
		App x = new App();
		App y = new App();
		App z = new App();
		
		x.name= "Alex";
		x.gender = "Male";
		x.weight = 66.8;
		x.numOfJowa = 2;
		
		y.name= "David";
		y.gender = "Male";
		y.weight = 78;
		y.numOfJowa = 8;
		
		z.name= "Robbie";
		z.gender = "Male";
		z.weight = 60;
		z.numOfJowa = 0;
		
		System.out.println(x.name + "\n" + x.gender + "\n" + x.weight + "\n" + x.numOfJowa);
		System.out.println(y.name + "\n" + y.gender + "\n" + y.weight + "\n" + y.numOfJowa);
		System.out.println(z.name + "\n" + z.gender + "\n" + z.weight + "\n" + z.numOfJowa);
	}

	public App() {
		super();
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.numOfJowa = numOfJowa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getNumOfJowa() {
		return numOfJowa;
	}

	public void setNumOfJowa(int numOfJowa) {
		this.numOfJowa = numOfJowa;
	}
} 
