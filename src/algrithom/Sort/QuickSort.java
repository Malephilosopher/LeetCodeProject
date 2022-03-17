package algrithom.Sort;


public class QuickSort {
    /**
     * 交换两个数的值
     * @param a
     * @param b
     * @param c
     */
    public static <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType[] a, int b, int c)
    {
        AnyType temp;
        temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
    /**
     * 快速排序驱动
     * @param a an array of Comparable items
     */
    public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a)
    {
        quicksort(a, 0, a.length - 1);
    }

    /**
     * 三数中值分割法
     * @param a
     * @param left
     * @param right
      */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right)
    {
        int center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0)
        {
            swapReferences(a, left, center);
        }
        if(a[right].compareTo(a[center]) < 0)
        {
            swapReferences(a, right, center);
        }
        if(a[right].compareTo(a[left]) < 0)
        {
            swapReferences(a, right, left);
        }

        //将枢纽元放在right - 1的位置上
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    /**
     * 递归调用的快速排序方法
     * 使用三数中值分割法，且当数组长度小于10时，采用插入排序而不是快速排序
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right)
    {
        final int CUTOFF = 10;
        if(left + CUTOFF <= right)
        {
            AnyType pivot = median3(a, left, right);

            //开始分割
            int i = left, j = right - 1;
            for ( ; ; )
            {
                while (a[++i].compareTo(pivot) < 0) {}
                while (a[++j].compareTo(pivot) > 0) {}
                if(i < j)
                {
                    swapReferences(a, i, j);
                }
                else {
                    break;
                }
            }

            swapReferences(a, i, right - 1);//恢复枢纽元

            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        }
        else {
            insertSort(a);
        }
    }

    /**
     * 插入排序
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType[] a)
    {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            //将i处的值存储在tmp中
            AnyType tmp = a[i];
            //将a[i]的值不断向左移动知道到达正确的位置，所有更大的元素都右移一个位置
            for (j = i; j > 0 && tmp.compareTo(a[j - 1]) < 0 ; j--) {
                a[j] = a[j - 1];
            }
            //最后将tmp放到正确的位置上，与实现二叉堆用到了相同的技巧
            a[j] = tmp;
        }
    }
}
