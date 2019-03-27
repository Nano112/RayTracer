package WorldObjects.Shapes;

import MyMath.Vector.Vector3;
import MyMath.IntersectData;
import MyMath.Ray;
import WorldObjects.Materials.Material;

public class Sphere extends Shape
{
    private float radius;


    public Sphere(Vector3 p, float r)
    {
        super.position = p;
        this.radius = r;
    }
    @Override
    public IntersectData intersectWithRay(Ray ray)
    {
        IntersectData intersect = new IntersectData();
        float a = 1;
        float b = 2 * ray.getDirection().dot(ray.getPosition().sub(super.position));
        float c = ray.getPosition().sub(super.position).magnitudeSquared() - (this.radius * this.radius);
        float delta = (b * b) - (4 * a * c);

        if ( delta < 0 )
        {
            return intersect;
        }

        float t1 = (float) (-b - Math.sqrt(delta) / (2 * a));
        float t2 = (float) (-b + Math.sqrt(delta) / (2 * a));

        if ( t2 < 0)
        {
            return intersect;
        }

        float t;

        if (t1 > 0)
        {
            t = t1;
        }
        else
        {
            t = t1;
        }

        intersect.setDoesIntersect(true);
        intersect.setT(t);
        intersect.setPosition(ray.getPosition().add(ray.getDirection().mul(t)));
        intersect.setNormal(intersect.getPosition().sub(super.position).normalize());
        return intersect;
    }

    public float getRadius()
    {
        return radius;
    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }

}
