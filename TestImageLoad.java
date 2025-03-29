import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TestImageLoad {
    public static void main(String[] args) throws Exception {
        File file = new File("donation.png");
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());

        BufferedImage img = ImageIO.read(file);
        if (img == null) {
            System.out.println("❌ ImageIO.read returned null!");
        } else {
            System.out.println("✅ Image loaded: " + img.getWidth() + "x" + img.getHeight());
        }
    }
}
