package MyMath.Vector;

public class Vector3
{
    private double x;
    private double y;
    private double z;

    public Vector3()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public void print()
    {
        System.out.println("X: " + this.x + " Y: " + this.y + " Z: " + this.z);
    }

    public Vector3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 b)
    {
        double x = this.x + b.x;
        double y = this.y + b.y;
        double z = this.z + b.z;
        return new Vector3(x, y, z);
    }

    public Vector3 sub(Vector3 b)
    {
        double x = this.x - b.x;
        double y = this.y - b.y;
        double z = this.z - b.z;
        return new Vector3(x, y, z);
    }

    public Vector3 mul(double b)
    {
        double x = this.x * b;
        double y = this.y * b;
        double z = this.z * b;
        return new Vector3(x, y, z);
    }

    public Vector3 mul(Vector3 b)
    {
        double x = this.x * b.x;
        double y = this.y * b.x;
        double z = this.z * b.x;
        return new Vector3(x, y, z);
    }

    public Vector3 div(double b)
    {
        double x = this.x / b;
        double y = this.y / b;
        double z = this.z / b;
        return new Vector3(x, y, z);
    }

    public double magnitudeSquared()
    {
        double x = this.x;
        double y = this.y;
        double z = this.z;
        return x*x+y*y+z*z;
    }

    public double magnitude()
    {
        return (double) Math.sqrt(this.magnitudeSquared());
    }

    public Vector3 normalize()
    {
        return this.div(this.magnitude());
    }

    public double dot(Vector3 b)
    {
        double x = this.x * b.x;
        double y = this.y * b.y;
        double z = this.z * b.z;
        return x + y + z;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }
}
