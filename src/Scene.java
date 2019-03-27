import Graphics.Color;
import Graphics.Image;
import MyMath.IntersectData;
import MyMath.Ray;
import MyMath.Vector.Vector3;
import WorldObjects.Materials.Material;
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

        return this.shapes.get(closestIndex).intersectWithRay();
    }

    public Color getLuminosity(Ray ray)
    {
        Color color = new Color(0,0,0);
        return color;
    }

    public Image renderScene(int width, int height, float fov)
    {
        fov = (float) (fov * Math.PI / 180);
        Image image = new Image(width, height);
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height;++y)
            {
                Vector3 direction = new Vector3(x - width / 2, y - height / 2, -width / (2 * (float)Math.tan(fov / 2))).normalize();
                Ray ray = new Ray(new Vector3(0, 0 ,0), direction );
                Color color = getLuminosity(ray);
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
