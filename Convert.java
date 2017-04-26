import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;

public class Convert {

    // The path can be customized
    public static final String IMG = "1.jpg";

    public static void main(String[] args) throws IOException {
        // Get image's RGB info
        BufferedImage img;
        img = ImageIO.read(new File(IMG));
        int w = img.getWidth();
        int h = img.getHeight();
        Color[][] color = new Color[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                color[j][i] = new Color(img.getRGB(j, i));
            }
        }

        // Prints out the ASCII
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(getChar(greyScale(color[j][i])));
            }
            System.out.println();
        }
    }

    // Calculates the grescale of a color using fomula
    public static double greyScale(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        return 0.2989 * r + 0.587 * g + 0.114 * b;
    }

    // Gets the corresponding character
    public static char getChar(double g){
        if (g >= 231) {
            return ' ';
        }
        else if (g >= 205) {
            return '.';
        }
        else if (g >= 179) {
            return ':';
        }
        else if (g >= 153) {
            return '-';
        }
        else if (g >= 128) {
            return '=';
        }
        else if (g >= 103) {
            return '+';
        }
        else if (g >= 77) {
            return '*';
        }
        else if (g >=51) {
            return '#';
        }
        else if (g >= 26) {
            return '%';
        }
        else {
            return '@';
        }
    }
}
