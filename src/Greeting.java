import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Created by navidfarahmand on 8/6/17.
 */
public class Greeting {
    private  JFrame jFrame;
    public Greeting(){
        jFrame = new JFrame("Welcome");
        jFrame.setSize(400,600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((dim.width-jFrame.getWidth())/2,(dim.height-jFrame.getHeight())/2);
        JPanel panel = new JPanel(null);
        JLabel text = new JLabel("<html><div style='text-align : center;margin-bottom : 85px;'>Hello and Welcome to Apple ID Helper.</div>" +
                "<div style='text-align : center;'>Please select the Text file (.txt) that contain user information"
                        +"</div></html>");
        text.setSize(380,300);
        text.setFont(new Font(text.getFont().getName(),Font.CENTER_BASELINE,25));
        text.setLocation(15,30);
        panel.add(text);
        JButton selectFileButton = new JButton("Select File");
        selectFileButton.setSize(150,50);
        selectFileButton.setLocation(125,450);
        selectFileButton.setFont(new Font(text.getFont().getName(),Font.CENTER_BASELINE,15));

        panel.add(selectFileButton);
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runNext(false);
            }
        });
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(panel);
        File source = new File("ID.txt");
        if(source.exists())
        {
            runNext(true);
        }
        else
        {
            jFrame.setVisible(true);
        }

    }

    public JFrame getjFrame() {
        return jFrame;
    }
    private void runNext(boolean ID){
        Loader loader = new  Loader(ID);
        loader.loadData();
        if(loader.getAllUsers()==null){
            JOptionPane.showMessageDialog(null,"It seems that whether You chose no file \n or file with wrong format","Conflict",JOptionPane.ERROR_MESSAGE);
        }
        else{
            this.getjFrame().setVisible(false);
            HelperRobot robot = new HelperRobot(loader.getAllUsers());
            robot.exec();
        }
    }
}
