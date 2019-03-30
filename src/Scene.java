import Graphics.Color;
import Graphics.Image;
import MyMath.IntersectData;
import MyMath.Ray;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Materials.Reflective;
import WorldObjects.Materials.Transparent;
import WorldObjects.Shapes.Shape;

import java.util.List;

public class Scene
{
    private LightSource light;
    private List<Shape> shapes;

    public Scene(List<Shape> s, LightSource light)
    {
        this.shapes = s;
        this.light = light;
    }

    public IntersectData getIntersect(Ray ray)
    {
        IntersectData id;
        int closestIndex = 0;
        double closestT = Double.MAX_VALUE;
        //System.out.println(id.getT());
        for (int i = 0; i<this.shapes.size(); ++i)
        {
            id = this.shapes.get(i).intersectWithRay(ray);
            if(id.getDoesIntersect() && (id.getT() < closestT))
            {
                closestT = id.getT();
                closestIndex = i;
            }
        }
        id = this.shapes.get(closestIndex).intersectWithRay(ray);
        if(id.getDoesIntersect())
        {
            id.setObjectIndex(closestIndex);
        }
        return id;
    }

    public Color getLuminosity(Ray ray, int iterations, int maxIterations)
    {
        Color color =  new Color(0, 0, 0);
        if(iterations >= maxIterations)
        {
            return color;
        }
        IntersectData id = getIntersect(ray);
        if (id.getDoesIntersect())
        {
            Vector3 intensity;
            if(this.shapes.get(id.getObjectIndex()).getMaterial() instanceof Transparent)
            {
                double n1 = 1;
                double n2 = ((Transparent) this.shapes.get(id.getObjectIndex()).getMaterial()).getRefractionIndex();
                Vector3 transparentNormal = id.getIntersectRay().getDirection();
                if (ray.getDirection().dot(transparentNormal) > 0)
                {
                    double temp = n1;
                    n1 = n2;
                    n2 = temp;
                    transparentNormal = transparentNormal.mul(-1);
                }
                double radical = 1 - Math.sqrt(n1/n2) * (1- Math.sqrt(transparentNormal.dot(ray.getDirection())));
                if (radical > 0)
                {
                    Vector3 refractedDirection = ray.getDirection().sub(ray.getDirection()).mul(transparentNormal.dot(transparentNormal)).mul(n1/n2).sub(transparentNormal).mul(Math.sqrt(radical));
                    Ray refractedRay = new Ray(id.getIntersectRay().getPosition().sub(transparentNormal.mul(0.0001f)),refractedDirection);
                    return getLuminosity(refractedRay,iterations + 1, maxIterations);
                }
            }
            else if(this.shapes.get(id.getObjectIndex()).getMaterial() instanceof Reflective)
            {
                Vector3 reflectionDirection =  ray.getDirection().sub(id.getIntersectRay().getDirection().mul(2*id.getIntersectRay().getDirection().dot(ray.getDirection())));
                Ray reflectionRay = new Ray(id.getIntersectRay().getPosition().add(id.getIntersectRay().getDirection().mul(0.0001f)), reflectionDirection);
                return getLuminosity(reflectionRay, iterations + 1, maxIterations);
            }
            else
            {

                Ray lightRay = new Ray(id.getIntersectRay().getPosition().add(id.getIntersectRay().getDirection().mul(0.0001f)),this.light.getPosition().sub(id.getIntersectRay().getPosition()).normalize());
                IntersectData idClosestLight = getIntersect(lightRay);
                if (idClosestLight.getDoesIntersect() && ((idClosestLight.getT()*idClosestLight.getT()) < this.light.getPosition().sub(id.getIntersectRay().getPosition()).magnitudeSquared()))
                {
                    return new Color(0, 0, 0);
                }
                else
                {
                    Vector3 materialColor = this.getShapes().get(id.getObjectIndex()).getMaterial().getAlbedo();
                    Vector3 A = materialColor.mul(this.light.getIntensity());
                    double B = this.light.getPosition().sub(id.getIntersectRay().getPosition()).normalize().dot(id.getIntersectRay().getDirection());
                    double C = (double)Math.sqrt(this.light.getPosition().sub(id.getIntersectRay().getPosition()).magnitudeSquared());
                    intensity = A.mul(B/C);
                }
                color.setR((byte) Math.min(255, Math.max(0, (int)Math.pow(intensity.getX(),1 / 2.2))));
                color.setG((byte) Math.min(255, Math.max(0, (int)Math.pow(intensity.getY(),1 / 2.2))));
                color.setB((byte) Math.min(255, Math.max(0, (int)Math.pow(intensity.getZ(),1 / 2.2))));
                return color;
            }
         }
     return new Color(0,0,0);
    }


    public Image renderScene(int width, int height, double fov)
    {
        long start = System.currentTimeMillis();
        fov = (double) (fov * Math.PI / 180);
        Image image = new Image(width, height);
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height;++y)
            {
                Vector3 direction = new Vector3(x - width / 2f, y - height / 2f, -width / (2 * (double)Math.tan(fov / 2))).normalize();
                Ray ray = new Ray(new Vector3(0, 0 ,0), direction );
                Color color = getLuminosity(ray, 0,10);
                image.setPixel(x, height-y-1, color);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Frame took " + (end - start) + "ms");
        return image;
    }

    public List<Shape> getShapes()
    {
        return shapes;
    }

    public void setShapes(List<Shape> shapes)
    {
        this.shapes = shapes;
    }

    public LightSource getLight()
    {
        return light;
    }

    public void setLight(LightSource light)
    {
        this.light = light;
    }
}
