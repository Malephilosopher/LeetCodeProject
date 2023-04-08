package May.Day1;

public class MaxTurbulenceSize {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n <= 2)return n;
        int pre = 2;
        int ans = 1;
        String sign = arr[1] > arr[0] ? "<" : ">";
        for (int i = 2; i < n; i++) {
            int cur = arr[i];
            String curSign = "";
            if(cur > arr[i - 1]){
                curSign = "<";
            }else if(arr[i - 1] > cur){
                curSign = ">";
            }else {
                pre = 1;
                sign = curSign;
                continue;
            }
            if(!curSign.equals(sign)){
                pre++;
                ans = Math.max(ans, pre);
            }else {
                pre = 1;
            }
            sign = curSign;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
