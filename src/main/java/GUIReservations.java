import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUIReservations {

    private ArrayList<Reservation> reservations;
    private JTable table;

    public void create(){
        //create frame and set dimensions
        JFrame frame = new JFrame("CAR RESERVATIONS");
        frame.setSize(900,400);

        //create panel and set layout to gridbag
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/images/bkg.jpg").getImage());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //title
        JLabel lblTopic = new JLabel("Reservations");
        lblTopic.setFont(new Font("Courier New",Font.BOLD, 25));
        lblTopic.setSize(250, 40);
        panel.add(lblTopic);

        //TABLE
        //get reservations from db
        reservations = new DB().getReservations();

        //table column Names
        String[] columnNames = {"#" ,"Reg.No", "First Name", "Surname", "ID", "Phone", "Address" };
        //create 2D array for storing car object data -- dimensions are [number of reservations, 7 fields]
        String[][] data = new String[reservations.size()][7];

        //loop through reservations array list, move data to the data array accordingly
        for (int row=0; row<reservations.size(); row++){
            //get car from cars array -- use row index since it directly relates to the row iterator
            Reservation res = reservations.get(row);

            //row number
            data[row][0] = Integer.toString(row+1);
            //set car registration number
            data[row][1] = res.getRegNo();
            //set person first name
            data[row][2] = res.getFname();
            //set person last name
            data[row][3] = res.getSname();
            //set person id -- type cast to string since array is string type
            data[row][4] = Integer.toString(res.getId());
            //set person phone
            data[row][5] = res.getPhone();
            //set person address
            data[row][6] = res.getAddress();
        }

        //initializing the JTable -- and setting the table properties
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 700, 50);
        table.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        table.setShowGrid(true);
        table.setRowMargin(2);
        table.setGridColor(java.awt.Color.ORANGE);
        //table.setRowSelectionAllowed(true);
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
        //add item to the panel
        panel.add(scrollPane);

        //label for when no reserved cars exist
        if (reservations.size() == 0){
            //no cars were found, create label
            JLabel lblNF = new JLabel("No Reserved cars in the database.");
            lblNF.setFont(new Font("Courier New",Font.ITALIC, 12));
            panel.add(lblNF);
        }

        //add panel to frame, set it to visible
        frame.add(panel);
        frame.setVisible(true);
    }

    //function to display car details when clicked on the table
    private void tableClicked(int row){
        //row corresponds directly with index on reservations array list -- get that reservation object
        Reservation res = reservations.get(row);

        //use contained car details to create a car object
        Car car = new Car(res.getMake(), res.getModel(), res.getRegNo(), res.getYear(), res.getAvailable(), res.getUrl());

        //display the car
        GUIDisplayCar dc = new GUIDisplayCar();
        dc.create(car);
    }
}
