import Graphics.Color;
import Graphics.Image;
import MyMath.Vector.Vector3;

import WorldObjects.LightSource;
import WorldObjects.Materials.Opaque;
import WorldObjects.Shapes.Shape;
import WorldObjects.Shapes.Sphere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException
    {
        List<Shape> shapes = new ArrayList<Shape>();
        LightSource light = new LightSource(new Vector3(0,100,-100),10000000);
        Shape sphere = new Sphere(new Vector3(0,0,-100), 10, new Opaque(new Color(255,0,0)));
        shapes.add(sphere);
        Scene scene = new Scene(shapes, light);
        Image image = scene.renderScene(100,100,60);
        image.save("out");
    }





}

