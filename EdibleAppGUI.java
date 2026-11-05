import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EdibleGUI extends JFrame implements ActionListener
{
    private JTextField txtName;
    private JComboBox<String> cboFood;

    private JButton btnEat;
    private JButton btnClear;

    private JTextArea txtOutput;

    public EdibleGUI()
    {
        setTitle("Edible App");
        setSize(450,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel lblTitle =
                new JLabel("EDIBLE APPLICATION",
                SwingConstants.CENTER);

        lblTitle.setFont(
                new Font("Arial",Font.BOLD,18));

        add(lblTitle, BorderLayout.NORTH);

        JPanel inputPanel =
                new JPanel(new GridLayout(2,2));

        inputPanel.add(new JLabel("Person Name"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Food"));

        cboFood = new JComboBox<>();

        cboFood.addItem("Chicken");
        cboFood.addItem("Red Apple");
        cboFood.addItem("Navel Orange");

        inputPanel.add(cboFood);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        btnEat = new JButton("Eat");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnEat);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);

        txtOutput = new JTextArea(5,20);
        txtOutput.setEditable(false);

        add(new JScrollPane(txtOutput),
                BorderLayout.EAST);

        btnEat.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnEat)
        {
            String personName =
                    txtName.getText();

            Person p =
                    new Person(personName);

            String food =
                    cboFood.getSelectedItem()
                    .toString();

            Edible item;

            if(food.equals("Chicken"))
            {
                item =
                    new Animal("Chicken");
            }
            else if(food.equals("Red Apple"))
            {
                item =
                    new Apple("Red Apple");
            }
            else
            {
                item =
                    new Orange("Navel Orange");
            }

            txtOutput.setText(
                    p.eating(item));
        }

        if(e.getSource()==btnClear)
        {
            txtName.setText("");
            txtOutput.setText("");
        }
    }

    public static void main(String[] args)
    {
        new EdibleGUI();
    }
}

//References: Copilot
