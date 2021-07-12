class arrayPro {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 1;
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a.length);

        int[] b = new int[26];
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }   
    }
}