package day22_Lambda_FunctionReference.T05_LambdaOmissionmode;

public class LambdaDemo {
    public static void main(String[] args) {
        // 普通模式
        useAddable((int x, int y) -> {
            return x + y;
        });

        // 省略参数类型(不能只能省略一个)
        useAddable((x, y) -> {
            return x + y;
        });

        // 普通模式
        useFlyable((String s) -> {
            System.out.println(s);
        });

        // 如果只有一个参数，可以省略参数括号
        useFlyable(s -> {
            System.out.println(s);
        });

        // 如果代码块语句只有一行，可以省略花括号和语句逗号
        useFlyable(s -> System.out.println(s));

        // 如果有return,也要把return省略掉
        useAddable((x, y) -> x + y);
    }

    private static void useFlyable(Flyable f) {
        f.fly("起飞~");
    }

    private static void useAddable(Addable a) {
        int sum = a.add(10, 20);
        System.out.println(sum);
    }
}
