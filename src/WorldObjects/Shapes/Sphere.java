package WorldObjects.Shapes;

public class Sphere extends Shape
{
    private Position position;
    private float radius;

    public Sphere(Position p, float r)
    {
        this.position = p;
        this.radius = r;
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
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
