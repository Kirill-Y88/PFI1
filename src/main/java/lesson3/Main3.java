package lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main3 {
    static String word = "";
    static int count=0;
    public static void main(String[] args) throws InterruptedException {

       final Lock lock = new ReentrantLock();

        Thread ping = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                try {
                    while (word.equals("ping")){
                        Thread.sleep(100);
                    }
                    lock.lock();
                    System.out.println("ping");
                    Thread.sleep(1000);
                } catch (Exception e ) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    word="ping";
                    count++;
                }

            }
        });

        Thread pong = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                try {
                    while (word.equals("pong")){
                        Thread.sleep(100);
                    }
                    lock.lock();
                    System.out.println("pong");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    word="pong";
                    count++;
                }
            }
        });

    ping.start();
    pong.start();

    ping.join();
    pong.join();

    System.out.println("count = " + count);
    }
}
