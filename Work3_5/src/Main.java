public class Main {
    public static void main(String[] args) {
        String S="Pinkman";
        String[] words={"Pink","man","woman","in","Pman"};
        System.out.println(countSubsequenceWords(S,words));

    }

    /**
     * 判断有多少子序列
     * @param S
     * @param words
     * @return
     */
    public static int countSubsequenceWords(String S,String[] words){
        int count=0;
        for (String word:words
             ) {
            if(isSubsequence(S,word)==true){
//                words中某个字符串是S的子序列则加一
                count++;
            }

        }
        return count;
    }

    /**
     * 判断word是否为s的子序列
     * @param s
     * @param word
     * @return
     */
    private static boolean isSubsequence(String s, String word) {
        int wordIndex = 0;
        int SIndex = 0;
        while (wordIndex<word.length()&&SIndex<s.length()){
//            如果s和word中的某一位置的字符相同则wordIndex加1，继续判断word的下一个和s的下一个字符是否相同
            if(s.charAt(SIndex)==word.charAt(wordIndex)){
                wordIndex++;
            }
//            无论是否相同s都会判断s下一个位置的字符
            SIndex++;
        }
//        word的位置和word的长度相同则为true
        return wordIndex==word.length();
    }


}