package WorldObjects.Materials;

import Graphics.Color;

public class Material
{
    private Color albedo;
    private Boolean isMirror;
    private Boolean isTransparent;
    private float refractionIndex;

    public Color getAlbedo()
    {
        return albedo;
    }

    public void setAlbedo(Color albedo)
    {
        this.albedo = albedo;
    }

    public Boolean getMirror()
    {
        return isMirror;
    }

    public void setMirror(Boolean mirror)
    {
        isMirror = mirror;
    }

    public Boolean getTransparent()
    {
        return isTransparent;
    }

    public void setTransparent(Boolean transparent)
    {
        isTransparent = transparent;
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
