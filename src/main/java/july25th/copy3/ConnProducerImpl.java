package july25th.copy3;

public class Connection_Producer_Impl implements Connection_Producer{
	int connObjID;

	//execute() - task operation
	public void execute(String taskToExecute) {
		System.out.println(taskToExecute);
	}

	@Override
	public void addToBQ(Connection_Producer_Impl connObj) {

	}

	public int getConnObjID() {
		return connObjID;
	}

	public void setConnObjID(int connObjID) {
		this.connObjID = connObjID;
	}
}
