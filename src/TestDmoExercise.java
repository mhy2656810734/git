import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestDmoExercise {
    public static  int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Integer a = 20;
        Integer b = 20;
        System.out.println( a == b);
        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);
        System.out.println(LocalDate.now().lengthOfYear());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,
                20,20,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        /**
         *
         */
//        method(null);
//        func();
//        test();
//        testSwitch();
        testThread();
    }

    /**
     * 练习三个线程顺序打印ABC
     */
    private static void testThread() throws InterruptedException {

        Thread threadA = new Thread(() -> {
            synchronized (TestDmoExercise.class) {
                // 判断是不是由当前线程打印字符
                while (count % 3 != 0) {
                   // 不由当前线程打印，阻塞等待
                    try {
                        TestDmoExercise.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印对应字符
                System.out.println('A');
                // 共享变量+1
                count++;
                // 唤醒其他线程
                TestDmoExercise.class.notifyAll();
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (TestDmoExercise.class) {
                // 判断是不是由当前线程打印字符
                while (count % 3 != 1) {
                    // 不由当前线程打印，阻塞等待
                    try {
                        TestDmoExercise.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印对应字符
                System.out.println('B');
                // 共享变量+1
                count++;
                // 唤醒其他线程
                TestDmoExercise.class.notifyAll();
            }
        });
        Thread threadC = new Thread(() -> {
            synchronized (TestDmoExercise.class) {
                // 判断是不是由当前线程打印字符
                while (count % 3 != 2) {
                    // 不由当前线程打印，阻塞等待
                    try {
                        TestDmoExercise.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印对应字符
                System.out.println('C');
                // 共享变量+1
                count++;
                // 唤醒其他线程
                TestDmoExercise.class.notifyAll();
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
    }

    private static int func() {
        Integer a = null;
        return a;
    }

    /**
     *
     * @param param 传入的字符串
     */
    public static void method(String param) {
        switch (param) {
         // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
         // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
         // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
    public static void test() {
        Character a = 126, b = 126, c = 128, d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }
    public static  void testSwitch() {
        String param = null;
        switch (param = "null") {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        for (Integer integer:list) {
            list.remove(integer);
        }
    }

}
