package graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import sorting.Element;
import sorting.Sorter;

/**
 * Panel.java
 * @author John Zavidniak
 * A panel that manages how the array should be sorted
 */

public class Panel extends JPanel
{
    
    /**
     * @author John Zavidniak
     * Manage actions from the various objects in the Panel
     */
    private class Listener implements ActionListener
    {
        
        private boolean sorted = true;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(e.getActionCommand());
            if (sorter.isSorting())
            {
                return;
            }
            switch (e.getActionCommand().toLowerCase())
            {
            case "selection sort":
                sorter.setSort(Sorter.SELECTION_SORT);
                break;
            case "heap sort":
                sorter.setSort(Sorter.HEAP_SORT);
                break;
            case "insertion sort":
                sorter.setSort(Sorter.INSERTION_SORT);
                break;
            case "bubble sort":
                sorter.setSort(Sorter.BUBBLE_SORT);
                break;
            case "shaker sort":
                sorter.setSort(Sorter.SHAKER_SORT);
                break;
            case "shell sort":
                sorter.setSort(Sorter.SHELL_SORT);
                break;
            case "comb sort":
                sorter.setSort(Sorter.COMB_SORT);
                break;
            case "random":
                distribution = 1;
                dataDistributionLabel.setText("Data Distribution: Random");
                break;
            case "reverse":
                distribution = 2;
                dataDistributionLabel.setText("Data Distribution: Reverse");
                break;
            case "ordered":
                distribution = 0;
                dataDistributionLabel.setText("Data Distribution: Ordered");
                break;
            case "perform sort":
            default:
                if (sorted)
                {
                    switch (distribution)
                    {
                    case 0:
                        View.popArrayOrdered(sorter.getArray());
                        break;
                    case 1:
                        View.popArrayRandom(sorter.getArray());
                        break;
                    case 2:
                        View.popArrayReverseSorted(sorter.getArray());
                        break;
                    default:
                        View.popArrayRandom(sorter.getArray());
                        break;
                    }
                }
                sorter.sort();
                sorted = true;
                break;
            }
            sortingLabel.setText("Sorting Algorithm: " + sorter);
        }
        
    }
    
    private JLabel sortingLabel;
    private JLabel dataDistributionLabel;
    private JMenuBar sortingBar;
    private JMenuBar dataDistributionBar;
    private JButton performSort;
    private Listener listener;
    private int distribution;
    
    private Sorter<Element> sorter;
    
    /**
     * Create a new Panel object with the given array
     * @param array the array that will be used for sorting
     */
    public Panel(Element[] array)
    {
        this.distribution = 1;
        this.setLayout(new GridLayout(1, 5));
        this.sorter = new Sorter<Element>(array);
        sortingLabel = new JLabel("Sorting Algorithm: " + sorter);
        dataDistributionLabel = new JLabel("Data Distribution: Random");
        performSort = new JButton("Perform Sort");
        listener = new Listener();
        performSort.addActionListener(listener);
        this.add(sortingLabel);
        createSortingMenuBar();
        this.add(sortingBar);
        this.add(dataDistributionLabel);
        createDataDistributionMenuBar();
        this.add(dataDistributionBar);
        this.add(performSort);
        this.setVisible(true);
    }
    
    /**
     * Create the DataDistributionMenuBar
     */
    private void createDataDistributionMenuBar()
    {
        dataDistributionBar = new JMenuBar();
        JMenu distributions = new JMenu("Data Distribution");
        
        JMenuItem random = new JMenuItem("Random");
        random.addActionListener(listener);
        
        JMenuItem reverse = new JMenuItem("Reverse");
        reverse.addActionListener(listener);
        
        JMenuItem ordered = new JMenuItem("Ordered");
        ordered.addActionListener(listener);
        
        distributions.add(random);
        distributions.add(reverse);
        distributions.add(ordered);
        dataDistributionBar.add(distributions);
    }
    
    /**
     * Create the SortingMenuBar
     */
    private void createSortingMenuBar()
    {
        sortingBar = new JMenuBar();
        JMenu algorithms = new JMenu("Algorithms");
        
        JMenuItem selectionSort = new JMenuItem("Selection Sort");
        selectionSort.addActionListener(listener);
        
        JMenuItem heapSort = new JMenuItem("Heap sort");
        heapSort.addActionListener(listener);
        
        JMenuItem insertionSort = new JMenuItem("Insertion Sort");
        insertionSort.addActionListener(listener);
        
        JMenuItem bubbleSort = new JMenuItem("Bubble Sort");
        bubbleSort.addActionListener(listener);
        
        JMenuItem shakerSort = new JMenuItem("Shaker Sort");
        shakerSort.addActionListener(listener);
        
        JMenuItem shellSort = new JMenuItem("Shell Sort");
        shellSort.addActionListener(listener);
        
        JMenuItem combSort = new JMenuItem("Comb Sort");
        combSort.addActionListener(listener);
        
        algorithms.add(selectionSort);
        algorithms.add(heapSort);
        algorithms.add(insertionSort);
        algorithms.add(bubbleSort);
        algorithms.add(shakerSort);
        algorithms.add(shellSort);
        algorithms.add(combSort);
        sortingBar.add(algorithms);
    }
    
}