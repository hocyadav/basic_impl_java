package july25th.copy3;

public interface Connection_Consumer {
	
	//checkout() - consumer : get 1 connection obj from pool
	public Connection_Producer getFromBQ();
}
