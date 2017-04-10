package FinalProject;

import java.awt.*;

import javax.swing.*;

public class DealerInfoTable extends JFrame {
	JTable table;
	JLabel label;
	
	public DealerInfoTable() {
		setLayout(new FlowLayout());
		
		String[] columnNames = {"NAME","LOCATION","LANGUAGE","URL"};
		
		//change these dates to the real dates that Professor has given to us
		Object[][] data = {
				{"1 Dealer","Seattle","en","http://"},
				{"2 Dealer","Seattle","en","http://"},
				{"3 Dealer","Seattle","en","http://"},
				
		};
		
		label = new JLabel("You could find the most sutiable dealer for you here!");
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,500));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(label);
		add(scrollPane);
	}
	
	public static void main (String args[]) {
		DealerInfoTable gui = new DealerInfoTable();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(600,600);
		gui.setVisible(true);
		gui.setTitle("Find your Appropriate Dealer");		
	}

}
