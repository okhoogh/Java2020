package day22_Lambda_FunctionReference.T04_exp3;

public class AddableDemo {
    public static void main(String[] args) {
        useAddable((int x, int y) -> {
            return x + y;
        });
    }

    private static void useAddable(Addable a) {
        int sum = a.add(10, 20);
        System.out.println(sum);
    }
}
