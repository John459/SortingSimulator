package sorting;

/**
 * ShakerSort.java
 * @author John Zavidniak
 */

public class ShakerSort
{
    
    /**
     * Sort the given array using the shakersort algorithm
     * @param a the array to sort
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        boolean swapped = true;
        while (swapped)
        {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++)
            {
                //slow down computation to make the sorting visible
                Sorter.delaySort(3, false);
                if (a[i].compareTo(a[i+1]) > 0)
                {
                    T temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
            for (int i = a.length - 2; i >= 0; i--)
            {
                //slow down computation to make the sorting visible
                Sorter.delaySort(3, false);
                if (a[i].compareTo(a[i+1]) > 0)
                {
                    T temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
        }
    }
    
}