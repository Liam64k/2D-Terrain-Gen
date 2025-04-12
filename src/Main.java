import javax.swing.*;
import java.util.Arrays;

public class Main extends JFrame
{
    private static int _guiWidth = 400;
    private static int _guiHeight = 400;

    public static void main(String[] args)
    {
        new Main();

        CreateTerrain t = new CreateTerrain(_guiWidth, _guiHeight, 20);
        System.out.println(Arrays.toString(t.getVArray()));
    }

    public Main()
    {
        setBounds(0, 0, _guiWidth, _guiHeight);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    public void drawTerrain()
    {

    }
}