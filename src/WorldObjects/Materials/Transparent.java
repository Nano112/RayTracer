package WorldObjects.Materials;

import MyMath.Vector.Vector3;

public class Transparent extends Material
{
    private double refractionIndex;

    public Transparent(Vector3 albedo, double refractionIndex)
    {
        super.albedo = albedo;
        this.refractionIndex = refractionIndex;
    }

    public double getRefractionIndex()
    {
        return refractionIndex;
    }

    public void setRefractionIndex(double refractionIndex)
    {
        this.refractionIndex = refractionIndex;
    }
}
