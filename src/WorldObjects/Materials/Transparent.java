package WorldObjects.Materials;

public class Transparent extends Material
{
    private float refractionIndex;

    public Transparent(float refractionIndex)
    {
        this.refractionIndex = refractionIndex;
    }

    public float getRefractionIndex()
    {
        return refractionIndex;
    }

    public void setRefractionIndex(float refractionIndex)
    {
        this.refractionIndex = refractionIndex;
    }
}
