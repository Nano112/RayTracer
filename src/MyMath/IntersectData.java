package MyMath;

import MyMath.Vector.Vector3;

public class IntersectData
{
    private boolean doesIntersect;
    private Vector3 position;
    private Vector3 normal;
    private float t;
    private int objectIndex;

    public IntersectData()
    {
        this.doesIntersect = false;
        this.position = null;
        this.normal = null;
        this.t= 0;
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

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getNormal() {
        return normal;
    }

    public void setNormal(Vector3 normal) {
        this.normal = normal;
    }
}
