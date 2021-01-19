import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDeleteCar {

    JTextField tfRegNo;
    JLabel lblSuccess;
    JFrame frame;

    public void create(){
        //create new frame
        frame = new JFrame("DELETE CAR");
        frame.setSize(300,200);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create JPanel to house components -- Grid bag layout
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
        panel.setLayout(new GridBagLayout());

        //grid bag constraints variable to edit layout features
        GridBagConstraints gbc;
        //font to use accross UI
        //define font for subsequent labels
        Font labelFont = new Font("Courier New",Font.PLAIN, 14);


        //create label  instruction
        JLabel lblMessage = new JLabel("Enter Registration Number Below:");
        lblMessage.setFont(labelFont);
        gbc = createGbc(0,0);
        gbc.gridwidth = 2;
        panel.add(lblMessage, gbc);

        //edit input field
        tfRegNo = new JTextField();
        tfRegNo.setBounds(10, 20, 100, 50);
        gbc = createGbc(0,1);
        gbc.gridwidth=2;
        gbc.ipady = 10;
        //gbc.weighty = 20;
        panel.add(tfRegNo, gbc);

        //message to display when successful or not -- initially has nothing
        lblSuccess = new JLabel();
        lblSuccess.setFont(new Font("Courier New", Font.ITALIC, 12));
        gbc = createGbc(0,2);
        gbc.gridwidth=2;
        panel.add(lblSuccess, gbc);

        //cancel button
        JButton btnCancel = new JButton("CANCEL");
        gbc = createGbc(0,3);
        gbc.gridwidth=1;
        //add button to perform cancelling functionality
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set frame's visibility to false, i.e make UI dissappear
                frame.setVisible(false);
            }
        });
        panel.add(btnCancel, gbc);

        //delete button
        JButton btnDelete = new JButton("DELETE");
        gbc = createGbc(1,3);
        gbc.gridwidth = 1;
        //add button to perform deleting functionality
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //call function to delete
                deleteCar();
            }
        });
        panel.add(btnDelete, gbc);


        //add panel to frame
        frame.add(panel);
        //make frame visible
        frame.setVisible(true);
    }

    //function called when delete button is pressed
    private void deleteCar(){
        //get input from text field
        String regNo = tfRegNo.getText();

        //check if car exists in the database by attempting to get its details
        DB db = new DB();
        Car car = db.getCars(regNo);

        //if car object is empty, i.e has no make, model etc, then it wasnt found
        if (car.getMake().isEmpty()){
            //shpw dialogue indicating result
            JOptionPane.showMessageDialog(frame, "Car " + regNo + " Does Not Exist. \nPlease check the Registration Number and try again.", "Car Not Found", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //car found. Show details in options so user can confirm
            //create a decorated jDialogue
            JDialog.setDefaultLookAndFeelDecorated(true);

            //message to display
            String message = "Are you sure you want to delete the following car: " + car.toString();
            //
            int response = JOptionPane.showConfirmDialog(frame, message, "Confirm Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //if no is clicked..
            if (response == JOptionPane.NO_OPTION) {
                //no button clicked, set label to not deleted
                lblSuccess.setText("Car not deleted.");
            } else if (response == JOptionPane.YES_OPTION) {
                //yes button clicked, proceed to delete the car
                db = new DB(); //re intialise because connection was closed after last execution

                //call delete car method -- returns true if successful
                if (db.deleteCar(regNo) ){
                    //car successfully deleted
                    lblSuccess.setText("Successfully deleted.");
                }
                else{
                    //something wrong must have happened, set success label to reflect that
                    lblSuccess.setText("Something happened. Delete unsuccessful.");
                }

            }

        }

    }


    //function to easily create gbc varible with certain properties -- x and y
    private GridBagConstraints createGbc(int x, int y){
        //create internal gbc variable
        GridBagConstraints gbc = new GridBagConstraints();
        //fill with horizontal layout
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //use input x to set gbc x value
        gbc.gridx = x;
        //use input y to set gbc y variable
        gbc.gridy = y;

        //return formatted gbc
        return gbc;
    }
}
