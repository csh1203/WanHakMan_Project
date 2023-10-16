import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("완벽한 학급 만들기");
        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the frame size to match the screen size
        frame.setSize(screenSize);

        // Set the frame's content pane to your GUI
        // frame.getContentPane().add(yourGUIComponent);

        // Set the frame to be visible
        frame.setVisible(true);

        // Exit the program when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}