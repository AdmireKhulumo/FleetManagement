//GROUP 1

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionListener;
import javax.swing.*;
//import javax.swing.ListModel;

public class GUIReserveCar {
    private JLabel personLabel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel sNameLabel;
    private JTextField sNameText;
    private JLabel idLabel;
    private JTextField idText;
    private JLabel addressLabel;
    private JTextField addressText;
    private JLabel phoneLabel;
    private JTextField phoneText;    
    private JLabel chooseLabel;
    private JLabel carLabel;
    private JLabel regLabel;
    private JTextField regText;
    private JLabel makeLabel;
    private JTextField makeText;
    private JLabel modelLabel;
    private JTextField modelText;
    private JLabel yearLabel;
    private JTextField yearText;
    private JLabel success;
    private JButton reserveButton;

    //the layout for what is going to be placed on it
    ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
    //the window
    JFrame frame = new JFrame("RESERVE CAR");

    public void create() {

        frame.setSize(400, 500);
        //put the panel on the frame
        frame.add(panel);
        //close application when X is clicked
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //configure the panel
        panel.setLayout(null);//rows columns etc

        //define font for subsequent labels smaller
        Font labelFont = new Font("Courier New",Font.PLAIN, 16);
        //define font for titles
        Font titleFont = new Font("Courier New",Font.BOLD, 25);

        //create label "personal details"
        personLabel = new JLabel("PERSONAL DETAILS");
        personLabel.setBounds(10, 20, 250, 25);
//        personLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        personLabel.setFont(titleFont);
        panel.add(personLabel);

        //create label "FirstName"
        nameLabel = new JLabel("FirstName(s)");
        nameLabel.setBounds(10, 50, 150, 25);
//        nameLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        nameLabel.setFont(labelFont);
        panel.add(nameLabel);
        //create text field for inputing user FirstNames
        nameText = new JTextField(20);
        nameText.setBounds(150, 50, 200, 25);
        panel.add(nameText);

        //create label "Surname"
        sNameLabel = new JLabel("Surname");
        sNameLabel.setBounds(10, 80, 120, 25);
//        sNameLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        sNameLabel.setFont(labelFont);
        panel.add(sNameLabel);
        //create text field for inputing user surname
        sNameText = new JTextField(20);
        sNameText.setBounds(150, 80, 200, 25);
        panel.add(sNameText);

        //create label for ID
        idLabel = new JLabel("ID");
        idLabel.setBounds(10, 110, 75, 25);
//        idLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        idLabel.setFont(labelFont);
        panel.add(idLabel);
        //create text field for inputing user ID
        idText = new JTextField(20);
        idText.setBounds(150, 110, 200, 25);
        panel.add(idText);
        
        //create label for address
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(10, 140, 75, 25);
//        addressLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        addressLabel.setFont(labelFont);
        panel.add(addressLabel);
        //create text field for inputing the car year
        addressText = new JTextField(20);
        addressText.setBounds(150, 140, 200, 25);
        panel.add(addressText);

        //create label for phone label
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(10, 170, 75, 25);
//        phoneLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        phoneLabel.setFont(labelFont);
        panel.add(phoneLabel);
        //create text field for inputting the ID
        phoneText = new JTextField(20);
        phoneText.setBounds(150, 170, 200, 25);
        panel.add(phoneText);

//        //create label for choose a car of your choice
//        chooseLabel = new JLabel("Choose a car of your choice");
//        chooseLabel.setBounds(10, 210, 500, 25);
//        chooseLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
//        panel.add(chooseLabel);

        //create label for car details
        carLabel = new JLabel("CAR DETAILS");
        carLabel.setBounds(10, 230, 200, 25);
//        carLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        carLabel.setFont(titleFont);
        panel.add(carLabel);

        //create label for regNo.
        regLabel = new JLabel("Reg.No");
        regLabel.setBounds(10, 270, 60, 25);
//        regLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        regLabel.setFont(labelFont);
        panel.add(regLabel);
        //create text field for inputing the car regNo.
        regText = new JTextField(20);
        regText.setBounds(150, 270, 200, 25);
        panel.add(regText);

        //create label for car make 
        makeLabel = new JLabel("Car Make");
        makeLabel.setBounds(10, 300, 100, 25);
//        makeLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        makeLabel.setFont(labelFont);
        panel.add(makeLabel);
        //create text field for inputing the car make
        makeText = new JTextField(20);
        makeText.setBounds(150, 300, 200, 25);
        panel.add(makeText);

        //create label for car model
        modelLabel = new JLabel("Car Model");
        modelLabel.setBounds(10, 330, 100, 25);
//        modelLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        modelLabel.setFont(labelFont);
        panel.add(modelLabel);
        //create text field for inputing the car model
        modelText = new JTextField(20);
        modelText.setBounds(150, 330, 200, 25);
        panel.add(modelText);

        //create label car year
        yearLabel = new JLabel("Car Year");
        yearLabel.setBounds(10, 360, 100, 25);
//        yearLabel.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
        yearLabel.setFont(labelFont);
        panel.add(yearLabel);
        //create text field for inputing the car year
        yearText = new JTextField(20);
        yearText.setBounds(150, 360, 200, 25);
        panel.add(yearText);

        //Creating reserve button
        reserveButton = new JButton("RESERVE");
        reserveButton.setBounds(100, 410, 200, 25);
        reserveButton.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 16));
      //add action listener to that button -- spin up an anonymous class of type ActionListener (gives it the ability to listen to clicks, swipes etc
        reserveButton.addActionListener(new ActionListener(){
            
            //override method to do a certain action when the button is clicked
            @Override
            public void actionPerformed(ActionEvent e){
                //whatever I wanna do
                //call the function to reserve a car
                reserveCar();
            }
        });
        panel.add(reserveButton);
        
//        success.setFont(new Font(Font.SERIF, Font.HANGING_BASELINE, 16));
        success = new JLabel();
        success.setBounds(10, 450, 500, 25);
        panel.add(success);

        frame.setVisible(true);
    }
    
    public void reserveCar() {
        String regNo = regText.getText();
        String fName = nameText.getText();
        String sName = sNameText.getText();
        String id = idText.getText();
        String address = addressText.getText();
        String phone = phoneText.getText();

        //check if this car is available
        //instantiate db
        DB db = new DB();

        //call getCar
        Car car = db.getCars(regNo);

        //check if car is empty
        if ( car.getModel().isEmpty() ){
            //show modal saying car doesnt exist
            JOptionPane.showMessageDialog(frame,"Registration number does not match any car. Please check and try again.", "Invalid Registration Number", JOptionPane.WARNING_MESSAGE);
        }
        else if( car.getAvailable().equals("N") ){
            //if car exists but is not available, set modal with appropriate info
            JOptionPane.showMessageDialog(frame,"Car is not available. Please try another one", "Car Not Available", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //car is available, reserve it
            db = new DB(); //reopen object incase closed

            //call reserve method from db
            if(db.reserveCar(regNo, id, fName, sName,phone, address)){
                //reservation successful
                //show modal saying the car has been reseved.
                JOptionPane.showMessageDialog(frame,"Car Reserved, details below:" + car.toString(), "Car Reserved", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                //reservation unsuccessful, show modal
                JOptionPane.showMessageDialog(frame,"Something Went Wrong. Check the error logs and try again.", "Reservation Failed", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }
}
