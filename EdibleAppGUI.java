import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EdibleAppGUI extends JFrame implements ActionListener
{
    private JButton btnChicken;
    private JButton btnApple;
    private JButton btnOrange;
    private JButton btnEat;
    private JButton btnReset;

    private JLabel lblSelectedFood;

    private JTextArea txtOutput;

    private String selectedFood = "";

    public EdibleAppGUI()
    {
        setTitle("Edible Management System");
        setSize(900,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10,10));

        //TITLE PANEL 
        JPanel titlePanel = new JPanel(new GridLayout(2,1));

        JLabel lblTitle = new JLabel("EDIBLE MANAGEMENT SYSTEM", SwingConstants.CENTER);

        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel lblSubTitle = new JLabel("Choose a food to see how it can be eaten", SwingConstants.CENTER);

        lblSubTitle.setFont(new Font("Arial", Font.BOLD, 16));

        titlePanel.add(lblTitle);
        titlePanel.add(lblSubTitle);

        pane.add(titlePanel, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Food Buttons
        JPanel foodPanel = new JPanel(new GridLayout(1,3,10,10));

        btnChicken = new JButton("Chicken");
        btnApple = new JButton("Red Apple");
        btnOrange = new JButton("Navel Orange");

        foodPanel.add(btnChicken);
        foodPanel.add(btnApple);
        foodPanel.add(btnOrange);

        centerPanel.add(foodPanel);

        centerPanel.add(Box.createVerticalStrut(30));

        // Selected Food Label
        lblSelectedFood = new JLabel("Selected Food: ", SwingConstants.CENTER);

        lblSelectedFood.setFont(new Font("Arial", Font.BOLD, 18));

        lblSelectedFood.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(lblSelectedFood);

        centerPanel.add(Box.createVerticalStrut(20));

        // Output Area
        txtOutput = new JTextArea(8, 50);
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(txtOutput);

        centerPanel.add(scrollPane);

        pane.add(centerPanel, BorderLayout.CENTER);

        // BUTTON PANEL 
        JPanel buttonPanel = new JPanel();

        btnEat = new JButton("EAT");
        btnReset = new JButton("RESET");

        buttonPanel.add(btnEat);
        buttonPanel.add(btnReset);

        pane.add(buttonPanel, BorderLayout.SOUTH);

        // ===== REGISTER LISTENER =====
        btnChicken.addActionListener(this);
        btnApple.addActionListener(this);
        btnOrange.addActionListener(this);
        btnEat.addActionListener(this);
        btnReset.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnChicken)
        {
            selectedFood = "Chicken";
            lblSelectedFood.setText("Selected Food: Chicken");
        }

        else if(e.getSource() == btnApple)
        {
            selectedFood = "Red Apple";
            lblSelectedFood.setText("Selected Food: Red Apple");
        }

        else if(e.getSource() == btnOrange)
        {
            selectedFood = "Navel Orange";
            lblSelectedFood.setText("Selected Food: Navel Orange");
        }

        else if(e.getSource() == btnEat)
        {
            if(selectedFood.equals("Chicken"))
            {
                Person p = new Person("Ali");
                Animal chicken = new Animal("Chicken");

                txtOutput.append(p.eating(chicken) + "\n");
            }

            else if(selectedFood.equals("Red Apple"))
            {
                Person p = new Person("Sarah");
                Apple apple = new Apple("Red Apple");

                txtOutput.append(p.eating(apple) + "\n");
            }

            else if(selectedFood.equals("Navel Orange"))
            {
                Person p = new Person("Sarah");
                Orange orange = new Orange("Navel Orange");

                txtOutput.append(p.eating(orange) + "\n");
            }

            else
            {
                JOptionPane.showMessageDialog(this, "Please select a food first!");
            }
        }

        else if(e.getSource() == btnReset)
        {
            txtOutput.setText("");
            selectedFood = "";
            lblSelectedFood.setText("Selected Food: ");
        }
    }

    public static void main(String[] args)
    {
        new EdibleAppGUI();
    }
}

//References: Copilot
