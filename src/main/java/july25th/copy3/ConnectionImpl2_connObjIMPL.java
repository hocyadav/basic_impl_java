package july25th.copy3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ConnectionImpl2_connObjIMPL extends Connection_Producer_Impl implements Connection_Consumer {
	//int connId;//type int is conn obj that is inside BQ
	
	//ProducerIMPL connection1Producer;
	Connection_Consumer connectionImpl2Consumer;

	int connectionPoolSize = 4;//default pool size
	BlockingQueue<Connection_Producer_Impl> qq = null; 

	ReentrantLock lock = new ReentrantLock(true);
	Condition cond1 = lock.newCondition();
	Condition cond2 = lock.newCondition();

	//create pool : add 10 object and create pool
	public ConnectionImpl2_connObjIMPL(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
		this.qq = new ArrayBlockingQueue<Connection_Producer_Impl>(connectionPoolSize);

		//this.connection1Producer = this;//since this is class is implementation of these interface
		this.connectionImpl2Consumer = this;
		
		for(int i = 0; i < this.connectionPoolSize; i++) {
			Connection_Producer_Impl producerIMPL = new Connection_Producer_Impl();
			producerIMPL.setConnObjID(i);
			qq.add(producerIMPL);
		}
		System.out.println("Pool/BQ size : "+qq.size());
	}

	//checkout() - consumer : get 1 connection obj from pool
	public Connection_Producer_Impl getFromBQ() {
		lock.lock();
		Connection_Producer_Impl connObj = null;
		try {
			while(qq.size() == 0) {
				cond1.await();
			}
			connObj = qq.take();
			cond2.signalAll();
			System.out.println("consuming/return connObj : "+connObj.getConnObjID());
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return connObj;
	}

	//close() - producer : add connection back to pool
	public void addToBQ(Connection_Producer_Impl connObj) {
		lock.lock();
		System.out.println("adding back to BQ conn obj : "+connObj.getConnObjID());
		try {
			while(qq.size() == this.connectionPoolSize) {
				cond2.await();
			}
			qq.add(connObj);
			cond1.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void printBQ() throws InterruptedException {
		System.out.print("BQ conn OBJ : ");
		BlockingQueue<Connection_Producer_Impl> temp = new ArrayBlockingQueue<Connection_Producer_Impl>(this.connectionPoolSize, true, this.qq);
		for(int i = 0; i < temp.size(); i++) {
			Connection_Producer_Impl take = temp.take();
			System.out.print(take.getConnObjID()+" ");
		}
		System.out.println();
	}
	
	public void qqSize() {
		System.out.println("BQ/Pool size : "+qq.size());
	}
	
}
