import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIReturnCar {
    
    private TextField regnoText = new TextField(20);
    private JFrame frame;

    public void create() {

        //JPanel panel = new JPanel();
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
        frame = new JFrame();
        frame.setSize(400, 400);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Return Car Page");
        panel.setLayout(null);
        //define font for subsequent labels smaller
        Font labelFont = new Font("Courier New",Font.PLAIN, 16);
        //define font for titles
        Font titleFont = new Font("Courier New",Font.BOLD, 25);

        JLabel title = new JLabel("RETURN CAR");
        title.setBounds(130, 20, 150, 25);
        title.setFont(titleFont);
        panel.add(title);

        JLabel regnolabel = new JLabel("Reg. Number");
        regnolabel.setBounds(10, 60, 150, 25);
        regnolabel.setFont(labelFont);
        panel.add(regnolabel);


        regnoText.setBounds(160, 60, 200, 25);
        panel.add(regnoText);

        JLabel fnamelabel = new JLabel("First Name");
        fnamelabel.setBounds(10, 90, 150, 25);
        fnamelabel.setFont(labelFont);
        panel.add(fnamelabel);

        TextField fnamelabelText = new TextField(20);
        fnamelabelText.setBounds(160, 90, 200, 25);
        panel.add(fnamelabelText);
        
        JLabel snamelabel = new JLabel("Last Name");
        snamelabel.setBounds(10, 120, 150, 25);
        snamelabel.setFont(labelFont);
        panel.add(snamelabel);

        TextField snamelabelText = new TextField(20);
        snamelabelText.setBounds(160, 120, 200, 25);
        panel.add(snamelabelText);
        
        JLabel idnolabel = new JLabel("ID Number");
        idnolabel.setBounds(10, 150, 150, 25);
        idnolabel.setFont(labelFont);
        panel.add(idnolabel);

        TextField idnolabelText = new TextField(20);
        idnolabelText.setBounds(160, 150, 200, 25);
        panel.add(idnolabelText);
        
        JButton button = new JButton("RETURN");
        button.setBounds(140, 190, 150, 40);
        button.setFont(labelFont);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //what to do when button is clicked -- call return car method
                returnCar();
            }
        });
        panel.add(button);
        
        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        //success.setText
        frame.add(panel);
        frame.setVisible(true);
    }

    private void returnCar(){
        //get details from the car
        String regNo = regnoText.getText();

        //look up car in the database
        DB db = new DB();
        Car car = db.getCars(regNo);

        //if car is found, details won't be empty
        if ( !car.getMake().isEmpty() ){
            //car found, call return car function in db
            db = new DB();
            if ( db.returnCar(regNo) ){
                //operation successful
                JOptionPane.showMessageDialog(frame, "Car Successfully Returned.", "Successful", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                //something happened when trying to return
                JOptionPane.showMessageDialog(frame, "Something happened, car couldn't be returned. Check error logs..", "Unsuccessful", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            //car details empty, so it wasnt found
            JOptionPane.showMessageDialog(frame, "Incorrect Registration Number. Try Again.", "Car Not Found", JOptionPane.WARNING_MESSAGE);
        }

    }
}
