package july25th.copy3;

public class ConnProducerImpl implements ConnProducer{
	int connObjID;

	//execute() - task operation
	public void execute(String taskToExecute) {
		System.out.println(taskToExecute);
	}

	@Override
	public void close(ConnProducerImpl connObj) {

	}

	public int getConnObjID() {
		return connObjID;
	}

	public void setConnObjID(int connObjID) {
		this.connObjID = connObjID;
	}
}
