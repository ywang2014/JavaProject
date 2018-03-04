package com.multithread;

/**
 * 生成者消费者模型
 * 
 * @author yong.wang
 *
 */
public class ProducerAndConsumer {
	private final static int MAX_PRODUCT_NUM = 10;
	private final static int MIN_PRODUCT_NUM = 1;
	private Double[] products = new Double[MAX_PRODUCT_NUM];
	private int productNum = 0;
	
	private static final ProducerAndConsumer manager = new ProducerAndConsumer();
	
	private ProducerAndConsumer(){
		// default constructor
	}
	
	public static ProducerAndConsumer getInstance() {
		return manager;
	}
	
	public synchronized void produce() {
		System.out.println("The product number is " + this.productNum);
		if (this.productNum >= MAX_PRODUCT_NUM) {
			System.out.println("The product is so much, the wait for consumers");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Produce a new product");
			this.products[this.productNum++] = Math.random() * 10000;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notifyAll();	// 通知等待区的消费者，有新产品可以消费了
		}
	}
	
	public synchronized void consume() {
		System.out.println("The product number is " + this.productNum);
		if (this.productNum < MIN_PRODUCT_NUM) {
			System.out.println("There is no products, please wait producers");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Consume a product");
			this.productNum--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notifyAll();	// 通知等待区的生产者，有空区域，可以放产品了。
		}
	}
	
	private class Task implements Runnable {
		@Override
		public void run() {
			if (Math.random() < 0.5) {
				manager.produce();
			} else {
				manager.consume();
			}
		}
	}
	
	public void schedule() {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Task()).start();
		}
	}
	
	public static void main(String[] args) {
		ProducerAndConsumer manager = ProducerAndConsumer.getInstance();
		manager.schedule();
	}
}
