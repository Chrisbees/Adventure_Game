package com.chrisbees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Integer, Location> location = new HashMap<>();
    public static void main(String[] args) {
        location.put(0, new Location(0, "You're sitting in front of a computer learning Java"));
        location.put(1, new Location(1, "You're standing at the end of a road before a small brick building"));
        location.put(2, new Location(2, "You're at the top of a hill"));
        location.put(3, new Location(3, "You're inside a building, a well house for a small spring"));
        location.put(4, new Location(4, "You're in a valley beside a stream"));
        location.put(5, new Location(5, "You're in the forest"));

        location.get(1).addExits("N", 5);
        location.get(1).addExits("W", 2);
        location.get(1).addExits("S", 4);
        location.get(1).addExits("E", 3);
        location.get(1).addExits("Q", 0);

        location.get(2).addExits("N", 5);
        location.get(3).addExits("W", 1);
        location.get(4).addExits("W", 2);
        location.get(4).addExits("E", 3);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");

        int loc = 1;
        while (true) {
            System.out.println(location.get(loc).getDescriptions());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = location.get(loc).getExits();
            System.out.println("Please enter a location");
            for (String exit: exits.keySet()
                 ) {
                System.out.println(exit + ", ");
            }
            System.out.println();
            String direction = new Scanner(System.in).nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word: words
                     ) {
                    if (vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }

                }
            }
            if (exits.containsKey(direction)) {
                    loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
//            loc = new Scanner(System.in).nextInt();
//            if (!location.containsKey(loc)){
//                System.out.println("You cannot go in this direction");
//            }
        }
    }
}
