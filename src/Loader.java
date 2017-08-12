import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

/**
 * Created by navidfarahmand on 8/5/17.
 */
public class Loader {
    private  String path;
    private Vector<User> allUsers;
    private boolean flag;
    public Loader(boolean ID){
//        JFileChooser fileChooser = new JFileChooser();
//        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Text Files","txt");
//        fileChooser.setFileFilter(fileNameExtensionFilter);
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        System.setProperty("apple.awt.fileDialogForDirectories", "true");
//        int interval = fileChooser.showOpenDialog(null);
//        if(interval==JFileChooser.APPROVE_OPTION){
//            this.path=fileChooser.getSelectedFile().getPath();
//            this.allUsers=new Vector<>();
//            this.flag=true;
//        }else
//        {
//            this.flag=false;
//        }
        if(ID)
        {
            this.path = "ID.txt";
            this.allUsers = new Vector<>();
            this.flag = true;
        }
        else {
            JFrame frame = new JFrame("Select a .txt file");
            System.setProperty("apple.awt.fileDialogForFiles", "true");
            FileDialog fileDialog = new FileDialog(frame);
            fileDialog.setTitle("Select a .txt file");
            fileDialog.setVisible(true);
            String fileName = null;
            if (fileDialog.getDirectory() != null & fileDialog.getFile() != null) {
                File file = new File(fileDialog.getDirectory(), fileDialog.getFile());
                fileName = file.getAbsolutePath();
                if (!fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()).trim().equalsIgnoreCase("txt"))
                    fileName = null;
                this.flag = false;
            }
            if (fileName != null) {
                this.path = fileName;
                this.allUsers = new Vector<>();
                this.flag = true;
            } else {
                this.flag = false;
            }
        }
    }
    public void loadData(){
        if(flag) {
            try {
                FileReader fileReader =
                        new FileReader(this.path);
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);
                String line = new String();
                while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                    User temp = new User(line);
                    this.allUsers.add(new User(line));
                }
                bufferedReader.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error in Open File", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public Vector<User> getAllUsers() {
        return allUsers;
    }

}
