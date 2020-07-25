package july25th.copy3;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		MyConnectionPool obj = new MyConnectionPool(4);

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						obj.qqSize();
						Connection_Producer_Impl connObj = obj.checkout();
						connObj.execute("executing my sample task.....");
						System.out.println("conn id : "+connObj.getConnObjID());
						obj.qqSize();
						obj.addToBQ(connObj);
						Thread.sleep(3000);
					} catch (InterruptedException e) { e.printStackTrace();}
				}
			}
		};

		new Thread(runnable).start();
	}
}
