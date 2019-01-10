import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelApp<operand> extends JPanel
{
    double result = 0;
    String oper1 = "";
    String oper2 = "";
    String sign = "";

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
        txt1.setText("0");
        txt1.setBounds(10, 10, 200, 25);
        txt1.setEditable(false);

        for (int i=0; i<BUTTONS; i++){
            btns[i] = new JButton(cap[i]);
            btnPanel.add(btns[i]);
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                // далее говно-код....
                    switch (e.getActionCommand()){
                        case "=" :
                            txt1.setText(new Caclculus().getResult(oper1, oper2, sign));
                            oper1 = "";
                            oper2 = "";
                            sign = "";
                            break;
                        case "/" :
                        case "*" :
                        case "+" :
                        case "-" :
                            if (sign.equals("")){
                                oper1 = txt1.getText();
                                sign = e.getActionCommand();
                            }
                            else {
                                if (oper2.equals("")){
                                    sign = e.getActionCommand();
                                }
                                else{
                                    oper1 = new Caclculus().getResult(oper1, oper2, sign);
                                    sign = e.getActionCommand();
                                    oper2 = "";
                                }
                            }

                            txt1.setText(oper1 + e.getActionCommand());
                            break;
                        case "0" :
                        case "1" :
                        case "2" :
                        case "3" :
                        case "4" :
                        case "5" :
                        case "6" :
                        case "7" :
                        case "8" :
                        case "9" :
                            if (sign.equals("")) {
                                oper1 += oper1 + e.getActionCommand();
                                txt1.setText(oper1 + e.getActionCommand());
                            }
                            else {
                                oper2 += oper2 + e.getActionCommand();
                                txt1.setText(txt1.getText() + e.getActionCommand());
                            }
                            break;
                        case "C" :
                            oper1 = "";
                            oper2 = "";
                            sign = "";
                            txt1.setText("0");
                            break;
                        case "<=" :
                            break;
                        case "n!" :

                            break;
                        case "y^x" :
                            // реализовать
                            break;
                    }
                }
            });

        }

        add(btnPanel, BorderLayout.CENTER);
        add(txt1, BorderLayout.NORTH);

    }
}