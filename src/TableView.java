import java.io.StreamCorruptedException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableView extends JFrame {
	
	public TableView() {
   
        //headers for the table
        String[] columns = new String[] {
            "Id", "Name", "url"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "bmw", "www.nmd.com"},
            {2, "chevrolet", "www.mnc.com" },
            {3, "Audi", "www.xyz.com" },
        };
         
        final Class[] columnClass = new Class[] {
            Integer.class, String.class, String.class
        };
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
        };
         
        JTable table = new JTable(model);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableView();
            }
        });
    }   

}
