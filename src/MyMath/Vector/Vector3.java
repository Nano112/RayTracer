package MyMath.Vector;

public class Vector3
{
    private float x;
    private float y;
    private float z;

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

    public Vector3(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 b)
    {
        float x = this.x + b.x;
        float y = this.y + b.y;
        float z = this.z + b.z;
        return new Vector3(x, y, z);
    }

    public Vector3 sub(Vector3 b)
    {
        float x = this.x - b.x;
        float y = this.y - b.y;
        float z = this.z - b.z;
        return new Vector3(x, y, z);
    }

    public Vector3 mul(float b)
    {
        float x = this.x * b;
        float y = this.y * b;
        float z = this.z * b;
        return new Vector3(x, y, z);
    }

    public Vector3 mul(Vector3 b)
    {
        float x = this.x * b.x;
        float y = this.y * b.x;
        float z = this.z * b.x;
        return new Vector3(x, y, z);
    }

    public Vector3 div(float b)
    {
        float x = this.x / b;
        float y = this.y / b;
        float z = this.z / b;
        return new Vector3(x, y, z);
    }

    public float magnitudeSquared()
    {
        float x = this.x;
        float y = this.y;
        float z = this.z;
        return x*x+y*y+z*z;
    }

    public float magnitude()
    {
        return (float) Math.sqrt(this.magnitudeSquared());
    }

    public Vector3 normalize()
    {
        return this.div(this.magnitude());
    }

    public float dot(Vector3 b)
    {
        float x = this.x * b.x;
        float y = this.y * b.y;
        float z = this.z * b.z;
        return x + y + z;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getZ()
    {
        return z;
    }

    public void setZ(float z)
    {
        this.z = z;
    }
}
