import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class GUIAddCar {

    //create a java frame(window) to hold the layout view
    JFrame frame = new JFrame();

    //instance variables to store input data
    String model ="";
    String make = "";
    JComboBox cbMake = new JComboBox();
    JComboBox cbModel = new JComboBox();
    JTextField tfYear = new JTextField(25);
    JTextField tfRegNo = new JTextField(25);
    JTextField tfUrl =  new JTextField(25);

    //to store jsonArray of cars
    JSONArray jsonMakeArray, jsonModelArray;

    //label to display result of adding car to fleet: success or failed
    JLabel lblResult = new JLabel("");

    public void create(){

        //start by preparing car makes json object
        String jsonSource = "/car-list.json";
        InputStream inputStream = GUIAddCar.class.getResourceAsStream(jsonSource);
        if (inputStream == null) {
            throw new NullPointerException("Cannot find resource file " + jsonSource);
        }

        JSONTokener tokener = new JSONTokener(inputStream);
        //get contents into an array
        jsonMakeArray = new JSONArray(tokener);

        //create ArrayList to store all makes
        ArrayList<String> makeArray = new ArrayList<String>();

        //loop through array, for each entry, create a json object and pick up the model name.
        for (int i = 0; i < jsonMakeArray.length(); i++) {
            //get make name from current json object
            String make = jsonMakeArray.getJSONObject(i).getString("brand");
            //add make name to the make arrayList
            makeArray.add(make);
        }

        //sort list, assign to make combo box
        Collections.sort(makeArray);
        //add default value select make to beginning of sorted makeArray
        makeArray.add(0,"Select Make");
        cbMake = new JComboBox(makeArray.toArray());
        cbModel.addItem("Select Model");

        //when a make is clicked, it must set the array for model to all models of that make
        cbMake.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            @Override
            public void itemStateChanged(ItemEvent event) {
                //check if the state of the combobox has changed
                if (event.getStateChange() == ItemEvent.SELECTED){

                    //store value
                    String make = cbMake.getSelectedItem().toString();
                    //update make instance variable
                    setMake(make);

                    //check if default value in not the one selected
                    if(!make.equals("Select Make")){
                        //print selected make
                        System.out.println(make);

                        //set values for the model based on the chosen make
                        //variable to hold make array
                        //loop through JSon Make Array to find matching object
                        for (int i = 0; i < jsonMakeArray.length(); i++) {

                            //check is current make matches
                            if (jsonMakeArray.getJSONObject(i).getString("brand").equals(make)){

                                //create a model array from list of models of that make
                                jsonModelArray = jsonMakeArray.getJSONObject(i).getJSONArray("models");

                                //clear models selector, to remove items that were there before
                                cbModel.removeAllItems();

                                //java array population
                                for (int j=0; j<jsonModelArray.length(); j++){
                                    //add model to the combobox
                                    cbModel.addItem(jsonModelArray.get(j).toString());
                                }
                            };
                        }
                    }
                    else{
                        //changed back to select make, so clear models list
                        cbModel.removeAllItems();
                        cbModel.addItem("Select Model");
                    }
                }
            }
        });
        //code for when a model is clicked
        cbModel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                //check if the state of the combobox has changed
                if (event.getStateChange() == ItemEvent.SELECTED){

                    //store value
                    String model = cbModel.getSelectedItem().toString();
                    //update make instance variable
                    setModel(model);
                    System.out.println(model);
                }
            }
        });

        //set frame dimensions, and make sure it exists when closed.
        frame.setSize(450, 500);
        frame.setTitle("Add Car To Fleet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add panel to frame
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
        //JPanel panel = new JPanel();
        frame.add(panel);

        //DESIGN PANEL

        //set layout to a gridbag - similar to grid but with less restrictions
        panel.setLayout(new GridBagLayout());

        //choose constraints for the grid bag layout
        GridBagConstraints gbc = new GridBagConstraints();

        //set layout to horizontal two items


        //TOPIC
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy=0;
        gbc.gridwidth = 2;
        JLabel lblTopic = new JLabel("ADD CAR DETAILS");
        lblTopic.setFont(new Font("Courier New",Font.ITALIC, 40));
        panel.add(lblTopic, gbc);

        //define font for subsequent labels
        Font labelFont = new Font("Courier New",Font.PLAIN, 16);

        //MAKE
        //add make label taking at (x0,y0)
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel lblMake = new JLabel("MAKE:");
        lblMake.setFont(labelFont);
        panel.add(lblMake, gbc);

        //add text box to collect make information and (x1,y0), length is 25 characters
        gbc.gridx = 1;
        gbc.gridy= 1;
        gbc.gridwidth = 1;
//        panel.add(tfMake, gbc);
        panel.add(cbMake, gbc);

        //MODEL
        //add model label taking at (x0,y1)
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JLabel lblModel = new JLabel("MODEL:");
        lblModel.setFont(labelFont);
        panel.add(lblModel,gbc);

        //add text box to collect model information and (x1,y1), length is 25 characters
        gbc.gridx = 1;
        gbc.gridy= 2;
        gbc.gridwidth = 1;
//        panel.add(tfModel,gbc);
        panel.add(cbModel, gbc);

        //YEAR
        //add model label taking at (x0,y2)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        JLabel lblYear = new JLabel("YEAR:");
        lblYear.setFont(labelFont);
        panel.add(lblYear,gbc);

        //add text box to collect model information and (x1,y2), length is 25 characters
        gbc.gridx = 1;
        gbc.gridy= 3;
        gbc.gridwidth = 1;
            panel.add(tfYear,gbc);

        //REGNO
        //add model label taking at (x0,y3)
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        JLabel lblRegNo = new JLabel("Reg. No:");
        lblRegNo.setFont(labelFont);
        panel.add(lblRegNo,gbc);

        //add text box to collect model information and (x1,y3), length is 25 characters
        gbc.gridx = 1;
        gbc.gridy= 4;
        gbc.gridwidth = 1;
        panel.add(tfRegNo,gbc);

        //URL
        //add model label taking at (x0,y4)
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        JLabel lblUrl = new JLabel("Image URL:");
        lblUrl.setFont(labelFont);
        panel.add(lblUrl,gbc);

        //add text box to collect model information and (x1,y5), length is 25 characters
        gbc.gridx = 1;
        gbc.gridy= 5;
        gbc.gridwidth = 1;
        panel.add(tfUrl,gbc);

        //ADD CAR BUTTON
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy= 6;
        gbc.ipady = 20;
        //gbc.ipadx = 100;
        gbc.gridwidth = 2;
        JButton btnAddCar = new JButton("ADD CAR");
        btnAddCar.setFont(new Font("Courier New",Font.PLAIN, 20));

        //add action listener: use an anonymous inner class that calls the relevant function when button is clicked
        btnAddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method to call
                addCar();
            }
        });
        //add button to panel
        panel.add(btnAddCar,gbc);

        //Successful addition label
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy= 7;
        gbc.gridwidth = 2;
        lblResult.setFont(new Font("Courier New",Font.BOLD, 20));
        panel.add(lblResult,gbc);

        //Back Button -- text shows page on top of stack, i.e previous page
        JLabel lblBack = new JLabel("<-- Back To " + Navigation.top().toUpperCase() + " Page");
        lblBack.setFont(labelFont);
        lblBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblBack.setForeground(Color.BLUE);
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                goBack();
            }
        });
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth = 2;
        gbc.gridheight=1;
        gbc.insets = new Insets(20,0,0,0);
        panel.add(lblBack, gbc);

        //make frame visible
        frame.setVisible(true);
    }

    //method called when addCar button is clicked, adds car to fleet
    private void addCar() {

        try{
            //get values from text fields
            int year = Integer.parseInt(tfYear.getText());
            String regNo = tfRegNo.getText();
            String url ="src/main/resources/images/mercedes-c43.jpg";

            //if url is supplied, change the url
            System.out.println("url is " + tfUrl.getText());
            if (tfUrl.getText() != null){
                url = tfUrl.getText();
            }

            //output this data
            System.out.println(make + " " + model + " " + year + " " + " " + regNo);

            //String make, String model, String regNo, int year, String available ,String url
            Car car = new Car(make, model,  regNo, year, "N",url);

            //update database
            DB db = new DB();

            if ( db.addCar(car) ){
                //update success label to successful
                lblResult.setText("Successful!");
            }
            else {
                //update success label to faied
                lblResult.setText("Failed. Try Again!");
            }

        }catch(Exception ex){
            //update label to failed
            lblResult.setText("Failed.");
            System.out.println( ex.getMessage());
            ex.printStackTrace();
        }finally {
            System.out.println("Process complete.");
        }

    }

    //setters for make and model
    public void setMake(String make){this.make = make;}
    public void setModel(String model){this.model = model;}

    //method to update navigation stack before moving forward
    private void updateStack(){
        //close current view
        this.frame.setVisible(false);
        //add index to navigation stack
        Navigation.forward("index");
    }

    //method to go to previous page
    private void goBack(){
        //go to previous page
        Navigation.back();

        //close this current
        this.frame.setVisible(false);
    }
}
