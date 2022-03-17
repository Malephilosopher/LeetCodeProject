package leetcode.CanPlaceFlowers;

public class CPFPer {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int count = 0;
        if(l == 1 && flowerbed[0] == 0)
        {
            return n <= 1;
        }
        if(l == 1 && flowerbed[0] == 1) return n == 0;
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }
        if(l >= 3)
        {
            if(flowerbed[l - 2] == 0 && flowerbed[l - 1] == 0){
                count++;
                flowerbed[l - 1] = 1;
            }
        }
        for (int i = 1; i < l - 1; i++) {
            if(flowerbed[i] != 1)
            {
                if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
                {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        if(count >= n) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
