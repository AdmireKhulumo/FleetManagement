//packages to import
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
    //frame 
    JFrame frame;
    //table 
    JTable table;

    //constructor 
    Table() { }

    public void create(){

        //frame initiallization
        frame = new JFrame();

        //the frame Title
        frame.setTitle("Availability of Cars");

        //the data to be displayed in the JTable
        String[][] data = {
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" },
                { "Mercedes Benz", "C43AMG", "B420BAE", "2020", "Y" }
        };

        //table column Names
        String[] columnNames = { "Car Make", "Car Model", "Registration No.", "Year", "Availability" };

        //initializing the JTable -- and setting the table properties
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        table.setShowGrid(true);
        table.setRowMargin(1);
        table.setGridColor(java.awt.Color.ORANGE);
        table.setRowSelectionAllowed(true);

        //add the table to JScrollPane
        JScrollPane panel = new JScrollPane(table);
        frame.add(panel);
        //set the frame Size
        frame.setSize(500, 200);
        //set the frame visibility to true
        frame.setVisible(true);
    }

}