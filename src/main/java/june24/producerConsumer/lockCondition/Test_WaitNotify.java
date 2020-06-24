package june24.producerConsumer.lockCondition;

import java.util.concurrent.atomic.AtomicInteger;

public class Test_WaitNotify {
	public static void main(String[] args) {
		MyBlockingQueue_WaitNotify<Integer> qq = new MyBlockingQueue_WaitNotify<Integer>(10);
		AtomicInteger atomicInteger = new AtomicInteger(0);
		
		final Runnable producer = () -> {
			while(true) {
				try {
					int i = atomicInteger.incrementAndGet();
					System.out.println("producer : "+i);
					qq.put(i);
					Thread.sleep(2000);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		};
		
		new Thread(producer).start();
		new Thread(producer).start();
		
		final Runnable consumer = () -> {
			while(true) {
				Integer val;
				try {
					val = qq.take();
					Thread.sleep(2000);
					System.out.println("consumer : "+val);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();

		
	}
}
