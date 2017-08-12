
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.NumberFormat;
import java.util.Vector;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

/**
 * Created by navidfarahmand on 8/6/17.
 */
public class HelperRobot {
    private Vector<User> allUsers;
    private JFrame jFrame;
    private int curIndex;
    private JFormattedTextField IDField;
    private JFormattedTextField IndexField;
    private JTextField UserNameField;
    private JTextField PasswordField;
    private JTextField TempPasswordField;
    private JTextField AnswerField;
    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JTextField PreNameField;
    private JTextField DayField;
    private JTextField MonthField;
    private JTextField YearField;
    private JTextField StateField;
    private JTextField ZipCodeField;
    private JTextField PhoneCodeField;
    private JTextField AddressField;
    private JTextField CityField;
    private JTextField PhoneNumberField;
    private JFormattedTextField DelayField;


    public HelperRobot(Vector<User> allUsers){
        this.allUsers=allUsers;
        if(this.allUsers.size()==0) {
            this.allUsers.add(new User(""));
            this.curIndex=0;
            saveIndex();
        }
        loadIndex();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.jFrame = new JFrame("Apple ID Helper");
        this.jFrame.setSize(400,470);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.jFrame.setLocation(0,(int)(dim.height*0.45));
        JButton loginButton = new JButton();
        loginButton.setSize(150,35);
        loginButton.setText("Login");
        loginButton.setLocation(25,355);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelperRobot.this.login();

            }
        });
       panel.add(loginButton);
       this.jFrame.addWindowListener(new WindowListener() {
           @Override
           public void windowOpened(WindowEvent e) {

           }

           @Override
           public void windowClosing(WindowEvent e) {
                saveIndex();
           }

           @Override
           public void windowClosed(WindowEvent e) {

           }

           @Override
           public void windowIconified(WindowEvent e) {

           }

           @Override
           public void windowDeiconified(WindowEvent e) {

           }

           @Override
           public void windowActivated(WindowEvent e) {

           }

           @Override
           public void windowDeactivated(WindowEvent e) {

           }
       });
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int code = (int)e.getKeyChar();
                int zeroCode = (int)'0';
                int nineCode = (int)'9';
                if(!(zeroCode<=code && code<=nineCode))
                    e.consume();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
       JButton idDetailButton = new JButton();
        idDetailButton.setSize(150,35);
        idDetailButton.setText("Apple ID");
        idDetailButton.setLocation(225,355);
        idDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelperRobot.this.appleId();
            }
        });
       panel.add(idDetailButton);

        JButton addressButton = new JButton();
        addressButton.setSize(150,35);
        addressButton.setText("Address");
        addressButton.setLocation(25,400);
        addressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelperRobot.this.adderss();
            }
        });
        panel.add(addressButton);

        JButton screenShotButton = new JButton();
        screenShotButton.setSize(150,35);
        screenShotButton.setText("ScreenShot");
        screenShotButton.setLocation(225,400);
        screenShotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelperRobot.this.screenShot();
            }
        });
        panel.add(screenShotButton);


        this.PreNameField = new JTextField();
       JPanel userInfPanel = new JPanel();
       userInfPanel.setBorder(new TitledBorder("User information"));
       userInfPanel.setLayout(null);
       userInfPanel.setSize(380,281);
       userInfPanel.setLocation(10,15);
       panel.add(userInfPanel);

        JLabel IDText = new JLabel("ID number :");
        IDText.setSize(100,25);
        IDText.setLocation(25,20);
        userInfPanel.add(IDText);
        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    HelperRobot.this.IdChanged();
            }
        };
        this.IDField = new JFormattedTextField(NumberFormat.getNumberInstance());
        this.IDField.addKeyListener(keyListener);
        this.IDField.setSize(53,25);
        this.IDField.setLocation(115,20);
        this.IDField.addActionListener(action);
        this.IDField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }
            @Override
            public void focusLost(FocusEvent e) {
                HelperRobot.this.IdChanged();
            }
        });
        userInfPanel.add(this.IDField);



        JLabel IndexText = new JLabel("Index :");
        IndexText.setSize(100,25);
        IndexText.setLocation(200,20);
        userInfPanel.add(IndexText);
        AbstractAction SecondAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelperRobot.this.IndexChanged();
            }
        };
        this.IndexField =  new JFormattedTextField(NumberFormat.getNumberInstance());
        this.IndexField.setSize(53,25);
        this.IndexField.setLocation(260,20);
        this.IndexField.addActionListener(SecondAction);
        this.IndexField.addKeyListener(keyListener);
        this.IndexField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }
            @Override
            public void focusLost(FocusEvent e) {
                HelperRobot.this.IndexChanged();
            }
        });
        userInfPanel.add(this.IndexField);

        JLabel usernameText = new JLabel("Username :");
        usernameText.setSize(100,25);
        usernameText.setLocation(25,45);
        userInfPanel.add(usernameText);

        this.UserNameField = new JTextField();
        this.UserNameField.setSize(250,25);
        this.UserNameField.setLocation(115,45);
        userInfPanel.add(this.UserNameField);

       JLabel passwordText = new JLabel("Password :");
       passwordText.setSize(100,25);
       passwordText.setLocation(25,70);
        userInfPanel.add(passwordText);

        this.PasswordField = new JTextField();
        this.PasswordField.setSize(250,25);
        this.PasswordField.setLocation(115,70);
        userInfPanel.add(this.PasswordField);

        JLabel tempPasswordText = new JLabel("<html>Temp Password :</html>");
        tempPasswordText.setSize(100,25);
        tempPasswordText.setLocation(25,95);
        userInfPanel.add(tempPasswordText);

        this.TempPasswordField = new JTextField();
        this.TempPasswordField.setSize(250,25);
        this.TempPasswordField.setLocation(115,95);
        userInfPanel.add(this.TempPasswordField);


        JLabel answerText = new JLabel("Answer :");
        answerText.setSize(100,25);
        answerText.setLocation(25,120);
        userInfPanel.add(answerText);

        this.AnswerField = new JTextField();
        this.AnswerField.setSize(250,25);
        this.AnswerField.setLocation(115,120);
        userInfPanel.add(this.AnswerField);



        this.FirstNameField = new JTextField();


        this.LastNameField = new JTextField();


        JLabel birthDateText = new JLabel("<html>Birth Date :</html>");
        birthDateText.setSize(100,25);
        birthDateText.setLocation(25,145);
        userInfPanel.add(birthDateText);

        this.YearField = new JTextField();
        this.YearField.setSize(50,25);
        this.YearField.setLocation(115,145);
        userInfPanel.add(this.YearField);

        JLabel slashFirst = new JLabel("/");
        slashFirst.setSize(50,25);
        slashFirst.setLocation(180,145);
        userInfPanel.add(slashFirst);

        this.MonthField = new JTextField();
        this.MonthField.setSize(50,25);
        this.MonthField.setLocation(200,145);
        userInfPanel.add(this.MonthField);

        JLabel slashSecond = new JLabel("/");
        slashSecond.setSize(50,25);
        slashSecond.setLocation(264,145);
        userInfPanel.add(slashSecond);

        this.DayField = new JTextField();
        this.DayField.setSize(50,25);
        this.DayField.setLocation(285,145);
        userInfPanel.add(this.DayField);


        JLabel AddressText = new JLabel("Address :");
        AddressText.setSize(100,25);
        AddressText.setLocation(25,168);
        userInfPanel.add(AddressText);

        this.AddressField = new JTextField();
        this.AddressField.setSize(250,25);
        this.AddressField.setLocation(115,170);
        userInfPanel.add(this.AddressField);

        JLabel StateText = new JLabel("State :");
        StateText.setSize(100,35);
        StateText.setLocation(25,190);
        userInfPanel.add(StateText);

        this.StateField = new JTextField();
        this.StateField.setSize(50,25);
        this.StateField.setLocation(115,195);
        userInfPanel.add(this.StateField);

        JLabel CityText = new JLabel("City :");
        CityText.setSize(100,35);
        CityText.setLocation(175,188);
        userInfPanel.add(CityText);

        this.CityField = new JTextField();
        this.CityField.setSize(149,25);
        this.CityField.setLocation(216,195);
        userInfPanel.add(this.CityField);


        JLabel zipCodeText = new JLabel("Zip Code :");
        zipCodeText.setSize(100,35);
        zipCodeText.setLocation(25,215);
        userInfPanel.add(zipCodeText);

        this.ZipCodeField = new JTextField();
        this.ZipCodeField.setSize(250,25);
        this.ZipCodeField.setLocation(115,220);
        userInfPanel.add(this.ZipCodeField);


        JLabel PhoneCodeText = new JLabel("Phone :");
        PhoneCodeText.setSize(85,35);
        PhoneCodeText.setLocation(25,240);
        userInfPanel.add(PhoneCodeText);

        this.PhoneCodeField = new JTextField();
        this.PhoneCodeField.setSize(60,25);
        this.PhoneCodeField.setLocation(115,245);
        userInfPanel.add(this.PhoneCodeField);


        JLabel dashText = new JLabel("-");
        dashText.setSize(100,35);
        dashText.setLocation(180,240);
        userInfPanel.add(dashText);

        this.PhoneNumberField = new JTextField();
        this.PhoneNumberField.setSize(115,25);
        this.PhoneNumberField.setLocation(193,245);
        userInfPanel.add(this.PhoneNumberField);


       JLabel delayText = new JLabel("Delay :");
       delayText.setSize(100,25);
       delayText.setLocation(25,315);
       panel.add(delayText);


       this.DelayField = new JFormattedTextField(NumberFormat.getNumberInstance());
       this.DelayField.setColumns(20);
       this.DelayField.setValue(new Integer(1));
       this.DelayField.setSize(100,25);
       this.DelayField.setLocation(77,315);
       this.DelayField.addKeyListener(keyListener);
       panel.add(this.DelayField);

       JButton nextUser = new JButton("->");
       nextUser.setSize(70,45);
       nextUser.setLocation(305,300);
       nextUser.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               nextUser();
           }
       });
       panel.add(nextUser);

        JButton previousUser = new JButton("<-");
        previousUser.setSize(70,45);
        previousUser.setLocation(225,300);
        previousUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousUser();
            }
        });
        panel.add(previousUser);

       this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       this.jFrame.getContentPane().add(panel);
    }
    public void exec(){
        this.fillUserFields(this.allUsers.elementAt(this.curIndex));
        this.jFrame.setVisible(true);
    }
    public void login(){
       this.passFocus();
        try {
            this.typeString(this.UserNameField.getText(),true);
            this.typeTab(false);
            this.typeString(this.PasswordField.getText(),false);
            this.typeEnter();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error in use of AWT robot ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void typeString( String string,boolean needDelay){
        try{
            Robot temp = new Robot();
            if(needDelay)
            temp.delay((int)(1000* Float.parseFloat(this.DelayField.getText())));
            temp.setAutoDelay(500);
            StringSelection userSelection = new StringSelection(string);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(userSelection, userSelection);
            String OSName = System.getProperty("os.name");
            boolean flag = OSName.startsWith("Mac OS X");
            if(flag) {
                temp.keyPress(KeyEvent.VK_META);
            }else {
                temp.keyPress(KeyEvent.VK_CONTROL);
            }
            temp.keyPress(KeyEvent.VK_V);
            temp.keyRelease(KeyEvent.VK_V);
            if(flag) {
                temp.keyRelease(KeyEvent.VK_META);
            }else{
                temp.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (AWTException e) {
            JOptionPane.showMessageDialog(null,"Error in creating AWT Robot ","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch (HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error in Use of ClipBoard ","Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    private  void typeTab(boolean needDelay){
        try{
            Robot temp = new Robot();
            if(needDelay)
                temp.delay((int)(1000* Float.parseFloat(this.DelayField.getText())));
            temp.setAutoDelay(20);
            temp.keyPress(KeyEvent.VK_TAB);
            temp.keyRelease(KeyEvent.VK_TAB);
            temp.setAutoDelay(0);
        } catch (AWTException e){
            JOptionPane.showMessageDialog(null,"Error in creating AWT Robot ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private  void typeEnter(){
        try{
            Robot temp = new Robot();
            temp.setAutoDelay(500);
            temp.keyPress(KeyEvent.VK_ENTER);
            temp.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e){
            JOptionPane.showMessageDialog(null,"Error in creating AWT Robot ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private  void typeBotArrow(boolean needDelay){
        try{
            Robot temp = new Robot();
            if(needDelay)
                temp.delay((int)(1000* Float.parseFloat(this.DelayField.getText())));
            temp.setAutoDelay(500);
            temp.keyPress(KeyEvent.VK_DOWN);
            temp.keyRelease(KeyEvent.VK_DOWN);
        } catch (AWTException e){
            JOptionPane.showMessageDialog(null,"Error in creating AWT Robot ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void fillUserFields(User user){
        this.IDField.setText(Integer.toString(user.getId()));
        this.UserNameField.setText(user.getEmail());
        this.PasswordField.setText(user.getPassword());
        this.TempPasswordField.setText((user.getTempPassword()));
        this.AnswerField.setText(user.getAnswer());
        this.YearField.setText(Integer.toString(user.getYear()));
        this.MonthField.setText(Integer.toString(user.getMonth()));
        this.DayField.setText(Integer.toString(user.getDay()));
        this.ZipCodeField.setText((user.getZipCode()));
        this.StateField.setText(Integer.toString(user.getState()));
        this.PhoneCodeField.setText((user.getPhoneCode()));
        this.PhoneNumberField.setText(user.getPhoneNumber());
        this.PreNameField.setText(Integer.toString(user.getNamePre()));
        this.FirstNameField.setText(user.getFirstName());
        this.LastNameField.setText(user.getLastName());
        this.CityField.setText(user.getCity());
        this.AddressField.setText(user.getStreetName());
        this.IndexField.setText(Integer.toString(this.curIndex+1));
    }
    public void nextUser(){
        int temp = this.curIndex+1;
        if(temp>= this.allUsers.size())
            temp = this.curIndex;
        this.curIndex=temp;
        this.fillUserFields(this.allUsers.elementAt(this.curIndex));
        saveIndex();
    }
    public void previousUser(){
        int temp  = (this.curIndex -1);
        if(temp<0)
            temp = this.curIndex;
        this.curIndex = temp;
        this.fillUserFields(this.allUsers.elementAt(this.curIndex));
        saveIndex();
        }

    public JFrame getjFrame() {
        return jFrame;
    }
    public int getUserBaseID(int id){
        for(int i=0;i<this.allUsers.size();i++)
            if(id==this.allUsers.elementAt(i).getId())
                return i;
        return -1;
    }
    public void screenShot(){
        this.passFocus();
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File saveDir = new File("Results");
            if(!saveDir.exists())
            {
                saveDir.mkdir();
            }
            String fileName = this.IndexField.getText()+"_"+this.UserNameField.getText();
            if(fileName.compareTo("")==0)
                fileName=new java.util.Date().toString();
            ImageIO.write(image, "png", new File("Results",fileName+".png"));
        }catch(AWTException e){
            JOptionPane.showMessageDialog(null,"Error in creating AWT Robot ","Error",JOptionPane.ERROR_MESSAGE);

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error in Saving Screenshot ","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SecurityException e){
            JOptionPane.showMessageDialog(null,"Error in creating Results Directory ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void passFocus() {
        try {
            Robot temp = new Robot();
            String OSName = System.getProperty("os.name");
            boolean flag = OSName.startsWith("Mac OS X");
            if (flag) {
                temp.keyPress(KeyEvent.VK_META);
            } else {
                temp.keyPress(KeyEvent.VK_ALT);
            }
            temp.keyPress(KeyEvent.VK_TAB);
            temp.keyRelease(KeyEvent.VK_TAB);
            if (flag) {
                temp.keyRelease(KeyEvent.VK_META);
            } else {
                temp.keyRelease(KeyEvent.VK_ALT);
            }
            TimeUnit.SECONDS.sleep(1);
        } catch (AWTException e) {
            JOptionPane.showMessageDialog(null, "Error in creating AWT Robot ", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException e1) {
            JOptionPane.showMessageDialog(null, "Error in Wait for Passing focus ", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    public void IdChanged()
    {
        int id = -1;
        try {
            id=Integer.parseInt(HelperRobot.this.IDField.getText());
        }finally {
            int finedIndex = HelperRobot.this.getUserBaseID(id);
            if(finedIndex==-1){
                this.fillUserFields(new User(""));
                this.curIndex=0;
            }
            else {
                this.curIndex=finedIndex;
                this.fillUserFields(HelperRobot.this.allUsers.elementAt(finedIndex));
            }
        }
        saveIndex();
    }
    public void IndexChanged()
    {
        int index = Integer.parseInt(this.IndexField.getText());
        index--;
        if(index>=this.allUsers.size()||index<0)
            index=this.curIndex;
        this.curIndex = index;
        saveIndex();
        this.fillUserFields(HelperRobot.this.allUsers.elementAt(this.curIndex));

    }
    public void appleId(){
        this.passFocus();
        this.typeTab(true);
        this.typeTab(false);
        this.typeString(this.TempPasswordField.getText(),false);
        this.typeTab(false);
        this.typeString(this.TempPasswordField.getText(),false);
        this.typeTab(false);
        this.typeTab(false);
        this.typeString(this.AnswerField.getText(),false);
        this.typeEnter();

    }
    public  void  adderss(){
        this.passFocus();
        this.typeTab(true);
        this.typeTab(false);
        for(int i=0;i<=Integer.parseInt(this.PreNameField.getText());i++){
            this.typeBotArrow(false);
        }
        this.typeEnter();
        this.typeTab(false);
        this.typeTab(false);
        this.typeTab(false);
        this.typeString(this.AddressField.getText(),false);
        this.typeTab(false);
        this.typeTab(false);
        this.typeString(this.CityField.getText(),false);
        this.typeTab(false);
        for(int i=0;i<=Integer.parseInt(this.StateField.getText());i++){
            this.typeBotArrow(false);
        }
        this.typeEnter();
        this.typeTab(false);
        this.typeString((this.ZipCodeField.getText()),false);
        this.typeTab(false);
        this.typeString((this.PhoneCodeField.getText()),false);
        this.typeTab(false);
        this.typeString(this.PhoneNumberField.getText(),false);
        this.typeEnter();
    }
    public void loadIndex(){
        File indexFile = new File(".lastIndex.txt");
        if(indexFile.exists()) {
            try {
                FileReader fileReader =
                        new FileReader(indexFile.getAbsolutePath());
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);
                String line = new String();
                line = bufferedReader.readLine();
                this.curIndex = Integer.parseInt(line);
                System.out.println();
                bufferedReader.close();
            }  catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Error in last index reloading(not integer!)", "Error", JOptionPane.ERROR_MESSAGE);
                this.curIndex=0;
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error in Open File to Read last Index", "Error", JOptionPane.ERROR_MESSAGE);
                this.curIndex=0;
            }
        }
        else{
            this.curIndex=0;
        }
    }
    public void saveIndex(){
        try{
            PrintWriter writer = new PrintWriter(".lastIndex.txt", "UTF-8");
            writer.println(Integer.toString(this.curIndex));
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error in saving last Index", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}

