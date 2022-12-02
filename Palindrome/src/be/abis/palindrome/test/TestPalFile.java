package be.abis.palindrome.test;

import be.abis.palindrome.exception.NotAPalindromeException;
import be.abis.palindrome.model.Palindrome;
import be.abis.palindrome.model.PalindromePhrase;
import be.abis.palindrome.utility.PercentageChecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class TestPalFile {

    public static void main(String[] args) {

        ArrayList<Palindrome> palArrList = new ArrayList<>();

        try (FileReader fr = new FileReader("Palindrome/src/palindromes.txt");
             BufferedReader br = new BufferedReader(fr);
             PrintWriter pw = new PrintWriter("Palindrome/src/palindromessorted.txt")){
            String line=null;
            while((line=br.readLine())!=null){
                String trimmed = line.trim();
                Palindrome p=null;
                if(!trimmed.equals("") && !trimmed.equals("null")){
                    if (trimmed.indexOf(" ")>0){
                        p=new PalindromePhrase(trimmed);
                    } else {
                        p=new Palindrome(trimmed);
                    }
                    if (!palArrList.contains(p)) palArrList.add(p);
                }

            }

        int nrCorrectPalindromes = 0;
            int originalNrOfValues = palArrList.size();

        Iterator<Palindrome> palIter = palArrList.iterator();

        while (palIter.hasNext()){
            Palindrome p = palIter.next();
            try {
                p.isPalindrome();
                nrCorrectPalindromes++;
            } catch (NotAPalindromeException npe) {
                palIter.remove();
                System.out.println(p + npe.getMessage());
            }
        }


        palArrList.sort((p1,p2)->p1.getValue().compareToIgnoreCase(p2.getValue()));
        for(Palindrome p : palArrList) {pw.println(p);}

        // System.out.println("percentage ok: " + nrCorrectPalindromes*100.0/originalNrOfValues);
        PercentageChecker pc = (correct, percentage) -> correct*100.0/originalNrOfValues>percentage;
        System.out.println("more than 50% palindromes? " +pc.testPercentage(nrCorrectPalindromes,50));
        System.out.println("more than 80% palindromes? " +pc.testPercentage(nrCorrectPalindromes,80));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

