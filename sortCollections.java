import java.util.ArrayList;
// import java.util.*; // this can run the script but add method shows red warning
import java.util.Collections;

class SortCollections {
    class Pair {
        String str;
        int time;
    
        public Pair(String word, int count) {
            str = word;
            time = count;
        }
    }
    public static void main(String[] args) {
        ArrayList<Pair> topWord = new ArrayList<>();
        SortCollections p = new SortCollections();
        topWord.add(p.new Pair("love", 3));
        topWord.add(p.new Pair("justice", 3));
        topWord.add(p.new Pair("true", 4));
        // ArrayList<String> topWord = new ArrayList<>();
        // topWord.add("justice");
        // topWord.add("truth");
        for (int i = 0; i < topWord.size(); i++) {
            System.out.println(topWord.get(i).str + " " + topWord.get(i).time);
        }
        
        Collections.sort(topWord, (p1, p2) -> { // lambda expr
            if (p1 != p2) return (p2.time - p1.time);
            else {
                return p1.str.compareTo(p2.str);
            }
        });
        for (int i = 0; i < topWord.size(); i++) {
            System.out.println(topWord.get(i).str + " " + topWord.get(i).time);
        }
    }
}