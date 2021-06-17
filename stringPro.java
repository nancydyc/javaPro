class stringPro {
    public static void main(String[] args) {
        String str1 = "abcd";
        StringBuilder str = new StringBuilder(str1);
        str.append("ef");
        System.out.println(str); // abcdef

        char[] chArray = new char[str1.length()];
        str.getChars(0, str1.length(), chArray, 0);

        for (char ch : chArray) {
            System.out.print(ch + " "); //a b c d
        }
        
    }
}