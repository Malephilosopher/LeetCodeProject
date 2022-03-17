package leetcode.DiDi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
X星是宇宙中一个非常敬畏生命和热爱生命的星球。在X星上建有一个规模很大而且设备很先进的救援站。

为了方便救援工作的开展，X星规定：任意两点之间的一条边（即两个点之间的一条道路）出现问题，都不会将救援站和居民点之间的联系完全切断。也是说救援站到其他顶点都有两条或者两条以上的路线，这样在救援过程中，即使某一条路线出现问题，还可以通过其他路线到达目的地。

已知救援站和部分居民点之间，以及某些居民点之间有直接的边相连（所有的边均为无向边）。

现在请你编写一个程序，根据给出的救援站和居民点之间，以及某些居民点之间的连接信息，判断每一组输入数据是否满足X星的规定。如果满足规则请输出“Yes”，否则输出“No”。



输入描述
多组输入，第1行输入一个正整数T表示输入数据的组数。

对于每一组输入数据：

第1行输入两个正整数N和M，其中N表示救援点和居民点的数量，对应N个顶点。其中编号为1的顶点表示救援点，编号为2到N表示(N-1)个居民点。M表示救援站和居民点之间，以及某些居民点之间边的数量。（N<=1000，M<=100000）

接下来M行每行包含两个正整数，分别为相邻的两个顶点（救援点或居民点）的编号，两个正整数之间用空格隔开。

输出描述
针对每一组输入数据，如果输入数据满足X星的规定，任意一条边的断开都不会影响到救援站到居民点之间的连通性，输出“Yes”，否则输出“No”。


样例输入
2
4 4
1 2
2 3
3 4
4 1
4 4
1 2
2 3
3 4
1 3
样例输出
Yes
No
 */
public class XStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        int N = 0;
        int M = 0;
        List<String[]> nums = new ArrayList<>();
        for (int i = 0; i < groups; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            String[] num = new String[M];
            for (int j = 0; j < M; j++) {
                String s = sc.nextLine();
                num[j] = s;
            }
            nums.add(num);
        }






    }
}
