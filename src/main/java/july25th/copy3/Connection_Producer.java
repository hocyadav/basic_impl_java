package july25th.copy3;

public interface Connection1Producer {
	public void execute(String taskToExecute);
	
	//close() - producer : add connection back to pool
	public void addToBQ(ProducerIMPL connObj);
	
}
