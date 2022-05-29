package PhoneBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

//Data Table
public class DataPanel extends JPanel implements AppLayout {
    private JTable table;

    public DataPanel() {
        DefaultTableModel model = new DefaultTableModel();
        String[] headers = {"","","",""};
        model.setColumnIdentifiers(headers);
        table = new JTable(model);

    }

    @Override
    public JPanel panelUI() {
        setBackground(new Color(0,0,0,0));
        table.setSelectionBackground(Color.RED);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32,136,203));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.getTableHeader().setOpaque(false);
        table.getRowHeight(25);
        setBorder(BorderFactory.createTitledBorder("Name:"));
        JScrollPane scrollPane =new JScrollPane(table);
        add(scrollPane);

        return this;
    }

    public DefaultTableModel getModel(){
        return (DefaultTableModel) getTable().getModel();
    }

    public  JTable getTable(){
        return table;
    }
}
