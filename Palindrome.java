import java.util.Locale;

public class Palindrome {

    public static boolean hasPalindrome(String[] input){
        boolean result = false;
        for(String s: input){
            String curr = s.toLowerCase();
            String rev = "";
            for(int i=s.length()-1; i>=0; i--){
                rev = rev + s.charAt(i);
            }
            if(s.equals(rev)){
                result = true;
                break;
            }
        }
        return result;
    }

    //Tests
    public static void main(String[] args) {

        //1 palindrome
        String[] words = {"apple", "banana", "cars", "racecar", "zebra"};
        boolean result = hasPalindrome(words);
        System.out.println(result);

        //no palindromes
        String[] words2 = {"apple", "banana", "cars", "zebra"};
        boolean result2 = hasPalindrome(words2);
        System.out.println(result2);

        //2 palindromes
        String[] words3 = {"apple", "kayak", "racecar", "zebra"};
        boolean result3 = hasPalindrome(words3);
        System.out.println(result3);

    }

}
