import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
//Class GUI which extends JFrame class and implements Action Listener
public class GUI1 extends JFrame implements ActionListener{
    //Declaration of variables
    JFrame  frame;
    JTable tbl;
    JMenu jm1,jm2,jm3;
    JMenuItem jmt1,jmt2,jmt3,jmt4,jmt5,jmt6;
    JMenuBar jmb;
    JLabel jlb1,jlb2,jlb3;
    JTextField jtf1,jtf2,jtf3;
    JScrollPane jsp;
    JCheckBox jcb;
    JRadioButton jrb1,jrb2;
    ButtonGroup bg;
    JButton btn1,btn2,btn3,btn4;
    JPanel pnl1,pnl2,pnl3,pnl4,pnl5;
    JDialog jd;
    
    public GUI1(){
        
      //Adding frame from JFrame class
        frame=new JFrame("phonebook");
        frame.setSize(750, 490);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        //This is for Table
        DefaultTableModel dtm=new DefaultTableModel();
        String [] column=new String[4];
        column[0]="";
        column[1]="";
        column[2]="";
        column[3]="";
        Object[][] data=new Object[100][100];
        dtm.addColumn(column[0]);
        dtm.addColumn(column[1]);
        dtm.addColumn(column[2]);
        dtm.addColumn(column[3]);
        tbl=new JTable(dtm);
        frame.add(tbl);
        
        //Adding JMenuBar in Table from JFrame class
        jmb=new JMenuBar();
        frame.add(jmb);
        
        //Adding JMenu  in frame from JFrame class
        jm1=new JMenu("File");
        jm1.addActionListener(this);
        jm1.setMnemonic(KeyEvent.VK_X);
        frame.add(jm1);
        jm2=new JMenu("Edit");
        jm2.setMnemonic(KeyEvent.VK_Z);
        jm2.addActionListener(this);
        frame.add(jm2);
        jm3=new JMenu("Help");
        jm3.setMnemonic(KeyEvent.VK_A);
        jm3.addActionListener(this);
        frame.add(jm3);
        
        //Adding JMenuItem in frame from JFrame class
        jmt1=new JMenuItem("Add");
        jmt1.setMnemonic(KeyEvent.VK_Z);
        jmt1.addActionListener(this);
        frame.add(jmt1);
        jmt2=new JMenuItem("Search");
        jmt2.setMnemonic(KeyEvent.VK_Z);
        jmt2.addActionListener(this);
        frame.add(jmt2);
        jmt3=new JMenuItem("Remove");
        jmt3.setMnemonic(KeyEvent.VK_Z);
        jmt3.addActionListener(this);
        frame.add(jmt1);
        jmt4=new JMenuItem("Clear");
        jmt4.setMnemonic(KeyEvent.VK_Z);
        jmt4.addActionListener(this);
        frame.add(jmt4);
        jmt5=new JMenuItem("Exit");
        jmt5.setMnemonic(KeyEvent.VK_X);
        jmt5.addActionListener(this);
        frame.add(jmt5);
        jmt6=new JMenuItem("About");
        jmt6.addActionListener(this);
        jmt6.setMnemonic(KeyEvent.VK_A);
        frame.add(jmt6);
        
        //Adding JMenuItem in JMenu from JFrame class
        jm1.add(jmt5);
        jm2.add(jmt1);
        jm2.add(new JSeparator());
        jm2.add(jmt2);
        jm2.add(new JSeparator());
        jm2.add(jmt3);
        jm2.add(new JSeparator());
        jm2.add(jmt4);
        jm2.add(new JSeparator());
        jm3.add(jmt6);
        
        //Adding JMenu in JMenubar from JFrame class
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm3);
        
        //Adding JLabel in frame from JFrame class
        jlb1=new JLabel("First Name");
        frame.add(jlb1);
        jlb2=new JLabel("Second Name");
        frame.add(jlb2);
        jlb3=new JLabel("Phone");
        frame.add(jlb3);
        
        //Adding JTextField in frame from JFrame class
        jtf1=new JTextField(10);
        frame.add(jtf1);
        jtf2=new JTextField(10);
        frame.add(jtf2);
        jtf3=new JTextField(10);
        frame.add(jtf3);
        
        //Adding JCheckBox in frame from JFrame class
        jcb=new JCheckBox("Private",false);
        jcb.addActionListener(this);
        frame.add(jcb);

        //Adding JRadioButton in frame from JFrame class
        jrb1=new JRadioButton("Forename,  Surname");
        jrb1.addActionListener(this);
        frame.add(jrb1);
        jrb2=new JRadioButton("Surname, Forename");
        jrb2.addActionListener(this);
        frame.add(jrb2);

        //Adding ButtonGroup in frame from JFrame class
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

        //Adding JBuuton in frame from JFrame class
        btn1=new JButton("Add");
        btn1.addActionListener(this);
        frame.add(btn1);
        btn2=new JButton("Search");
        btn2.addActionListener(this);
        frame.add(btn2);
        btn3=new JButton("Remove");
        btn3.addActionListener(this);
        frame.add(btn3);
        btn4=new JButton("Clear");
        btn4.addActionListener(this);
        frame.add(btn4);
        
        //Adding TitledBoarder Name of the frame 
        
        TitledBorder tb=new TitledBorder("Name");
   
        //JPanel pnl1 
        //Adding Table in pnl1
        pnl1=new JPanel();
        pnl1.setBorder(tb);
        pnl1.setLayout(new FlowLayout());
        pnl1.add(new JScrollPane(tbl));
        frame.add(pnl1);
        
        //Adding another TitledBoarder Info : of the frame 
        tb=new TitledBorder("Info :");
        
