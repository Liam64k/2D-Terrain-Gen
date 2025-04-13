import javax.swing.*;
import java.awt.*;

public class Terrain extends JPanel
{
    private int _guiWidth;
    private int _guiHeight;
    private int _resolution;
    private int[] _vArray;

    public Terrain(int guiWidth, int guiHeight, int resolution)
    {
        _guiWidth = guiWidth;
        _guiHeight = guiHeight;
        _resolution = resolution;

        _vArray = new int[_guiWidth/_resolution];
        setVArray();
    }

    public int[] getVArray()
    {
        return _vArray;
    }

    public void setVArray()
    {
        for (int i = 0; i < _vArray.length; i++)
        {
            _vArray[i] = 200;
        }
    }

    public void paintComponent(Graphics gui)
    {
        super.paintComponent(gui);
        for (int i = 0; i < _vArray.length; i++)
        {
            gui.drawOval((i)*(_guiWidth/_resolution), 200, 5, 5);
            gui.fillOval((i)*(_guiWidth/_resolution), 200, 5, 5);
        }
    }
}
