import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUIIndexPage {

    private JTextField tfSearch = new JTextField(15);
    private JFrame frame = new JFrame("FLEET MANAGEMENT SYSTEM");
    private JTable table;
    //stores all cars from db
    private ArrayList<Car> carsArray;

    public void create() {
        //create frame and set dimensions
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        
        //main and only panel
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
        panel.setLayout(new GridBagLayout());
        panel.setSize(900,700);
        
        //grid bag constraints variable to control coordinates and properties of each "cell"
        GridBagConstraints gbc = new GridBagConstraints();
        //font for small labels
        Font labelFont = new Font("Courier New",Font.BOLD, 16);
        
        //ROW 1
        //search label
        JLabel lblFind = new JLabel("FIND CAR: ");
        lblFind.setFont(labelFont);
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        gbc.insets = new Insets(0,10,0,10);
        //add item to the panel
        panel.add(lblFind, gbc);
        
        //search text field
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        gbc.ipady = 10;
        //add item to the panel
        panel.add(tfSearch, gbc);
        
        //search button
        JButton btnSearch = new JButton("SEARCH");
        //add onCLick method
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //call method to search a car
                searchCar();
            }
        });
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //add item to the panel
        panel.add(btnSearch, gbc);
        
        //sign out button
        JButton btnSignOut = new JButton("Logout");
        //action for when button is clicked
        btnSignOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete index page by calling setting frame to invisible
                frame.setVisible(false);
            }
        });
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=4;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //add item to the panel
        panel.add(btnSignOut, gbc);
        
        //ROW 2 -- TABLE

        //create new panel to store all cars in a list
        JPanel carsPanel = new JPanel();
        //create db object and get list of cars
        DB db = new DB();
        //call get cars method, and store in an array list
        carsArray = db.getCars();
        carsPanel.setLayout(new BoxLayout(carsPanel, BoxLayout.Y_AXIS));

        //table column Names
        String[] columnNames = {"#" ,"CAR MAKE", "CAR MODEL", "REGISTRATION No.", "YEAR", "AVAILABILITY" };
        //create 2D array for storing car object data
        String[][] data = new String[carsArray.size()][6];

        //loop through cars array list, move data to the data array accordingly
        for (int row=0; row<carsArray.size(); row++){
            //get car from cars array -- use row index since it directly relates to the row iterator
            Car car = carsArray.get(row);

            //row number
            data[row][0] = Integer.toString(row+1);
            //set car make
            data[row][1] = car.getMake();
            //set car model
            data[row][2] = car.getModel();
            //set registration number
            data[row][3] = car.getRegNo();
            //set year -- type cast to string since array is string type
            data[row][4] = Integer.toString(car.getYear());
            //set availability
            data[row][5] = car.getAvailable();
        }

        //initializing the JTable -- and setting the table properties
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 50);
        table.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        table.setShowGrid(true);
        table.setRowMargin(2);
        table.setGridColor(java.awt.Color.ORANGE);
        table.setRowSelectionAllowed(true);
        //make table clickable
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //store value of row clicked
                int row=table.rowAtPoint(e.getPoint());

                //call method to handle row clicked
                tableClicked(row);
            }
        });

        //create a scroll pane, feed with jtable
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        
        //set scroll pane coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth = 5;
        gbc.gridheight=1;
        gbc.insets = new Insets(30,0,30,0);
        //add item to the panel
        carsPanel.add(scrollPane);
        panel.add(carsPanel, gbc);
        
        //ROW 3 -- navigation buttons
        //reset gbc
        gbc = new GridBagConstraints();

        //add car button
        JButton btnAddCar = new JButton("Add Car");
        //add onClick method to call up Ass Car GUI when clicked
        btnAddCar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //open Add Car GUI
                GUIAddCar ac = new GUIAddCar();
                ac.create();
            }
        });
        //set coordinates
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //for padding
        gbc.insets = new Insets(0,10,0,10);
        //add item to the panel
        panel.add(btnAddCar, gbc);
        
        //delete car button
        JButton btnDeleteCar = new JButton("Delete Car");
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //add button functionality -- use lambda expression
        btnDeleteCar.addActionListener( e ->{
            //intialise deleting UI
            new GUIDeleteCar().create();
        });
        //add item to the panel
        panel.add(btnDeleteCar, gbc);
        
        //reserve car button
        JButton btnReserveCar = new JButton("Reserve Car");
        //onClick method for reserving a car -- calls BorrowCarGUI
        btnReserveCar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //create new BorrowCar GUI
                GUIReserveCar rc = new GUIReserveCar();
                rc.create();
            
            }
           
        });
        //set coordinates
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //add item to the panel
        panel.add(btnReserveCar, gbc);
        
        
        //return car button
        JButton btnReturnCar = new JButton("Return Car");
        btnReturnCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create object of return car class
                GUIReturnCar rc = new GUIReturnCar();
                //call create method to startup the GUI
                rc.create();
            }
        });
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=3;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //add item to the panel
        panel.add(btnReturnCar, gbc);

        //Show Reservations  button
        JButton btnShowReservations = new JButton("Show Reservations");
        btnShowReservations.addActionListener(e -> {
            //open the reservations UI
            GUIReservations r = new GUIReservations();
            r.create();
        });
        //set coordinates
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=4;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        gbc.gridheight=1;
        //add item to the panel
        panel.add(btnShowReservations, gbc);

        frame.add(panel);
        frame.setVisible(true);
        
    }

    //function to search for a cra in the database
    private void searchCar(){
        //get car regNo from search text field
        String regNo = tfSearch.getText();

        //look up car in the database
        DB db = new DB();
        Car car = db.getCars(regNo);

        //if car is found, call GUIDisplay car class, supply car details
        if ( !car.getMake().isEmpty() ){
            //car found, call car display, send car object
            GUIDisplayCar displayCar = new GUIDisplayCar();
            displayCar.create(car);
        }else{
            //car not found
            System.out.println("Car does not exist.");
            //show modal with information
            JOptionPane.showMessageDialog(frame, "Car Does Not Exist. \nPlease check the Registration Number and try again.", "Car Not Found", JOptionPane.WARNING_MESSAGE);
        }

    }

    //function to display car details when clicked on the table
    private void tableClicked(int row){
        //row corresponds directly with index on cars array list -- get that car object
        Car car = carsArray.get(row);
        //display the car
        GUIDisplayCar dc = new GUIDisplayCar();
        dc.create(car);
    }
}
