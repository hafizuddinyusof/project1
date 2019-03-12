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
 
 
class Project extends JFrame implements ActionListener, ItemListener
{
 
 
    final static int MAX_PURCHASES = 20;    // maximum number of purchases
 
 
    private String [] produceNames = {
        "apples", "artichokes","avacados",
        "bananas", "beans", "broccoli", "brussell sprouts",
        "cabbage", "carrots", "chillis", "corn", "cucumbers",
        "grapefruit",
        "passionfruit","peaches", "pears", "peas", "plums", "potatoes", "pumpkin" };
 
    private double [] producePrices = {
        3.99, 6.69, 5.49,
        1.99, 8.99, 3.99, 2.49,
        4.99, 2.99, 10.99, 2.99, 4.49,
        2.59,
        6.99, 7.99, 4.99, 8.49, 7.49, 1.89, 1.49};
 
        private double [] cost = new double[ MAX_PURCHASES ];
        private String[] nameOfPurchase = new String [MAX_PURCHASES];
        private double[] weight = new double[ MAX_PURCHASES ];
        private double [] costPerKg = new double[ MAX_PURCHASES ];
        // my four parallel arrays
 
 
 
 
 
    private int numberOfPurchases = 0;              // the number of purchases entered so far
    private double totalCost = 0;                   // the total cost of purchases so far
 
 
    private JPanel topPanel = new JPanel();     // Panel for the title
    private JPanel centrePanel = new JPanel();  // panel for purchases and output
    private JPanel bottomPanel = new JPanel();  // Panel for Buttons
 
    private JPanel purchasePanel = new JPanel();    // panel to hold the details panels
 
    // This panel contains the customer name entry
    private JPanel namePanel = new JPanel();                // panel for entering the name
    private JLabel nameLabel = new JLabel("Customer name: ");// for prompt
    private JTextField nameField = new JTextField(25);      // textField to enter customer name
 
 
    private JLabel enterKgLabel = new JLabel("Enter kilograms purchased: ");// display next to the price per kilogram
    private JTextField enterKgField = new JTextField(7);        // textField to enter cost per kilo
    private JLabel produceCostLabel = new JLabel("Price per kilogram: ");// display next to the price per kilogram
    private JLabel produceCostPerKgLabel = new JLabel(String.format("$%.2f", producePrices[0]));// display  price per kilogram
 
 
 
    private JPanel producePanel = new JPanel(); // panel for the metres combo box
    private JLabel produceLabel = new JLabel("Select Produce"); // prompt
    private JComboBox<String> produceCombo = new JComboBox<String>(); // metres combo box
 
    private JPanel enterPanel = new JPanel();   // panel for the radio buttons
    private JPanel textAreaPanel = new JPanel(); // panel for the text area
    private JTextArea displayTextArea = new JTextArea("", 12, 70); // declare text area
 
 
    private JLabel titleLabel = new JLabel("Rocky Fruit & Vegetable Market"); // program title
 
 
    //  declare all of the buttons
    private JButton enterButton = new JButton("Enter"); // buttons
    private JButton displayButton = new JButton("Display All");
    private JButton newButton = new JButton("New");
    private JButton searchButton = new JButton("Search");
    private JButton sortByNameButton = new JButton("Sort By Name");
    private JButton sortByPriceButton = new JButton("Sort By Price");
    private JButton exitButton = new JButton("Exit");
 
    private JScrollPane scrollPane; // scroll pane for the text area
 
 
 
    public Project()
    { // constructor create the Gui
 
        // set text area to a monospaced font so the columns can be aligned using a format string
        displayTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayTextArea.setEditable(false);             // make text area read only
        scrollPane = new JScrollPane(displayTextArea);  // add text area to the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // just need vertical scrolling
 
 
        this.setLayout(new BorderLayout());         // set JFrame to Borderlayout
        topPanel.setLayout(new FlowLayout());       // set layouts for the panels
        centrePanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());
 
        topPanel.add(titleLabel);                   // add title label to the top panel
        add(topPanel, BorderLayout.NORTH);          // add top panel to north section of the JFrame
 
