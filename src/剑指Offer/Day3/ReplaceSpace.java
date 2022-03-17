package 剑指Offer.Day3;

public class ReplaceSpace {

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace1(String s){
        int n = s.length();
        //maximum three times the size of the old string
        char[] array = new char[n * 3];
        int size = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}
