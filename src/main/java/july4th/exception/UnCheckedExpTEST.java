package july4th.exception;

/** https://www.youtube.com/watch?v=wj3UmzeyrvE&t=296s **/
public class UnCheckedExpTEST{
	public static void main(String[] args) {
		AmountAdder adder = new AmountAdder();
		Amount a1 = new Amount("INR", 100);
		//Amount a2 = new Amount("INR", 200);
		Amount a2 = new Amount("USD", 200);
		Amount m = adder.addAmount(a1, a2);
		System.out.println(m);
	}

}
