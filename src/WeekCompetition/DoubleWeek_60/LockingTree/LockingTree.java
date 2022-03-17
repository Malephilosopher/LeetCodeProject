package WeekCompetition.DoubleWeek_60.LockingTree;

import java.util.*;

public class LockingTree {

    int[] parent;
    int[] curUser;
    List<List<Integer>> map;


    public LockingTree(int[] parent) {
        this.parent = parent;
        curUser = new int[parent.length];
        Arrays.fill(curUser, -1);
        map = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            List<Integer> sons = new ArrayList<>();
            map.add(sons);
        }
        for (int i = 1; i < parent.length; i++) {
            map.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if(curUser[num] == -1){
            curUser[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if(curUser[num] == user){
            curUser[num] = -1;
            return true;
        }
        return false;

    }

    public boolean upgrade(int num, int user) {
        int p = num;
        while (p != -1){
            if(curUser[p] != -1){
                return false;
            }
            p = parent[p];
        }
        boolean flag1 = false;
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(num);// 当前节点入队列
        // 遍历其所有的子孙结点
        while(!deque.isEmpty()){
            List<Integer> son = map.get(deque.poll());
            for(int each: son){
                if(curUser[each] != -1){
                    curUser[each] = -1;
                    flag1 = true;
                }
                deque.offer(each);
            }
        }


        if(flag1){
            curUser[num] = user;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] tree = {-1,4,9,0,6,1,0,6,3,1};
        LockingTree obj = new LockingTree(tree);
        System.out.println(obj.upgrade(9, 43));
        System.out.println(obj.upgrade(4, 27));
        System.out.println(obj.upgrade(5, 34));
        System.out.println(obj.upgrade(7, 31));
        System.out.println(obj.upgrade(4, 27));
        System.out.println(obj.lock(2, 47));
        System.out.println(obj.unlock(7, 21));
        System.out.println(obj.upgrade(4, 12));
        System.out.println(obj.upgrade(1, 1));
        System.out.println(obj.upgrade(8, 20));
        System.out.println(obj.lock(5, 50));
        System.out.println(obj.upgrade(5, 28));
        System.out.println(obj.upgrade(0, 11));
        System.out.println(obj.upgrade(6, 19));
        System.out.println(obj.lock(9, 27));
        System.out.println(obj.unlock(5, 6));
        System.out.println(obj.upgrade(0, 5));
        System.out.println(obj.unlock(4, 49));
        System.out.println(obj.unlock(4, 22));
        System.out.println(obj.upgrade(5, 27));
    }
}
