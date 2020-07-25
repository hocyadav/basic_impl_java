package july25th.copy3;

public interface Connection_Consumer {
	
	//getFromBQ() / checkout() - consumer : get 1 connection obj from pool
	public Connection_Producer checkout();
}
