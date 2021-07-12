public class numberPro {
    // public static int mySqrt(int x) {
    public int mySqrt(int x) {
        // double a = Double.valueOf(x);
        // double b = 0.5;
        double res = Math.pow(x, 0.5);
        return (int) res;
    }
    public static void main(String[] args) {
        // int test1 = mySqrt(8); // if it's a static method, we don't need a new object
        numberPro test = new numberPro();
        int test1 = test.mySqrt(8);
        System.out.println(test1);
    }
}