package WorldObjects.Materials;

import Graphics.Color;

public abstract class Material
{
    protected Color albedo;

    public Color getAlbedo()
    {
        return albedo;
    }

    public void setAlbedo(Color albedo)
    {
        this.albedo = albedo;
    }


}
