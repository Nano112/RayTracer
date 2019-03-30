package WorldObjects.Shapes;

import MyMath.Vector.Vector3;
import MyMath.IntersectData;
import MyMath.Ray;
import WorldObjects.Materials.Material;


public class Sphere extends Shape
{
    private double radius;


    public Sphere(Vector3 p, double r, Material m)
    {
        super.position = p;
        this.radius = r;
        super.material = m;
    }


    public IntersectData intersectWithRay(Ray ray)
    {
        IntersectData intersect = new IntersectData();
        double a = 1;
        double b = 2 * ray.getDirection().dot(ray.getPosition().sub(super.position));
        double c = ray.getPosition().sub(super.position).magnitudeSquared() - (this.radius * this.radius);



        double delta = (b * b) - (4 * a * c);

        if ( delta < 0 )
        {
            return intersect;
        }

        double t1 = (double) (-b - Math.sqrt(delta)) / (2 * a);
        double t2 = (double) (-b + Math.sqrt(delta)) / (2 * a);


        if ( t2 < 0)
        {
            return intersect;
        }

        double t;

        if (t1 > 0)
        {
            t = t1;

        }
        else
        {
            t = t2;
        }
        intersect.setDoesIntersect(true);
        intersect.setT(t);
        Vector3 position = ray.getPosition().add(ray.getDirection().mul(t));
        Vector3 normal = position.sub(super.position).normalize();
        intersect.setIntersectRay(new Ray(position, normal));
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

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

}
