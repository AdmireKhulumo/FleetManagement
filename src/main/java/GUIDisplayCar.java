import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUIDisplayCar {

    public void create(Car car) {

        //create panel and frame objects
        JFrame frame = new JFrame("Car Display");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
//        panel.setMaximumSize(new Dimension(500,400));

        //use a gridbag layout
        panel.setLayout(new GridBagLayout());

        //choose constraints for the grid bag layout
        GridBagConstraints gbc = new GridBagConstraints();

        //TOPIC -- fills entire row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy=0;
        gbc.gridwidth = 3;
        JLabel lblTopic = new JLabel("CAR DETAILS");
        lblTopic.setFont(new Font("Courier New",Font.ITALIC, 40));
        panel.add(lblTopic, gbc);

        //define font and border for subsequent labels
        Font labelFont = new Font("Courier New",Font.PLAIN, 25);
        Border lblBorder = BorderFactory.createLineBorder(Color.WHITE, 2, true);


        //for image
        try{
            //for image
            //add image to (0,1) coordinate, make it fit all columns going down
            gbc = getGBC(0,1);
            gbc.gridheight = 6;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.fill = GridBagConstraints.VERTICAL;

            //use buffered image to prepare the image and link to the file
            BufferedImage image = ImageIO.read(new File(car.getUrl()));

            Border labelBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);
            //add image to label object as an icon, then add that to the frame
            JLabel lblImg = new JLabel(new ImageIcon(image));
//            lblImg.setSize(200,100);
            lblImg.setBorder(labelBorder);

            //add image icon to panel
            panel.add(lblImg, gbc);

        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        //MAKE TAG
        gbc = getGBC(1,1);
        JLabel lblMake = createLabel("MAKE: ");
        panel.add(lblMake, gbc);
        //MAKE VALUE
        gbc = getGBC(2,1);
        JLabel lblMakeValue = createLabel(car.getMake());
        panel.add(lblMakeValue, gbc);

        //Model
        gbc = getGBC(1,2);
        JLabel lblModel = createLabel("MODEL: ");
        panel.add(lblModel, gbc);
        //Value
        gbc = getGBC(2,2);
        JLabel lblModelValue = createLabel(car.getModel());
        panel.add(lblModelValue, gbc);

        //YEAR
        gbc = getGBC(1,3);
        JLabel lblYear = createLabel("YEAR: ");
        panel.add(lblYear,gbc);
        //Value
        gbc = getGBC(2,3);
        JLabel lblYearValue = createLabel(Integer.toString(car.getYear()));
        panel.add(lblYearValue,gbc);


        //REGNO
        //add model label taking at (x1,y4)
        gbc = getGBC(1,4);
        JLabel lblRegNo = createLabel("Reg. No: ");
        panel.add(lblRegNo,gbc);
        //value
        gbc = getGBC(2,4);
        JLabel lblRegNoValue = createLabel(car.getRegNo());
        panel.add(lblRegNoValue,gbc);

        //AVAILABLE
        //add model label taking at (x1,y5)
        gbc = getGBC(1,5);
        JLabel lblAvailable = createLabel("Available: ");
        panel.add(lblAvailable,gbc);
        //value
        gbc = getGBC(2,5);
        JLabel lblAvailableValue = createLabel(car.getAvailable());
        panel.add(lblAvailableValue,gbc);

        //add panel
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //function that returns a JLabel with certain default properties like font, border and colout
    private JLabel createLabel(String text){
        //define font and border for subsequent labels
        Font labelFont = new Font("Courier New",Font.PLAIN, 25);
        Border labelBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);

        //set the default font an border properties
        JLabel label = new JLabel(text);
        label.setFont(labelFont);
        label.setBorder(labelBorder);
//      label.setForeground(Color.WHITE);


        //return label created
        return label;
    }

    //function to create a grid bag constraint object with default properties..these are standard for each JLabel
    //supply x and y coordinates
    private GridBagConstraints getGBC(int x, int y){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight =1;
        gbc.gridwidth = 1;
       gbc.ipady = 30;

        return gbc;
    }
}
