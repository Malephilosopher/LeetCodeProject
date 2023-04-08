package April.Day3;

public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        if(target >= letters[right - 1]){
            return letters[0];
        }

        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return letters[left];

    }
}
