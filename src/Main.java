import Graphics.Color;
import Graphics.Image;
import MyMath.Vector.Vector3;

import WorldObjects.LightSource;
import WorldObjects.Materials.Opaque;
import WorldObjects.Materials.Reflective;
import WorldObjects.Materials.Transparent;
import WorldObjects.Shapes.Shape;
import WorldObjects.Shapes.Sphere;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException
    {
        cleanOutput();
        for (int i= 0;i<360;++i)
        {
            Scene scene = setUpScene( i);
            Image image = scene.renderScene(480, 480, 110,10);
            image.save(String.format("%03d", i));
        }
        convertToGif();

    }
    public static void cleanOutput()
    {
        File dir = new File("outputFrames");
        for(File file: dir.listFiles())
            if (!file.isDirectory())
                file.delete();
    }

    public static void convertToGif() throws IOException
    {
        String command = "python /c start python toGif.py";
        Process p = Runtime.getRuntime().exec(command );
    }

    public static Scene setUpScene(double t)
    {
        t = t*Math.PI/180;
        int wallSize = 40000;
        List<Shape> shapes = new ArrayList<Shape>();
        LightSource light = new LightSource(new Vector3(0,100,-100),10000000);

        shapes.add(new Sphere(new Vector3(0,-wallSize - 100,   0), wallSize, new Opaque(new Vector3(1,1,1))));
        shapes.add(new Sphere(new Vector3(0,+wallSize + 6000,   0), wallSize, new Opaque(new Vector3(1,1,1))));
        shapes.add(new Sphere(new Vector3(-wallSize - 200,0,   0), wallSize, new Reflective(new Vector3(1,0,0))));
        shapes.add(new Sphere(new Vector3(+wallSize + 200,0,   0), wallSize, new Reflective(new Vector3(0,1,0))));
        shapes.add(new Sphere(new Vector3(0,0,-wallSize - 200), wallSize, new Reflective(new Vector3(1,0,1))));
        shapes.add(new Sphere(new Vector3(0,0,+wallSize + 200), wallSize, new Reflective(new Vector3(0,1,1))));
        shapes.add(new Sphere(new Vector3(0, 50*Math.sin(t),-100),20*Math.abs(Math.sin(t)),new Transparent(new Vector3(1,1,1),1.3)));
        for(int i = 0;i<1000; i+=1)
        {
            shapes.add(new Sphere(new Vector3(50*(double)Math.sin(t+i*Math.PI/10),              -50+10*i ,-100+50*Math.cos(t+i*Math.PI/10)), 10, new Opaque(new Vector3(0.7,0.2,0.2))));
        }
        Scene scene = new Scene(shapes, light);
        return scene;
    }



}

