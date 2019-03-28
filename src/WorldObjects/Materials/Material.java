package WorldObjects.Materials;

import Graphics.Color;

public abstract class Material
{
    private Color albedo;

    public Color getAlbedo()
    {
        return albedo;
    }

    public void setAlbedo(Color albedo)
    {
        this.albedo = albedo;
    }


}
