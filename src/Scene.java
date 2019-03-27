import WorldObjects.Materials.Material;
import WorldObjects.Shapes.Shape;
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
