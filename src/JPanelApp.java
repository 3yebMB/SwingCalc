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
    Caclculus calc = new Caclculus();

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
                            if (sign.equals("^"))
                                txt1.setText(calc.getDegree(oper1, oper2));
                            else
                                txt1.setText(calc.getResult(oper1, oper2, sign));
                            oper1 = "";
                            oper2 = "";
                            sign = "";
                            break;
                        case "/" :
                        case "*" :
                        case "+" :
                        case "-" :
                            if (!sign.equals("^")) {
                                if (sign.equals("")) {
                                    oper1 = txt1.getText();
                                    sign = e.getActionCommand();
                                    txt1.setText(oper1 + sign);
                                } else {
                                    if (!oper2.equals("")) {
                                        //sign = e.getActionCommand(); считаем со старым знаком
                                        // результат выводим и новый знак
                                        oper1 = calc.getResult(oper1, oper2, sign);
                                        oper2 = "";
                                        sign = e.getActionCommand();
                                        txt1.setText(oper1 + sign);
                                    }
                                }

                            sign = e.getActionCommand();
                            txt1.setText(oper1 + e.getActionCommand());
                            }
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
                                oper1 += e.getActionCommand();
                                txt1.setText(oper1);
                            }
                            else {
                                oper2 += e.getActionCommand();
                                if (!sign.equals("y^x"))
                                    txt1.setText(oper1 + sign + oper2);
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
                            sign = "^";
                            if (oper1.equals(""))
                                oper1 = "0";
                            txt1.setText(oper1 + sign);
                            break;
                    }
                }
            });

        }

        add(btnPanel, BorderLayout.CENTER);
        add(txt1, BorderLayout.NORTH);

    }
}