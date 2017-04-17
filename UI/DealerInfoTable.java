package com.neu.jan17.UI;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import com.neu.jan17.data.DealerData;
import com.neu.jan17.data.Dealer;
import com.neu.jan17.data.UrlHandle;


public class DealerInfoTable extends JFrame {
    private JTable table;
    private JLabel label;
    private Dealer dealer = new Dealer();
    private DealerData dealerData = new DealerData();
    private UrlHandle urlHandle = new UrlHandle();


    public DealerInfoTable() {
        setSize(1000, 500);
        setLayout(new FlowLayout());
        String[] columnNames = {"NAME", "LANGUAGE", "URL"};
        Dealer[] dealersInfo = dealerData.getDealersData();
        String[][] dealersInfoArr = new String[dealersInfo.length][3];
        for(int i = 0; i < dealersInfo.length; i++){
            dealersInfoArr[i][0] = dealersInfo[i].getId();
            dealersInfoArr[i][1] = dealersInfo[i].getLocation();
            dealersInfoArr[i][2] = dealersInfo[i].getUrl();
        }
        label = new JLabel("You could find the most sutiable dealer for you here!");
        table = new JTable();
        table = new JTable(dealersInfoArr, columnNames);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(new Point(e.getX(), e.getY()));
                int col = table.columnAtPoint(new Point(e.getX(), e.getY()));
                String url = (String) table.getModel().getValueAt(row, col);

                try {
                    URL res = new URL("http://" + url);
                    urlHandle.openWebpage(res);
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

}
