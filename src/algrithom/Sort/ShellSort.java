package algrithom.Sort;

//希尔排序(缩减增量排序)
public class ShellSort {
    public static <AnyType extends Comparable<? super AnyType>> void shellsort(AnyType[] a)
    {
        int j;
        //gap从数组的中间开始，每次除以二
        for (int gap = a.length / 2 ; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                AnyType tmp = a[i];
                //每隔gap进行插入排序
                for (j = i; j > 0 && tmp.compareTo(a[j - gap]) < 0; j-= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }
}
