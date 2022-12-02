package be.abis.palindrome.model;

public class PalindromePhrase extends Palindrome {

    public PalindromePhrase(String value) {
        super(value);
    }

    public boolean isPalindrome() {
        boolean retval=false;

        String palValue=this.getValue();

        if (palValue != null ) {
            palValue=palValue.replaceAll("\\W","").toLowerCase();
            if (!palValue.equals("") && palValue.length()!=1) {
                StringBuilder sb = new StringBuilder(palValue);
                StringBuilder sbrev = new StringBuilder(palValue).reverse();
                retval=sb.toString().equals(sbrev.toString());
            }
        }

        return retval;
    }


}
