package WorldObjects.Shapes;

import Math.Vector.Vector3;
import Math.IntersectData;
import Math.Ray;

public class Sphere extends Shape
{

    private Vector3 position;
    private float radius;

    public Sphere(Vector3 p, float r)
    {
        this.position = p;
        this.radius = r;
    }

    public IntersectData intersectWithRay(Ray ray)
    {
        IntersectData intersect = new IntersectData();
        float a = 1;
        float b = 2 * ray.getDirection().dot(ray.getPosition().sub(this.position));
        float c = ray.getPosition().sub(this.position).magnitudeSquared() - (this.radius * this.radius);
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
        intersect.setNormal(position.sub(this.position).normalize());
        return intersect;
    }

    public Vector3 getPosition()
    {
        return position;
    }

    public void setPosition(Vector3 position)
    {
        this.position = position;
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
