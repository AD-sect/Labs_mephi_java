package ru.mephi.hw2;
import java.util.*;

public class ParseToken {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Write the string of tokens: ");
        String string = in.nextLine(); //get the string for finding words
        in.close();


        String[] token = string.split(" ");//take the words for counting
        Map<String, Integer> tokens = new TreeMap<>() {//define the map for setting the amount of entry
            @Override
            public String toString() {//override the output as in the task
                String str = "";
                for (Map.Entry<String, Integer>
                        entry : entrySet())
                    str += entry.getKey() +
                            ":" + entry.getValue() +
                            " ";
                return str;
            }
        };

        for (int i = 0; i < token.length; i++) {
            if (tokens.containsKey(token[i]) == true) {
                tokens.put(token[i], (int) tokens.get(token[i]) + 1); // if word exist in map, change the value
            } else {
                tokens.put(token[i], 1);//if word not exist, add to tne map
            }
        }


        Set<String> uniqueTokens = new LinkedHashSet<>() {//define th set for deleting duplicates
            @Override
            public String toString() {//override the output for the task
                String str = "";
                for (String token : this) {
                    str += token + " ";
                }
                return str;
            }
        };
        for (String str : token) {//add elements to set
            uniqueTokens.add(str);
        }

        System.out.println("Answer for amount of entry:");
        System.out.println(tokens);
        System.out.println("Unique words in natural sequence:");
        System.out.println(uniqueTokens);

    }

}
