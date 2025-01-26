public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dq=new LinkedListDeque<>();
        int len=word.length();
        for(int i=0;i<len;i++){
            dq.addLast(word.charAt(i));
        }
        return dq;
    }
    public boolean isPalindrome(String word){
        if(word==null||word.length()==1){
            return true;
        }
//        Deque<Character> dq=new LinkedListDeque<>();
//        int len=word.length();
//        for(int i=0;i<len;i++){
//            dq.addFirst(word.charAt(i));
//        }
//        String a="";
//        for(int i=0;i<len;i++){
//            a+=dq.removeFirst();
//        }
//        return a.equals(word);
        else {
            if (word.charAt(0) == word.charAt(word.length()-1)) {
                return isPalindrome(word.substring(1, word.length() - 1));
            }
            else return false;
        }
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        int len=word.length();
        if (word==null||len<=1){
            return true;
        }
        for(int i=0;i<len/2;i++){
            if(!cc.equalChars(word.charAt(i),word.charAt(len-i-1))){
                return false;
            }
        }
        return true;
    }
}
