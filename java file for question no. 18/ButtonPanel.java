package PhoneBook;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel implements AppLayout {
    private GridBagConstraints layout;
    private JButton btnClear, btnSearch, btnAdd, btnRemove;

    public ButtonPanel(){
        setLayout(new GridBagLayout());
        layout = new GridBagConstraints();
        btnClear = new JButton("Clear");
        btnSearch = new JButton("Search");
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
    }
    //Button Layout
    @Override
    public JPanel panelUI() {
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.ipadx = 150;
        layout.ipady = 90;

        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridwidth = 1;
        add(btnClear,layout);

        layout.gridx = 1;
        layout.gridy = 0;
        add(btnSearch,layout);

        layout.gridx = 0;
        layout.gridy = 1;
        add(btnAdd,layout);

        layout.gridx = 1;
        layout.gridy = 1;
        add(btnRemove,layout);
        return this;
    }

    public JButton getBtnClear(){
        return btnClear;
    }

    public JButton getBtnSearch(){
        return btnSearch;
    }

    public JButton getBtnAdd(){
        return  btnAdd;
    }

    public JButton getBtnRemove(){
        return btnRemove;
    }

}
