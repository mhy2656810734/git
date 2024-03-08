/**
 * @author mahaiyang
 * @date 2024/3/8 15:45
 */
public class PrintABC {
    private static int state = 0; // 共享变量，用于控制线程执行顺序

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (PrintABC.class) {
                    while (state % 3 != 0) { // 判断共享变量的值是否等于当前线程对应的字符
                        try {
                            PrintABC.class.wait(); // 如果不是，则让当前线程等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A"); // 打印当前线程对应的字符
                    state++; // 将共享变量的值加1
                    PrintABC.class.notifyAll(); // 唤醒其他线程
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (PrintABC.class) {
                    while (state % 3 != 1) {
                        try {
                            PrintABC.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    state++;
                    PrintABC.class.notifyAll();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                synchronized (PrintABC.class) {
                    while (state % 3 != 2) {
                        try {
                            PrintABC.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    state++;
                    PrintABC.class.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
    }
}
