import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Greyscale {
    BufferedImage image;
    int width;
    int height;

    public Greyscale(String pathname) {
        try {
            File input = new File(pathname);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File output = new File("./grayscale_uzaki.jpg");
            ImageIO.write(image, "jpg", output);
        } catch (Exception e) {
            System.out.println("error:" + e.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Greyscale img = new Greyscale("./uzaki_color.jpg");
    }
}