import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelApp extends JPanel
{
    String oper = "";
    final String[] cap = {"C", "n!", "y^x", "<=", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "+", "0", ".", "=", "-"};
    int BUTTONS = 20;
    JButton[] btns = new JButton[BUTTONS];
    JTextField txt1 = null;

    public JPanelApp()
    {
        JPanel btnPanel = new JPanel();
        GridLayout layout = new GridLayout(5, 4, 2, 2);
        btnPanel.setLayout(layout);
        setLayout(new BorderLayout());

        final TextField txt1 = new TextField();
        txt1.setBounds(10, 10, 200, 25);
        txt1.setEditable(false);

        for (int i=0; i<BUTTONS; i++){
            btns[i] = new JButton(cap[i]);
            btnPanel.add(btns[i]);
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand());
                }
            });

        }

        for (int i=0; i<BUTTONS; i++){

        }

        add(btnPanel, BorderLayout.CENTER);
        add(txt1, BorderLayout.NORTH);

    }
}