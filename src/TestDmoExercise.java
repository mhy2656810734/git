import java.time.LocalDate;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestDmoExercise {
    public static void main(String[] args) {
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
        test();
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
}
