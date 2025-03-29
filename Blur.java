import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Blur extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        File input = new File(inputFileName);
        BufferedImage original = ImageIO.read(input);

        int width = original.getWidth();
        int height = original.getHeight();

        BufferedImage blurred = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int redSum = 0, greenSum = 0, blueSum = 0, alphaSum = 0;
                int count = 0;

                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                            int pixel = original.getRGB(nx, ny);
                            ARGB color = new ARGB(pixel);

                            redSum += color.red;
                            greenSum += color.green;
                            blueSum += color.blue;
                            alphaSum += color.alpha;
                            count++;
                        }
                    }
                }

                int avgRed = redSum / count;
                int avgGreen = greenSum / count;
                int avgBlue = blueSum / count;
                int avgAlpha = alphaSum / count;

                ARGB blurredColor = new ARGB(avgAlpha, avgRed, avgGreen, avgBlue);
                blurred.setRGB(x, y, blurredColor.toInt());
            }
        }

        File output = new File(outputFileName);
        ImageIO.write(blurred, "PNG", output);
    }
}
