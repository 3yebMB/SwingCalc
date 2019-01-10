import javax.swing.*;

public class JFrameApp extends JFrame
{
    public JFrameApp()
    {
        setBounds(100, 100, 225, 325);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add( new JPanelApp());
        setResizable(false);
        setVisible(true);
    }
}