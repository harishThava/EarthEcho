import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RedTint extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        File input = new File(inputFileName);
        BufferedImage original = ImageIO.read(input);

        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ARGB color = new ARGB(original.getRGB(x, y));
                int red = Math.min(color.red + 60, 255);
                ARGB tinted = new ARGB(color.alpha, red, color.green, color.blue);
                output.setRGB(x, y, tinted.toInt());
            }
        }

        ImageIO.write(output, "PNG", new File(outputFileName));
    }
}
