package WorldObjects.Materials;


import MyMath.Vector.Vector3;

public abstract class Material
{
    protected Vector3 albedo;

    public Vector3 getAlbedo()
    {
        return albedo;
    }

    public void setAlbedo(Vector3 albedo)
    {
        this.albedo = albedo;
    }


}