        purchasePanel.setLayout(new GridLayout(3, 1)); // set purchase panel to three vertical sections
        namePanel.setLayout(new FlowLayout());
        namePanel.add(nameLabel);                   // add name label to name panel
        namePanel.add(nameField);                   // add name field to name panel
        purchasePanel.add(namePanel);               // add name panel to first section of the purchase panel
 
        enterButton.addActionListener(this);        // add the action listener to the buttons
        displayButton.addActionListener(this);
        newButton.addActionListener(this);
        searchButton.addActionListener(this);
        sortByNameButton.addActionListener(this);
        sortByPriceButton.addActionListener(this);
        exitButton.addActionListener(this);
 
 
        enterKgField.addActionListener(this);       // make the enterKgField react to the enter key
        enterKgField.setActionCommand("Enter");
 
        produceCombo.addItemListener(this);
 
        bottomPanel.add(displayButton);             // add buttons to the bottom panel
        bottomPanel.add(newButton);
        bottomPanel.add(searchButton);
        bottomPanel.add(sortByNameButton);
        bottomPanel.add(sortByPriceButton);
        bottomPanel.add(exitButton);
        add(bottomPanel, BorderLayout.SOUTH);       // add bottom panel to the south section of the JFrame
 
 
 
        producePanel.setLayout(new FlowLayout());
        producePanel.add(produceLabel);             // add produce label to the produce panel
 
        for (int i = 0; i < produceNames.length; i++ )       // populate produce combo box with one to length of produce names array
        {
            produceCombo.addItem(produceNames[i]);
        }
        producePanel.add(produceCombo);             // add produce combo box to the produce panel
        producePanel.add(produceCostLabel);             // add produce combo box to the produce panel
        producePanel.add(produceCostPerKgLabel);                // add produce combo box to the produce panel
 
        purchasePanel.add(producePanel);                // add produce panel to the second section of the purchase panel
 
        enterPanel.setLayout(new FlowLayout());
        enterPanel.add(enterKgLabel);
        enterPanel.add(enterKgField);
        enterPanel.add(enterButton);
 
 
 
        purchasePanel.add(enterPanel);              // add enter panel to the third section of the purchase panel
 
        centrePanel.add(purchasePanel, BorderLayout.NORTH); // add the purchase panel to the north section of the centre panel
 
 
        textAreaPanel.setLayout(new FlowLayout());
 
        textAreaPanel.add(scrollPane); // add scrollpane to the text area panel
 
        centrePanel.add(textAreaPanel, BorderLayout.SOUTH); // add the text area panel to the south section of the centre panel
 
        add(centrePanel, BorderLayout.CENTER); // add the centre panel to the centre section of the JFrame
 
