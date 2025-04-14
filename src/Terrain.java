import javax.swing.*;
import java.awt.*;

public class Terrain extends JPanel
{
    private int _guiWidth;
    private int _guiHeight;
    private int[] _YArray = {300, 250, 260, 230, 180, 190, 180, 340, 260, 220, 240};
    private static int _pointRadius = 3; // greater is less

    public Terrain(int guiWidth, int guiHeight, int resolution)
    {
        _guiWidth = guiWidth;
        _guiHeight = guiHeight;

        /*
        _YArray = new int[_guiWidth/resolution];
        setYArray();

         */
    }

    public int[] getYArray()
    {
        return _YArray;
    }

    public void setYArray()
    {

        for (int i = 0; i < _YArray.length; i++)
        {
            _YArray[i] = 200;
        }
    }

    public void paintComponent(Graphics gui)
    {
        super.paintComponent(gui);
        for (int i = 0; i < _YArray.length; i++)
        {
            int x1 = (i * _guiWidth) / (_YArray.length - 1);
            gui.drawOval(x1 - _pointRadius, _YArray[i] - _pointRadius, _pointRadius * 2, _pointRadius * 2);
        }

        for (int i = 1; i <_YArray.length; i++)
        {
            int x1 = (i - 1) * _guiWidth / (_YArray.length - 1);
            int x2 = i * _guiWidth / (_YArray.length - 1);

            gui.drawLine(x1, _YArray[i-1], x2, _YArray[i]);
        }
    }
}
