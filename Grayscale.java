import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Grayscale extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        File input = new File(inputFileName);
        BufferedImage original = ImageIO.read(input);

        int width = original.getWidth();
        int height = original.getHeight();

        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = original.getRGB(x, y);
                ARGB color = new ARGB(pixel);

                int avg = (color.red + color.green + color.blue) / 3;
                ARGB gray = new ARGB(color.alpha, avg, avg, avg);

                output.setRGB(x, y, gray.toInt());
            }
        }

        File outFile = new File(outputFileName);
        ImageIO.write(output, "PNG", outFile);
    }
}
