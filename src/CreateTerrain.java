public class CreateTerrain
{
    private int _guiWidth;
    private int _guiHeight;
    private int _resolution;
    private int[] _vArray;

    public CreateTerrain(int guiWidth, int guiHeight, int resolution)
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

    private void setVArray()
    {
        for (int i = 0; i < _vArray.length; i++)
        {
            _vArray[i] = 200;
        }
    }
}
