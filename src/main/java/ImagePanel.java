import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String image) {
        this(new ImageIcon(image).getImage());
    }

    public ImagePanel(Image image) {
        this.image = image;
        //Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
//        Dimension minSize = new Dimension(1000, 500);
//        setPreferredSize(minSize);
//
//        setMinimumSize(minSize);
//
//        setSize(minSize);
//        setLayout(null);
    }


    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}