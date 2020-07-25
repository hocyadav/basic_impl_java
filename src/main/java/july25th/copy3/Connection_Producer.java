package july25th.copy3;

public interface Connection_Producer {
	public void execute(String taskToExecute);
	
	//close() - producer : add connection back to pool
	public void addToBQ(Connection_Producer_Impl connObj);
	
}
