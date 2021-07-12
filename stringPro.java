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

        String str2 = "zxv";
        int res = str1.compareTo(str2);
        System.out.println("\n" + res); // 025

        String str3 = "offer";
        String target = str3.substring(1, 2);
        System.out.println(target); // f

        String str4 = "sdf";
        char[] chars = str4.toCharArray();
        System.out.println(chars[2]); // f
        String str44 = str4 + ' ' + ' ' + 'a';
        System.out.println(str44); // sdf  a
        System.out.println(str4.substring(0, str4.length() - 1)); // sd
        System.out.println(str44.replaceAll("\\s+", " ")); // same as "\\s{2,}" // sdf a
        
        String str5 = "  qer ";
        
        int left = 0, right = str5.length() - 1;
        while (left <= right && str5.charAt(left) == ' ') {
            ++left;
            // System.out.println(str5.charAt(left));
        }
        System.out.println(str5.charAt(left));
        while (left <= right && str5.charAt(right) == ' ') {
            // System.out.println(right);
            --right;
            // System.out.println(right);
        }
        System.out.println(str5.charAt(right));
        System.out.println(str5.substring(left, right)); // right is exclusive
        System.out.println(str5.substring(left, right).length());
        System.out.println(str5);
        str5 = str5.trim();
        System.out.println(str5);

        Character m = 'm';
        int mm = m;
        System.out.println(mm); // 109 ASCII value
        Character n = 'z';
        System.out.println(Character.getNumericValue(n)); // a:10, m:22, z: 35

        char o = '2';
        int oo = Integer.parseInt(String.valueOf(o)); // cannot convert alphabetical letters to int
        System.out.println(oo);
    }
}