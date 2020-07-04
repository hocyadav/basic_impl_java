package july4th.factory;

public class FactoryExample {
	public static void main(String[] args) {
		Vehicle obj1 = VehicleFactory.getInstance("car", 4);
		System.out.println(obj1);
		
		Vehicle obj2 = VehicleFactory.getInstance("bike", 2);
		System.out.println(obj2);
		
		Vehicle obj3 = VehicleFactory.getInstance("askjhdakjsd", 2);
		System.out.println(obj3);
		
		
		
	}
}
