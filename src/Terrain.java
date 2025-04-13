import javax.swing.*;
import java.awt.*;

public class Terrain extends JPanel
{
    private int _guiWidth;
    private int _guiHeight;
    private int[] _YArray;
    private static int _pointRadius = 10; // greater is less

    public Terrain(int guiWidth, int guiHeight, int resolution)
    {
        _guiWidth = guiWidth;
        _guiHeight = guiHeight;

        _YArray = new int[_guiWidth/resolution];
        setYArray();
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
            gui.drawOval((i * _guiWidth) / (_YArray.length - 1) - _pointRadius, _YArray[i] - _pointRadius, _pointRadius * 2, _pointRadius * 2);
        }
    }
}
