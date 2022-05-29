package PhoneBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MyApp extends JFrame {
    JMenuBar menuBar;
    DataPanel dataPanel;
    InfoPanel infoPanel;
    FileAs fileAs;
    ButtonPanel buttonPanel;
    MyApp self = this;
    UserRegistration reg;
    //App Frame
    public MyApp() {
        setVisible(true);                                   //To visualized the frame
        setResizable(false);                                //User can not change the size of the frame
        setTitle("Phone Book");                             //Adding Title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // closing all the process when user exit
        menuBar = new JMenuBar();
        dataPanel = new DataPanel();
        reg = new UserRegistration();

        infoPanel = new InfoPanel();
        fileAs = new FileAs();
        buttonPanel = new ButtonPanel();
        setJMenuBar(getMenu());
        add(appLayout());
        
        pack();                                             //To open in optimized size
        setLocationRelativeTo(null);                        //Making interactive with user
        addTableData();
        search();
        removeData();
        clearField();
    }

    //App Layout
    private JPanel appLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        layout.fill = GridBagConstraints.BOTH;

        layout.gridx=3;
        layout.gridy=3;

        layout.gridx=1;
        layout.gridy=0;
        mainPanel.add(infoPanel.panelUI(),layout);

        layout.gridx = 1;
        layout.gridy = 1;
        mainPanel.add(fileAs.panelUI(),layout);

        layout.gridx = 1;
        layout.gridy = 2;
        mainPanel.add(buttonPanel.panelUI(),layout);

        layout.weighty = 0.5;
        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridheight=3;
        mainPanel.add(dataPanel.panelUI(),layout);

        return mainPanel;
    }

    //MenuBar
    private JMenuBar getMenu() {
        //Creating MenuBar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(editMenu);
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(helpMenu);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        //File Menu
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

        //Edit Menu
        JMenuItem clear = new JMenuItem("Clear");

        //Clear Button shortcut key and its action listener
        clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_DOWN_MASK));
        clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clearBtn = buttonPanel.getBtnClear();
                    clearBtn.doClick();
                }
            });
        JMenuItem search = new JMenuItem("Search");

        //Search Button shortcut key and its action listener
        search.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton searchBtn = buttonPanel.getBtnSearch();
                    searchBtn.doClick();
                }
            });
        JMenuItem add = new JMenuItem("Add");

        //Add Button shortcut key and its action listener
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK));
        add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton addBtn = buttonPanel.getBtnAdd();
                    addBtn.doClick();
                }
            });
        JMenuItem remove = new JMenuItem("Remove");

        //Remove Button shortcut key and its action listener
        remove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton removeBtn = buttonPanel.getBtnRemove();
                    removeBtn.doClick();
                }
            });

        //Help Menu
        JMenuItem about = new JMenuItem("About");

        //About Button shortcut key and its action listener
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_DOWN_MASK));
        about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(self,"It is still in trial version!!","Information",JOptionPane.INFORMATION_MESSAGE);
                }
            });
        fileMenu.add(exit);
        editMenu.add(clear);
        editMenu.add(search);
        editMenu.addSeparator();
        editMenu.add(add);
        editMenu.add(remove);
        helpMenu.add(about);

        return menuBar;
    }

    private void addTableData(){
        DefaultTableModel model = dataPanel.getModel();
        JButton addBtn = buttonPanel.getBtnAdd();
        JRadioButton sfName = fileAs.getSfName();
        JButton clearBtn = buttonPanel.getBtnClear();
        fileAs.getFsName().setSelected(true);

        addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String firstName =  infoPanel.getFirstName().getText().trim();
                    String lastName = infoPanel.getLastName().getText().trim();
                    String phoneNumber = infoPanel.getPhoneNo().getText().trim();
                    String privateCheckBox = infoPanel.getPrivateCheckBox().isSelected() ? "Private" : "";

                    //Showing Pup up notification or Warning message to the user
                    if(firstName.isEmpty() && lastName.isEmpty() && phoneNumber.isEmpty() || firstName.isEmpty() && lastName.isEmpty() || firstName.isEmpty() && phoneNumber.isEmpty() || lastName.isEmpty() && phoneNumber.isEmpty() ){
                        JOptionPane.showMessageDialog(self,"Please complete the above fields.","Warning",JOptionPane.WARNING_MESSAGE);
                    } else if(firstName.isEmpty()){
                        JOptionPane.showMessageDialog(self,"Enter your first name.","Warning",JOptionPane.WARNING_MESSAGE);
                    } else if(lastName.isEmpty()){
                        JOptionPane.showMessageDialog(self,"Enter your last name.","Warning",JOptionPane.WARNING_MESSAGE);
                    }  else if(phoneNumber.isEmpty()){
                        JOptionPane.showMessageDialog(self,"Enter your phone number.","Warning",JOptionPane.WARNING_MESSAGE);
                    } else if (phoneNumber.toCharArray().length < 10 ) {
                        JOptionPane.showMessageDialog(self, "The phone should be 10 digits.");
                    } else if (phoneNumber.toCharArray().length > 10) {
                        JOptionPane.showMessageDialog(self, "The phone number exceeds 10 digits.");

                    } else{
                        reg.insert(firstName,lastName,phoneNumber);
                        
                        JOptionPane.showMessageDialog(self,"You data has been Added.","Success",JOptionPane.INFORMATION_MESSAGE);
                        clearBtn.doClick();
                    }
                }
            });

    }

    //Pup up message on clicking search button
    private void search(){
        JButton searchBtn = buttonPanel.getBtnSearch();

        searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(self,"Search functionality will be supported in the professional version","Information",JOptionPane.INFORMATION_MESSAGE);
                }
            });
    }

    //Removing or deleting the data from the table
    private void removeData(){
        JButton removeBtn = buttonPanel.getBtnRemove();
        DefaultTableModel model = dataPanel.getModel();
        JTable dataTable = dataPanel.getTable();
        JButton clearBtn = buttonPanel.getBtnClear();

        removeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirm = JOptionPane.showConfirmDialog(self, "Do you wanna delete the selected row", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    int selectedRow = dataTable.getSelectedRow();
                    if(confirm == JOptionPane.YES_OPTION){
                        try {
                            int rowDelete = Integer.parseInt(String.valueOf(selectedRow));
                            model.removeRow(rowDelete);
                            clearBtn.doClick();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(self, "No row selected. Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else{
                        return;
                    }
                }

            });
    }


    // Clearing the entered text field
    private void clearField(){
        JButton addBtn = buttonPanel.getBtnAdd();
        JButton clearBtn = buttonPanel.getBtnClear();
        JTable dataTable = dataPanel.getTable();
        clearBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infoPanel.getFirstName().setText("");
                    infoPanel.getLastName().setText("");
                    infoPanel.getPhoneNo().setText("");
                    infoPanel.getPrivateCheckBox().setSelected(false);
                    dataTable.clearSelection();
                }
            });
    }

    //Main Method
    public static void main(String[] args){
        new MyApp();
    }

}