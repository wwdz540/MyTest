package cn.zhipingok.test.concurrent;

public class ProducerAndConsumer {

    private final Object LOCK = new Object();

    private volatile int souce = 1;

    public void product() {

        synchronized (LOCK) {
            while (souce==3){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            souce++;
            LOCK.notify();
            System.out.println("生产消息" + souce);
        }

    }

    public void consume() {

        synchronized (LOCK) {
            while (souce==0){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费消息==" + souce);
            souce--;
            LOCK.notify();

        }

    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while(true)
            ProducerAndConsumer.this.product();
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true)
            ProducerAndConsumer.this.consume();
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        new Thread(producerAndConsumer.new Consumer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();

        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Producer()).start();
    }
}
