package june24.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumeer {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> qq = new ArrayBlockingQueue<>(10);
		AtomicInteger atomicInteger = new AtomicInteger(0);
		
		final Runnable producer = () -> {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int val = atomicInteger.incrementAndGet();
				System.out.println("producer : "+val);
				qq.add(val);
			}
		};
		
		new Thread(producer).start();
		new Thread(producer).start();
		
		
		final Runnable consumer = () -> {
			while(true) {
				Integer t;
				try {
					t = qq.take();
					System.out.println("consumer : "+t);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();
		
		Thread.sleep(2000);
		
	}
}
