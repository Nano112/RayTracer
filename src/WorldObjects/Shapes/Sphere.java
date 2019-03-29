package WorldObjects.Shapes;

import MyMath.Vector.Vector3;
import MyMath.IntersectData;
import MyMath.Ray;
import WorldObjects.Materials.Material;


public class Sphere extends Shape
{
    private float radius;


    public Sphere(Vector3 p, float r, Material m)
    {
        super.position = p;
        this.radius = r;
        super.material = m;
    }


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
        Vector3 position = ray.getPosition().add(ray.getDirection().mul(t));
        Vector3 normal = position.sub(super.position).normalize();
        intersect.setIntersectRay(new Ray(position, normal));
        intersect.print();
        return intersect;
    }


    public void print()
    {
        System.out.println("I am a sphere");
        System.out.println("Position");
        this.position.print();
        System.out.println("Radius");
        System.out.println(this.radius);
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