        // when the user pushes the system close (X top right corner)
        addWindowListener( // override window closing method
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    exit();             // Attempt to exit application
                }
            }
        );
 
    }
 
 
    public void actionPerformed(ActionEvent e)
    { // process the clicks on all of the buttons
        String command = e.getActionCommand();
 
        if (command.compareTo("Enter") == 0)
            enterPurchase();
        else if (command.compareTo("Display All") == 0)
            displayAllPurchases();
        else if (command.compareTo("New") == 0)
            newCustomer();
        else if (command.compareTo("Search") == 0)
            searchPurchases();
        else if (command.compareTo("Sort By Name") == 0)
            sortByName();
        else if (command.compareTo("Sort By Price") == 0)
            sortByPrice();
        else if (command.compareTo("Exit") == 0)
            exit();
    }
 
 
    private void rePopulateCombo()
    { // re-load the produce combo box after the lists have been sorted
        produceCombo.removeItemListener(this);
        produceCombo.removeAllItems(); // clear the combo box
 
        for (int i = 0; i < produceNames.length; i++ )       // populate produce combo box
        {
            produceCombo.addItem(produceNames[i]);
        }
 
        produceCombo.addItemListener(this);
 
        updateCostPerKg();
    }
 
 
    public void itemStateChanged(ItemEvent e)
    { // update cost per kilogram for produce item selected in combo box
        updateCostPerKg();
        enterKgField.requestFocus();
    }
 
 
    private void updateCostPerKg()
    { // update the cost per kilogram display
        produceCostPerKgLabel.setText(String.format("$%.2f", producePrices[produceCombo.getSelectedIndex()]));
    }
 
 
    private void enterPurchase()
    { // Check user input and enter the produce purchase, add the details to the arrays and display purchase
 
 
       if (numberOfPurchases == MAX_PURCHASES)           // if number of purchases equals 20
    {
    JOptionPane.showMessageDialog(null,           // shows a messgae dialog
        "Maximum number of Purchases has been reached",   // what message dialog actually displays
    "Rocky Fruit and Vegetable Market",               // title of message dialog
    JOptionPane.ERROR_MESSAGE);                       // error message dialog
    return;
    }
 
        if (nameField.getText().equals(""))
        {
        JOptionPane.showMessageDialog(null,       // shows a messgae dialog
        "You must enter a customer name",         // what message dialog actually displays
    "Rocky Fruit and Vegetable Market",       // title of message dialog
    JOptionPane.ERROR_MESSAGE);               // error message dialog
    return;
        }
 
         if (enterKgField.getText().equals(""))
        {
    JOptionPane.showMessageDialog(null,  // shows a messgae dialog
    "You must enter a produce weight",   // what message dialog actually displays
    "Rocky Fruit and Vegetable Market",  // title of message dialog
    JOptionPane.ERROR_MESSAGE);          // error message dialog
    return;
        }
 
 
 
    weight[numberOfPurchases] = Double.parseDouble(enterKgField.getText());
    cost[numberOfPurchases] =  weight[numberOfPurchases] * producePrices[produceCombo.getSelectedIndex()];
    costPerKg[numberOfPurchases] = producePrices[produceCombo.getSelectedIndex()];
 
        displayTextArea.setText(String.format("%.2f kgs of %s at $%.2f per kg is $%.2f"
        , weight[numberOfPurchases]
        , produceNames[produceCombo.getSelectedIndex()]
        , producePrices[produceCombo.getSelectedIndex()]
        ,cost[numberOfPurchases])
        );
        enterKgField.setText("");  // resets enterkgfield after enter button is pressed
        // Add purchaseName to nameOfPurchase array
    nameOfPurchase[numberOfPurchases] = produceNames[produceCombo.getSelectedIndex()];
 
 
 
         //newDouble[numberOfPurchases] = produceNames[produceCombo.getSelectedIndex()];
 
    totalCost += cost[numberOfPurchases];
    // add the other values to the arrays here
    numberOfPurchases++;       // incremement the number of purchase by 1
 
 
 
 
        }
 
    private void displayAllPurchases()
    {
 
        // TODO display the heading
 
        for (int i = 0 ; i < numberOfPurchases; i++)
        { // print all purchases
 
            // TODO display a line of purchase using i as index into the arrays
 
        }
 
        // TODO display total cost
 
    DisplayTextArea.setText("\t" + nameOfPurchase[1][1]);
        
 
 
 
 
    }
 
 
 
 
    private void newCustomer()
    {
        enterKgField.setText("");
        nameField.setText("");
        produceCombo.setSelectedIndex(0);
        displayTextArea.setText("");
 
    }
 
 
    private void searchPurchases()
    { // search from a name entered by the user
 
 
    }
 
 
    private void sortByName()
    { // sort produce list by names
 
 
        rePopulateCombo();
    }
 
    private void sortByPrice()
    { // sort produce list by price
 
 
        rePopulateCombo();
    }
 
 
    private void exit()
    { // exit the app if user selects yes
 
                int exit = JOptionPane.showConfirmDialog(this, "Do you Really want to exit?");
            if (exit == JOptionPane.YES_OPTION) {
                System.exit(0);
 
    } // exit
            }
 
    // Main method create instance of class
    public static void main(String[] args)
    {
        Project f = new Project();              // Create instance of class
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // allow the code to close the program
        f.setBounds(200, 100, 550, 450);                        // Define position and size of app
        f.setTitle("Rocky Fruit & Vegetable Market");           // Set the title of the app
        f.setVisible(true);                                     // Make the application visible
    } // main
 
}
