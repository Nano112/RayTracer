package WorldObjects.Shapes;

import MyMath.IntersectData;
import MyMath.Ray;
import MyMath.Vector.Vector3;
import WorldObjects.Materials.Material;

public abstract class Shape
{
    protected Vector3 position;
    protected Material material;
    public IntersectData intersectWithRay() {

        return new IntersectData();
    }

    public abstract IntersectData intersectWithRay(Ray ray);

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }
}
