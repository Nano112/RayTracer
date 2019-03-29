package MyMath;

public class IntersectData
{
    private boolean doesIntersect;
    private Ray intersectRay;
    private float t;
    private int objectIndex;

    public IntersectData()
    {
        this.doesIntersect = false;
        this.intersectRay = null;
        this.t= 0;
    }

    public void print()
    {
        System.out.println("Does Intersect: ");
        System.out.println(this.doesIntersect);
        if (this.doesIntersect)
        {
            System.out.println("Ray: ");
            this.intersectRay.print();
            System.out.println("T: ");
            System.out.println(this.t);
            System.out.println("ObjectIndex: ");
            System.out.println(this.objectIndex);
        }

    }

    public boolean getDoesIntersect() {
        return doesIntersect;
    }

    public void setDoesIntersect(boolean doesIntersect) {
        this.doesIntersect = doesIntersect;
    }

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }

    public int getObjectIndex() {
        return objectIndex;
    }

    public void setObjectIndex(int objectIndex) {
        this.objectIndex = objectIndex;
    }

    public Ray getIntersectRay()
    {
        return intersectRay;
    }

    public void setIntersectRay(Ray intersectRay)
    {
        this.intersectRay = intersectRay;
    }
}
