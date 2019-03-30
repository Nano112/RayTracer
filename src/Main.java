import Graphics.Color;
import Graphics.Image;
import MyMath.Vector.Vector3;

import WorldObjects.LightSource;
import WorldObjects.Materials.Opaque;
import WorldObjects.Materials.Reflective;
import WorldObjects.Materials.Transparent;
import WorldObjects.Shapes.Shape;
import WorldObjects.Shapes.Sphere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException
    {

            Scene scene = setUpScene();
            Image image = scene.renderScene(1024,1024,60);
            image.save("frame_");


    }

    public static Scene setUpScene()
    {

        int wallSize = 40000;
        List<Shape> shapes = new ArrayList<Shape>();
        LightSource light = new LightSource(new Vector3(100*(double)Math.sin(0),100,-100+100*(double)Math.cos(0)),10000000);

        shapes.add(new Sphere(new Vector3(0,-wallSize - 100,   0), wallSize, new Opaque(new Vector3(1,1,1))));
        shapes.add(new Sphere(new Vector3(0,+wallSize + 200,   0), wallSize, new Opaque(new Vector3(1,1,1))));
        shapes.add(new Sphere(new Vector3(-wallSize - 100,0,   0), wallSize, new Opaque(new Vector3(0,1,0))));
        shapes.add(new Sphere(new Vector3(+wallSize + 100,0,   0), wallSize, new Opaque(new Vector3(0,1,0))));
        shapes.add(new Sphere(new Vector3(0,0,-wallSize - 800), wallSize, new Opaque(new Vector3(0,0,1))));
        shapes.add(new Sphere(new Vector3(0,0,+wallSize + 200), wallSize, new Opaque(new Vector3(1,0,1))));



        shapes.add(new Sphere(new Vector3(0,              0,-100), 10, new Reflective(new Vector3(0,1,0))));
        shapes.add(new Sphere(new Vector3(20,              20,-130), 10, new Reflective(new Vector3(0,1,0))));
        shapes.add(new Sphere(new Vector3(0,              -20,-80), 10, new Reflective(new Vector3(0,1,0))));

        Scene scene = new Scene(shapes, light);
        return scene;
    }



}

