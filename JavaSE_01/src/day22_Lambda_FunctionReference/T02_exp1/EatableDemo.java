package day22_Lambda_FunctionReference.T02_exp1;

public class EatableDemo {

    public static void main(String[] args) {
        // 通过实现类的方式来创建线程
        Eatableimpl e = new Eatableimpl();
        useEatable(e);

        // 通过匿名内部类来创建线程
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("Hello World");
            }
        });

        useEatable(() -> System.out.println("Hello World"));
    }

    private static void useEatable(Eatable e) {
        e.eat();
    }
}
