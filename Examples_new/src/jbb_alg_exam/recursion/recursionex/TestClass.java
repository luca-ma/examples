package jbb_alg_exam.recursion.recursionex;

public class TestClass {
    private static Integer getIt(Integer var) {
        return var < 5 ? getIt(var - 1) : var + 1;
    }

    public static void main(String[] args) {
        System.out.println(getIt(3));
    }
}
