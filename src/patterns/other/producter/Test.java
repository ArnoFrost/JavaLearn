package patterns.other.producter;

import java.util.PriorityQueue;

public class Test {
	
	public static void main(String[] args) {
		Test t = new Test();
		Producer p = t.new Producer();
		Consumer c = t.new Consumer();
		p.start();
		c.start();
	}
	
	private int queueSize = 10;
	private final PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	
	//对于生产者来说，一旦队列填满了，就需要等待，即wait(),一旦消费者消费了，队列存在容量了，则生产者线程被notify()，就继续生产
	class Producer extends Thread{
		
		@Override
		public void run() {
			produce();
		}
		
		public void produce(){
			while(true){
				synchronized (queue) {
					while(queue.size() == queueSize){
						System.out.println("队列满了，需要等待");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					queue.offer(1);
					queue.notify();  	//生产者生产出了数据就通知消费者线程取出数据
					System.out.println("生产者向队列中添加了一个元素，队列的剩余空间是:" + (10 - queue.size()));
				}
			}
		}
	}
	
	//对于消费者来说，如果队列为空，则需要等待，否则，从队列中取出一条数据
	class Consumer extends Thread{
		
		@Override
		public void run() {
			consume();
		}
		
		public void consume(){
			while(true){
				synchronized (queue) {
					while(queue.size() == 0){
						System.out.println("队列为空，请等一会儿再消费");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					queue.poll();
					//消费者取出数据后，就需要唤醒生产者线程，可以进行数据放入了
					queue.notify();
					System.out.println("消费者从队列中取出一个元素，队列中剩余的元素个数是:" + (queue.size()));
				}
			}
		}
		
	}
	
}	