package july1st;

public class TestCustomPair_Generic {
	public static void main(String[] args) {
		CustomPair_Generic<Integer, String> pr = new CustomPair_Generic<Integer, String>();
		pr.setKey(1);
		pr.setVal("hariom");
		System.out.println(pr);
		System.out.println("key :"+pr.getKey());
		System.out.println("val :"+pr.getVal());
	}
}
