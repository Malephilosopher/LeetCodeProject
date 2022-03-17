package leetcode.HashMap.CanConstruct;

public class CCPer {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] noteCount = new int[26];
        int[] magazineCount = new int[26];
        for(int i = 0;i < ransomNote.length();i++) {
            noteCount[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0;i < magazine.length();i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0;i < noteCount.length;i++) {
            if(noteCount[i] > magazineCount[i]) {
                return false;
            }
        }
        return true;
    }

}
