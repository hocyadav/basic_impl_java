package july25th;

public interface Connection1Producer {
	public void execute(String taskToExecute);
	
	//close() - producer : add connection back to pool
	public void addToBQ(Integer connObj);
	
}
