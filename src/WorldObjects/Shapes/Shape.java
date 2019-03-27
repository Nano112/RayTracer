package WorldObjects.Shapes;

import MyMath.IntersectData;
import MyMath.Ray;

public abstract class Shape
{

    public IntersectData intersectWithRay() {

        return new IntersectData();
    }

    public abstract IntersectData intersectWithRay(Ray ray);
}
