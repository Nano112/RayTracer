import Graphics.Color;
import Graphics.Image;
import MyMath.IntersectData;
import MyMath.Ray;
import MyMath.Vector.Vector3;
import WorldObjects.Materials.Material;
import WorldObjects.Materials.Reflective;
import WorldObjects.Shapes.Shape;

import java.awt.image.BufferedImage;
import java.util.List;

public class Scene
{
    private List<Shape> shapes;
    private List<Material> material;

    public Scene(List<Shape> s, List<Material> m)
    {
        this.shapes = s;
        this.material = m;
    }

    public IntersectData getIntersect(Ray ray)
    {
        IntersectData id = this.shapes.get(0).intersectWithRay();
        float closestT = id.getT();
        int closestIndex = 0;
        for (int i = 1;i<this.shapes.size();++i)
        {
            id = this.shapes.get(i).intersectWithRay();
            if(id.getDoesIntersect() && id.getT() < closestT)
            {
                closestT = id.getT();
                closestIndex = i;
            }
        }
        id = this.shapes.get(closestIndex).intersectWithRay();
        id.setObjectIndex(closestIndex);
        return id;
    }

    public Color getLuminosity(Ray ray, int iterations, int maxIterations)
    {
     if(iterations >= maxIterations)
     {
         return new Color(0, 0, 0);
     }
     IntersectData id = getIntersect(ray);

     if (id.getDoesIntersect())
     {
         if(this.shapes.get(id.getObjectIndex()).getMaterial() instanceof Reflective)
         {
            Vector3 reflectionDirection =  ray.getDirection().sub(id.getIntersectRay().getDirection().mul(2*id.getIntersectRay().getDirection().dot(ray.getDirection())));
            Ray reflectionRay = new Ray(id.getIntersectRay().getPosition().add(id.getIntersectRay().getDirection().mul(0.001f)), reflectionDirection);
            return getLuminosity(reflectionRay, iterations + 1, maxIterations);
         }
         else
         {
             Ray lightRay = new Ray(id.getIntersectRay().getPosition().add(id.getIntersectRay().getDirection().add(0.001f)),)
         }
     }
     return null;
    }

    public Image renderScene(int width, int height, float fov)
    {
        fov = (float) (fov * Math.PI / 180);
        Image image = new Image(width, height);
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height;++y)
            {
                Vector3 direction = new Vector3(x - width / 2f, y - height / 2f, -width / (2 * (float)Math.tan(fov / 2))).normalize();
                Ray ray = new Ray(new Vector3(0, 0 ,0), direction );
                Color color = getLuminosity(ray, 0,10);
                image.setPixel(x, y, color);
            }
        }
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

    public List<Material> getMaterial()
    {
        return material;
    }

    public void setMaterial(List<Material> material)
    {
        this.material = material;
    }
}
