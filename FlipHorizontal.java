import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FlipHorizontal extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        File input = new File(inputFileName);
        BufferedImage original = ImageIO.read(input);

        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output.setRGB(width - 1 - x, y, original.getRGB(x, y));
            }
        }

        ImageIO.write(output, "PNG", new File(outputFileName));
    }
}
