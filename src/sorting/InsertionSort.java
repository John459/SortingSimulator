package sorting;

/**
 * InsertionSort.java
 * @author John Zavidniak
 */

public class InsertionSort
{
    
    /**
     * Sort the given array using the insertionsort algorithm
     * @param a the array to sort 
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            T value = a[i];
            int holePos = i;
            while (holePos > 0  && value.compareTo(a[holePos-1]) < 0)
            {
                //slow down computation to make the sorting visible
                Sorter.delaySort(6, false);
                a[holePos] = a[holePos-1];
                holePos--;
            }
            a[holePos] = value;
        }
    }
    
}