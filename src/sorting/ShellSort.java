package sorting;

/**
 * ShellSort.java
 * @author John Zavidniak
 */

public class ShellSort
{
    
    /*
     * Marcin Ciura's gap sequence
     * Sorts the array from 0 to GAPS[n] - 1
     */
    private static final int[] GAPS = {701, 301, 132, 57, 23, 10, 4, 1};
    
    /**
     * Sort the given array using the shellsort algorithm
     * @param a the array to sort
     */
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        int j;
        for (int gap : GAPS)
        {
            for (int i = gap; i < a.length; i++)
            {
                T temp = a[i];
                for (j = i; j >= gap && a[j - gap].compareTo(temp) >= 0; j -= gap)
                {
                    Sorter.delaySort(1, true);
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }
    
}