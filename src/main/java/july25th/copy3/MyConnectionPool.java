package july25th.copy3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class MyConnectionPool extends ConnProducerImpl implements ConnConsumer {
	//Connection_Consumer connectionImpl2Consumer;

	int connectionPoolSize = 4;//default pool size
	BlockingQueue<ConnProducerImpl> qq = null; 

	ReentrantLock lock = new ReentrantLock(true);
	Condition cond1 = lock.newCondition();
	Condition cond2 = lock.newCondition();

	//create pool : add 10 object and create pool
	public MyConnectionPool(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
		this.qq = new ArrayBlockingQueue<ConnProducerImpl>(connectionPoolSize);

		//this.connection1Producer = this;//since this is class is implementation of these interface
		//this.connectionImpl2Consumer = this;
		
		for(int i = 0; i < this.connectionPoolSize; i++) {
			ConnProducerImpl producerIMPL = new ConnProducerImpl();
			producerIMPL.setConnObjID(i);
			qq.add(producerIMPL);
		}
		System.out.println("Pool/BQ size : "+qq.size());
	}

	//checkout() - consumer : get 1 connection obj from pool
	public ConnProducerImpl checkout() {
		lock.lock();
		ConnProducerImpl connObj = null;
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
	public void close(ConnProducerImpl connObj) {
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
		BlockingQueue<ConnProducerImpl> temp = new ArrayBlockingQueue<ConnProducerImpl>(this.connectionPoolSize, true, this.qq);
		for(int i = 0; i < temp.size(); i++) {
			ConnProducerImpl take = temp.take();
			System.out.print(take.getConnObjID()+" ");
		}
		System.out.println();
	}
	
	public void qqSize() {
		System.out.println("BQ/Pool size : "+qq.size());
	}
	
}
