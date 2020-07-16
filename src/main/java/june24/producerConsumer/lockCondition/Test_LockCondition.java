package june24.producerConsumer.lockCondition;

import java.util.concurrent.atomic.AtomicInteger;

public class Test_LockCondition {
	public static void main(String[] args) {
		MyBlockingQueue_LockCondition<Integer> qq = new MyBlockingQueue_LockCondition<Integer>(10);
		AtomicInteger atomicInteger = new AtomicInteger(0);
		
		final Runnable producer = () -> {
			while(true) {
				try {
					Thread.sleep(3000);
					int i = atomicInteger.incrementAndGet();
					System.out.println("producer : "+i);
					qq.put(i);
					System.out.println(qq.qq);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		};
		new Thread(producer).start();
		//new Thread(producer).start();
		
		final Runnable consumer = () -> {
			while(true) {
				Integer val;
				try {
					Thread.sleep(5000);
					val = qq.take();
					System.out.println("consumer : "+val);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		};
		new Thread(consumer).start();
		//new Thread(consumer).start();
	}
}
