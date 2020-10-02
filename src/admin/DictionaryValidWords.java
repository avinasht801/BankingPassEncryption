package admin;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public final class DictionaryValidWords {

    private static final Set<String> dictionary = new TreeSet<String>();
    static {
        dictionary.add("this");
        dictionary.add("his");
        dictionary.add("is");
        dictionary.add("awe");
        dictionary.add("we");
        dictionary.add("some");
        dictionary.add("awesome");
        dictionary.add("foo");
        dictionary.add("bar");
    }

    public static void main (String args[]){
    	Set<String> words = findValidStrings("shailesh");
    	System.out.println(words);
    }

    /**
     * Returns set of valid words given an input string.
     * It eliminates duplicates.
     * 
     * @param str   The input string whose valid words need to be found out.
     * @return      List of valid words nested in the string.
     */
    public static Set<String> findValidStrings(String str) {
        final Set<String> validWords = new HashSet<String>(); 
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                sb.append(str.charAt(j)); // O(1) complexity.
                if (dictionary.contains(sb.toString())) {
                    validWords.add(sb.toString());
                }
            }
        }
        return validWords;
    }
}
