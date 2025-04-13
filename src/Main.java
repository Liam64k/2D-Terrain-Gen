import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame
{
    private static int _guiWidth = 1000;
    private static int _guiHeight = 400;

    public static void main(String[] args)
    {
        new Main();
    }

    public Main()
    {
        getContentPane().setPreferredSize(new Dimension(_guiWidth, _guiHeight));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Terrain t = new Terrain(_guiWidth, _guiHeight, 70);
        System.out.println(Arrays.toString(t.getYArray()));
        t.setBounds(0, 0, _guiWidth, _guiHeight);
        add(t);

        pack(); // resizes JFrame to fit preferred size
        setVisible(true);
        t.repaint();
    }
}