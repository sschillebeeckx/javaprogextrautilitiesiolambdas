package be.abis.palindrome.test;

import be.abis.palindrome.exception.NotAPalindromeException;
import be.abis.palindrome.model.Palindrome;
import be.abis.palindrome.model.PalindromePhrase;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestPalPhrase {

    public static void main(String[] args) {
        String[] palWords = {"kok", "pap", "lepel", "droomoord", "legerregel","", "level", null, "negen", "error", "lol",
                "meetsysteem", "legovogel", "parterretrap", "tarwewrat", "kaak", "racecar", "a"};
        String[] palSentences ={"lezen is in ezel", null, "This is a sentence", "Never odd or even","A Toyota's a Toyota", "x", "Was it a car or a cat I saw?","null"};

       Set<Palindrome> palindromes = new HashSet<>();

       for (String palStr : palWords) {
           palindromes.add(new Palindrome(palStr));
        }
        for (String palStr : palSentences) {
            palindromes.add(new PalindromePhrase(palStr));
        }

        Set<Palindrome> correctPalindromes = new TreeSet<>();

        for (Palindrome p : palindromes){
            if (p!=null) {
                try {
                    if (p.isPalindrome()) {
                        correctPalindromes.add(p);
                    }
                } catch (NotAPalindromeException e) {
                    System.out.println(p.getValue() + e.getMessage());
                }
            }
        }

        System.out.println("\nNumber of correct palindromes: " + Palindrome.countNumberOfPalindromes(palindromes));
        for (Palindrome p : correctPalindromes){
            System.out.println(p);
        }


    }
}

