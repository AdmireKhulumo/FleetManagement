import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUILogin {
    private  JLabel success, passwordLabel,userNameLabel;
    private  JButton button;
    private  JPasswordField passwordLabelText;
    private  TextField userNameText;
    private JLabel loginLabel;
    
    //panel and frame
    //JPanel panel = new JPanel();
   private ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
    private JFrame frame = new JFrame();

    public void create() {

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("LOGIN PAGE");

        panel.setLayout(null);
        
        //define font for subsequent labels smaller
        Font labelFont = new Font("Courier New",Font.PLAIN, 16);
        //define font for titles
        Font titleFont = new Font("Courier New",Font.BOLD, 25);
        
        loginLabel = new JLabel ("LOGIN PAGE");
        loginLabel.setBounds(120, 20, 170, 25);
        loginLabel.setFont(titleFont);
        panel.add(loginLabel);

        userNameLabel = new JLabel("USERNAME");
        userNameLabel.setBounds(20, 70, 80, 25);
        userNameLabel.setFont(labelFont);
        panel.add(userNameLabel);

        userNameText = new TextField(20);
        userNameText.setBounds(130, 70, 170, 30);
        panel.add(userNameText);

        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(20, 120, 80, 25);
        passwordLabel.setFont(labelFont);
        panel.add(passwordLabel);

        passwordLabelText = new JPasswordField();
        passwordLabelText.setBounds(130, 120, 170, 30);
        panel.add(passwordLabelText);

        button = new JButton("LOGIN");
        button.setBounds(120, 165, 110, 40);
        button.setFont(labelFont);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDetails();
            }
        });
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        //add panel to the frame
        frame.add(panel);

        frame.setVisible(true);

    }

    //run when login button is clicked
    public void checkDetails() {
        String user = userNameText.getText();
        String password = passwordLabelText.getText();

        //check if credentials match what's required -- call database method to authenticate user -- returns true if successful
        if ( new DB().authUser(user, password) ) {
            //success.setText("Successfully Logged In!");
            //call index page
            GUIIndexPage indexPage = new GUIIndexPage();
            indexPage.create();

        }
        else{
            //unsuccessful, create error message modal
//            success.setText("Incorrect Details");
            JOptionPane.showMessageDialog(frame, "Incorrect Login Details. Check and try again.", "Login Error", JOptionPane.WARNING_MESSAGE);

        }
    }
}
