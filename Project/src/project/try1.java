/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author hafizuddinyusof
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
 
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
 
public class try1 extends JFrame implements ActionListener, ItemListener
{
    
    private String [] flight = new String [20];
    private String [] arrived = new String [20];
    private String [] departure = new String [20];
    private String [] route = {"Kuala Lumpur", "Penang","Langkawi"};
    
    private JPanel top = new JPanel(); //title
    private JPanel center = new JPanel(); //
    private JPanel bottom = new JPanel(); //
    
    //flight name
    private JPanel flightPanel = new JPanel();
    private JLabel flightLabel = new JLabel("Flight Name: ");
    private JTextField flightField = new JTextField(25);
    private JPanel flightinfo = new JPanel(); 
    //arrived time
    private JPanel arrivedPanel = new JPanel();
    private JLabel arrivedLabel = new JLabel("Arrived Time: ");
    private JTextField arrivedField = new JTextField(25);
    private JPanel arrivedinfo = new JPanel(); 
    //departure time
    private JPanel departurePanel = new JPanel();
    private JLabel departureLabel = new JLabel("Departure Time: ");
    private JTextField departureField = new JTextField(25);
    private JPanel departureinfo = new JPanel();
    //
    private JPanel list = new JPanel();
    private JLabel nameList = new JLabel("Select Route");
    private JComboBox<String> combo = new JComboBox<String>();
    
    private JPanel enterPanel = new JPanel();
    private JPanel textAreaPanel = new JPanel(); 
    private JTextArea displayTextArea = new JTextArea("", 12, 70);
 
 
    private JLabel titleLabel = new JLabel("Flight Schedulling");
    
    private JButton enterButton = new JButton("Enter"); // buttons
    private JButton displayFlight = new JButton("Display Flight");
    private JButton displayArrived = new JButton("Display Arrived");
    private JButton displayDeparture = new JButton("Display Departure");
    private JButton newButton = new JButton("New");
    private JButton exitButton = new JButton("Exit");
 
    private JScrollPane scrollPane; // scroll pane for the text area
    
    public try1()
    {
        //text area
        displayTextArea.setFont(new Font("Monospaced",Font.PLAIN,12));
        displayTextArea.setEditable(false); 
        scrollPane = new JScrollPane(displayTextArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //JFrame border and frame
        this.setLayout(new BorderLayout());         // set JFrame to Borderlayout
        top.setLayout(new FlowLayout());       // set layouts for the panels
        center.setLayout(new BorderLayout());
        bottom.setLayout(new FlowLayout());
        
        top.add(titleLabel);
        add(top,BorderLayout.NORTH);
        
        flightinfo.setLayout(new GridLayout(3, 1));
        flightPanel.setLayout(new FlowLayout());
        flightPanel.add(flightLabel);      
        flightPanel.add(flightField);     
        flightinfo.add(flightPanel);
        
        arrivedinfo.setLayout(new GridLayout(3, 1));
        arrivedPanel.setLayout(new FlowLayout());
        arrivedPanel.add(arrivedLabel);
        arrivedPanel.add(arrivedField);
        arrivedinfo.add(arrivedPanel);
        
        departureinfo.setLayout(new GridLayout(3, 1));
        departurePanel.setLayout(new FlowLayout());
        departurePanel.add(departureLabel);
        departurePanel.add(departureField);
        departureinfo.add(departurePanel);
        
        enterButton.addActionListener(this);        // add the action listener to the buttons
        displayFlight.addActionListener(this);
        newButton.addActionListener(this);
        displayArrived.addActionListener(this);
        displayDeparture.addActionListener(this);
        exitButton.addActionListener(this);
        
        combo.addItemListener(this);
        bottom.add(newButton);
        bottom.add(displayFlight);        
        bottom.add(displayArrived);
        bottom.add(displayDeparture);
        bottom.add(exitButton);
        add(bottom, BorderLayout.SOUTH); 
        
        list.setLayout(new FlowLayout());
        list.add(nameList);
 
        for (int i = 0; i < route.length; i++ )
        {
            combo.addItem(route[i]);
        }
        list.add(combo);
        list.add(list); 
        
        textAreaPanel.setLayout(new FlowLayout());
 
        textAreaPanel.add(scrollPane); // add scrollpane to the text area panel
 
        center.add(textAreaPanel, BorderLayout.SOUTH); // add the text area panel to the south section of the centre panel
 
        add(center, BorderLayout.CENTER); // add the centre panel to the centre section of the JFrame
 
        // when the user pushes the system close (X top right corner)
        addWindowListener( // override window closing method
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    exit();
                }
            }
        );
    }
    
    private void exit()
    { // exit the app if user selects yes
 
            int exit = JOptionPane.showConfirmDialog(this, "Do you Really want to exit?");
            if (exit == JOptionPane.YES_OPTION)
            {
                System.exit(0);
 
            } // exit
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public static void main(String[] args)
    {
        try1 f = new try1();              // Create instance of class
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // allow the code to close the program
        f.setBounds(200, 100, 550, 450);                        // Define position and size of app
        f.setTitle("Flight Schedulling");           // Set the title of the app
        f.setVisible(true);                                     // Make the application visible
    } // main
}
