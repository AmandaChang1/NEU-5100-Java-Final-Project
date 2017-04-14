package com.neu.jan17.UI;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.TreeSet;

import com.neu.jan17.data.DealerReader;
import com.neu.jan17.data.Dealer;


public class DealerInfoTable extends JFrame {
    JTable table;
    JLabel label;
    Dealer dealer = new Dealer();
    DealerReader dealerReader = new DealerReader();
    TreeSet<String> temp = new TreeSet<>();

    public DealerInfoTable() {
        setSize(1000, 500);
        setLayout(new FlowLayout());

        String[] columnNames = {"NAME", "LANGUAGE", "URL"};
        temp = dealerReader.DealersReader();

        String[][] data = new String[temp.size()][3];
        int i = 0;
        for (String s : temp) {
            data[i] = s.split("\\s+");
            i++;
        }

        label = new JLabel("You could find the most sutiable dealer for you here!");
        table = new JTable();
        table = new JTable(data, columnNames);
        //table.setEnabled(false);


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(new Point(e.getX(), e.getY()));
                int col = table.columnAtPoint(new Point(e.getX(), e.getY()));
                String url = (String) table.getModel().getValueAt(row, col);

                try {
                    URL res = new URL("http://" + url);
                    openWebpage(res);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                int col = table.columnAtPoint(new Point(e.getX(), e.getY()));
                if (col == 2) {
                    table.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                int col = table.columnAtPoint(new Point(e.getX(), e.getY()));
                if (col != 2) {
                    table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });

        add(new JScrollPane(table));

        table.getColumnModel().getColumn(2).setCellRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, final Object value, boolean arg2,
                                                           boolean arg3, int arg4, int arg5) {
                final JLabel lab = new JLabel("<html><a href=\"" + value + "\">" + value + "</a>");
                return lab;
            }
        });


        table.setPreferredScrollableViewportSize(new Dimension(800, 400));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(label);
        add(scrollPane);
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
