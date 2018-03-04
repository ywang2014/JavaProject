package com.multithread;

/**
 * ������������ģ��
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
			notifyAll();	// ֪ͨ�ȴ����������ߣ����²�Ʒ����������
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
			notifyAll();	// ֪ͨ�ȴ����������ߣ��п����򣬿��ԷŲ�Ʒ�ˡ�
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
