package OtherTests;

public class IsPalindrome {
    public static boolean isPalindrome(String text) {
        String newString = text.replaceAll("[^a-zA-Z0-9]","");
        StringBuilder initialString = new StringBuilder
                (newString);
        StringBuilder reverseString = initialString.reverse();
        boolean result = newString.equalsIgnoreCase(String.valueOf(reverseString));
        return result;
    }

    public static void main(String[] args) {
        System.out.println( isPalindrome("23334evdve"));
    }
}
