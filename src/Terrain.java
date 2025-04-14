import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Terrain extends JPanel implements Runnable
{
    private int _guiWidth;
    private int _guiHeight;
    private int[] _YArray;
    private static int _pointRadius = 3; // greater is less
    private static BufferedImage _perlinImage;

    public Terrain(int guiWidth, int guiHeight, int resolution) throws Exception
    {
        _guiWidth = guiWidth;
        _guiHeight = guiHeight;

        _YArray = new int[_guiWidth/resolution];

        _perlinImage = ImageIO.read(new File("src/Perlin_noise_example.png"));
        setYArray(0);

    }

    public void run()
    {
        try
        {
            int i = 0;
            while (true)
            {
                repaint();
                setYArray(i++);
                Thread.sleep(50); // Slows down while loop so laptop doesn't crash
            }
        }
        catch(Exception e)
        {

        }

    }

    public int[] getYArray()
    {
        return _YArray;
    }

    public void setYArray(int time)
    {
        int imgHeight = _perlinImage.getHeight();
        int imgWidth = _perlinImage.getWidth();

        for (int i = 0; i < _YArray.length; i++)
        {
            int x = (i * imgWidth) / _YArray.length;
            int gray = _perlinImage.getRGB(x, time%imgHeight) & 0xFF; // time%imgHeight gets remainder to loop
            _YArray[i] = (_guiHeight * gray) / 255;
        }
    }

    public void paintComponent(Graphics gui)
    {
        super.paintComponent(gui);

        /*
        for (int i = 0; i < _YArray.length; i++) // draw vertices
        {
            int x1 = (i * _guiWidth) / (_YArray.length - 1);
            gui.drawOval(x1 - _pointRadius, _YArray[i] - _pointRadius, _pointRadius * 2, _pointRadius * 2);
        }
        */

        for (int i = 1; i <_YArray.length; i++) // draw lines
        {
            int x1 = (i - 1) * _guiWidth / (_YArray.length - 1);
            int x2 = i * _guiWidth / (_YArray.length - 1);

            gui.drawLine(x1, _YArray[i-1], x2, _YArray[i]);
        }
    }
}
