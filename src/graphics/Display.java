package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import sorting.Element;

/**
 * Display.java
 * @author John Zavidniak
 * Display the contents of the algorithm
 * being sorted
 */

public class Display extends JPanel
{
    
    private Element[] array;
    
    /**
     * Create a new Display object with the given dimensions and array
     * @param w the width of the JPanel
     * @param h the height of the JPanel
     * @param array the array to display
     */
    public Display(int w, int h, Element[] array)
    {
        this.array = array;
        this.setSize(w, h);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        Graphics gOffScreen;
        Image offScreen = null;
        Dimension view = new Dimension(this.getWidth(), this.getHeight());
        offScreen = createImage(view.width, view.height);
        gOffScreen = offScreen.getGraphics();
        gOffScreen.setColor(this.getBackground());
        gOffScreen.fillRect(0, 0, view.width, view.height);
        gOffScreen.setColor(getForeground());
        draw(gOffScreen);
        g.drawImage(offScreen, 0, 0, this);
    }
    
    /**
     * Draw the array to the JPanel
     * @param g the Graphics object used for drawing
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        for (int i = 0; i < array.length; i++)
        {
            g.setColor(array[i].getColor());
            g.fillOval(this.getWidth() - (array.length - i) % this.getWidth(),
                    (array.length - array[i].getValue()) % this.getHeight(), 3, 3);
        }
    }
    
}