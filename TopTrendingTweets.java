import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class TopTrendingTweets {
    public static HashMap<String,Integer> words = new HashMap<>();
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        String tweet = scanner.nextLine();
        String[] wordsSplit = tweet.split(" ");
        for(String w : wordsSplit){
            if(w.charAt(0)=='#'){
                //time complexity of insertion is O(length of longest word) => O(1) #constant
                insertWord(w.substring(1));
            }
        }
        //time complexity of printing is O(N * log(n) * length of longest word) => O(N * log(n))
        printTopHashtags(10);
    }
    public static void printTopHashtags(int k) {
        ArrayList<String> wordsList = new ArrayList(words.keySet());
        Collections.sort(wordsList, (a,b)->words.get(b)-words.get(a));
        if(k<=wordsList.size()){
            for(int i=0;i<k;i++)
                System.out.println(wordsList.get(i));
        }
        else{
            for(String hashTag:wordsList)
                System.out.println(hashTag);
        }
    }
    public static void insertWord(String word) {
        if(!words.containsKey(word))
            words.put(word,0);
        words.put(word,words.get(word)+1);
    }
}

