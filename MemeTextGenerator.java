import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class MemeTextGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the path to the image file: ");
            String imagePath = scanner.nextLine();
            System.out.println("Enter top text: ");
            String topText = scanner.nextLine();
            System.out.println("Enter bottom text: ");
            String bottomText = scanner.nextLine();

            BufferedImage image = ImageIO.read(new File(imagePath));
            Graphics2D g = image.createGraphics();
            g.setColor(Color.WHITE);
            g.setFont(new Font("Impact", Font.BOLD, 50));
            g.drawString(topText, 50, 70);
            g.drawString(bottomText, 50, image.getHeight() - 20);
            g.dispose();

            ImageIO.write(image, "png", new File("output_meme.png"));
            System.out.println("Meme saved as output_meme.png");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
