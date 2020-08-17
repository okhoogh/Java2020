package day22_Lambda_FunctionReference.T01_LearnLambda;

public class LambdaDemo {
    public static void main(String[] args) {
        // 通过实现类的方式来创建线程
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        // 通过匿名内部类来创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程启动了");
            }
        }).start();

        // 通过Lambda表达式来创建线程
        new Thread(() -> System.out.println("多线程启动了")).start();
    }
}
