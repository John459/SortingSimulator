package sorting;

/**
 * CombSort.java
 * @author John Zavidniak
 */

public class CombSort
{
    
    /**
     * Sort the given array using the combsort algorithm
     * @param a the array to sort
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        boolean slow = false;
        int gap = a.length;
        boolean swapped = true;
        while (gap != 1 || swapped)
        {
            swapped = false;
            gap /= 1.247330950103979;
            if (gap < 1)
            {
                gap = 1;
            }
            for (int i = 0; i < a.length - gap; i++)
            {
                //slow down computation to make the sorting visible
                if (slow)
                {
                    Sorter.delaySort(1, true);
                }
                slow = !slow;
                if (a[i].compareTo(a[i + gap]) > 0)
                {
                    T temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
    
}