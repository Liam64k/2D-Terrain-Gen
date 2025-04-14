import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Terrain extends JPanel
{
    private int _guiWidth;
    private int _guiHeight;
    private int[] _YArray;
    private static int _pointRadius = 3; // greater is less
    private static BufferedImage _perlinImage;

    public Terrain(int guiWidth, int guiHeight, int resolution)
    {
        _guiWidth = guiWidth;
        _guiHeight = guiHeight;

        _YArray = new int[_guiWidth/resolution];

        try {
            _perlinImage = ImageIO.read(new File("src/Perlin_noise_example.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setYArray();

    }

    public int[] getYArray()
    {
        return _YArray;
    }

    public void setYArray()
    {
        int imgHeight = _perlinImage.getHeight();
        int imgWidth = _perlinImage.getWidth();

        for (int i = 0; i < _YArray.length; i++)
        {
            int x = (i * imgWidth) / _YArray.length;
            int gray = _perlinImage.getRGB(x, imgHeight / 3) & 0xFF;
            _YArray[i] = (_guiHeight * gray) / 255;
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
