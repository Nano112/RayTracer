package WorldObjects.Materials;

import MyMath.Vector.Vector3;

public class Opaque extends Material
{
    public Opaque(Vector3 albedo)
    {
        super.albedo = albedo;
    }
}
