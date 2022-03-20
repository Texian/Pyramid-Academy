package framework.resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Loader {
    public static void load() {
        try {
            File textureFolder = new File("res/rooms");
            for(File img : textureFolder.listFiles()) {
                Resources.ROOMS.put(img.getName(), ImageIO.read(img));
            }
            Resources.TEXTURES.add(Resources.FLOOR, ImageIO.read(new File("images/textures/floor.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