        //Adding JLabel, JTextField and JCheckBox in pnl2
        //JPanel pnl2
        pnl2=new JPanel();
        pnl2.setBorder(tb);
        pnl2.setLayout(new GridLayout(4,2));
        pnl2.add(jlb1);
        pnl2.add(jtf1);
        pnl2.add(jlb2);
        pnl2.add(jtf2);
        pnl2.add(jlb3);
        pnl2.add(jtf3);
        pnl2.add(jcb);
        frame.add(pnl2);
        
        //JPanel pnl3
        //Adding JRadioButton in pnl3
        tb=new TitledBorder("File as:");
        pnl3=new JPanel();
        pnl3.setBorder(tb);
        pnl3.setLayout(new GridLayout(2,2));
        pnl3.add(jrb1);
        pnl3.add(jrb2);
        frame.add(pnl3);

        //JPanel pnl4
        //Adding Buttons in pnl4
        pnl4=new JPanel();
        pnl4.setBorder(tb);
        pnl4.setLayout(new GridLayout(2,2));
        pnl4.add(btn1);
        pnl4.add(btn2);
        pnl4.add(btn3);
        pnl4.add(btn4);
        frame.add(pnl4);
        
        //Adding pnl2,pnl3,pnl4,pnl5 in pnl5
        //JPanel pnl5
        pnl5=new JPanel();
        pnl5.setLayout(new GridLayout(3,1));
        pnl5.add(pnl2);
        pnl5.add(pnl3);
        pnl5.add(pnl4);
        frame.add(pnl5);
        //Setting Layout of Pannel
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(jmb, BorderLayout.NORTH);
        frame.add(pnl1, BorderLayout.WEST);
        frame.add(pnl5, BorderLayout.EAST);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try {

            //For message in jmt6 which is About
            if(e.getSource()==jmt6){
                    JOptionPane.showMessageDialog((Component)e.getSource(),"It is still in trail version!!","Alert",JOptionPane.INFORMATION_MESSAGE);
                }
                //If the jrb1 and jrb2 is not selected and we click on btn1 we get the following message
                if(!jrb1.isSelected()&&!jrb2.isSelected()&& e.getSource()==btn1) {
                    JOptionPane.showMessageDialog(pnl1,"Radiobutton is not selected","Alert",JOptionPane.INFORMATION_MESSAGE);
                }
                
                //adding records in Table dtm
                if(e.getSource()==btn1){
                    String a=jtf1.getText();
                    String b=jtf2.getText();
                    String c=jtf3.getText();
                    String p="Private";
                    String d="";
                    DefaultTableModel model=(DefaultTableModel)tbl.getModel();
                    
                    if(jrb1.isSelected()){
                        if(jcb.isSelected()){
                            model.addRow(new Object[]{a,b,c,p});
                        } 
                        if(!jcb.isSelected()){
                            model.addRow(new Object[]{a,b,c,d});
                        }
                    }
                    else
                    if(jrb2.isSelected()){
                        if(jcb.isSelected()){    
                            model.addRow(new Object[]{b,a,c,p});
                        }
                        if(!jcb.isSelected()){
                            model.addRow(new Object[]{b,a,c,d});
                        }
                    }
                }
                //Clearing the input
if(e.getSource()==btn4){
   jtf1.setText("");
   jtf2.setText("");
   jtf3.setText("");
   jcb.setSelected(false);
}

//For Search we print the following
if(e.getSource()==btn2){
   JOptionPane.showMessageDialog((Component)e.getSource(),"Search functionality will be supported in the professional version.","Alert",JOptionPane.INFORMATION_MESSAGE);

}

//for exit 
if(e.getSource()==jmt5){
   System.exit(0);
}
//For removing the rows from the table
if(e.getSource()==btn3){
   DefaultTableModel model=(DefaultTableModel)tbl.getModel();    
   int h=tbl.getSelectedRow();
   model.removeRow(h);
}
//For Add
if(e.getSource()==jmt1){
   String a=jtf1.getText();
   String b=jtf2.getText();
       String c=jtf3.getText();
       String p="Yes";
       String d="No";
       DefaultTableModel model=(DefaultTableModel)tbl.getModel();

if(jrb1.isSelected()){
   if(jcb.isSelected()){
       model.addRow(new Object[]{a,b,c,p});
     } 

if(!jcb.isSelected()){
   model.addRow(new Object[]{a,b,c,d});
 }
}
else 
if(jrb2.isSelected()){
   if(jcb.isSelected()){
       model.addRow(new Object[]{b,a,c,p});
     }
     
if(!jcb.isSelected()){
   model.addRow(new Object[]{b,a,c,d});
 }
}	
}

       //For Remove
if(e.getSource()==jmt3){
    DefaultTableModel model=(DefaultTableModel)tbl.getModel();
    int h=tbl.getSelectedRow();
    model.removeRow(h);
}
      //For clear
if(e.getSource()==jmt4){
    jtf1.setText("");
    jtf2.setText("");
    jtf3.setText("");
    jcb.setSelected(false);
}
   //For Search
if(e.getSource()==jmt2){
   JOptionPane.showMessageDialog((Component)e.getSource(),"Search funtionality will be supported in the professional version.","Alert",JOptionPane.INFORMATION_MESSAGE);
}
    //For JRadioButton enable and disable
if(e.getSource()==jrb1){
    jrb1.setEnabled(false);
    jrb2.setEnabled(false);
}
else
if(e.getSource()==jrb2) {
    jrb1.setEnabled(false);
    jrb2.setEnabled(false);
}
}


    catch(Exception b) {
        System.out.println("Error :");
System.out.println(b.getMessage());
}
}

    //Main method
public static void main(String[]args) {
    GUI1 obj=new GUI1();	
}
}