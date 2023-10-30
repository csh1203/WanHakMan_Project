import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainScreen {
    public mainScreen() {
        // JFrame 생성
        JFrame frame = new JFrame("완벽한 학급 만들기");
        frame.setBounds(100, 100, 1280, 832);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        frame.setBackground(Color.WHITE);

        JLabel titleImg = new JLabel();
        titleImg.setBounds(512, 85, 256, 133);
        titleImg.setIcon(new ImageIcon("img/title.png"));
        frame.getContentPane().add(titleImg);

        // JPanel 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.setBounds(167, 351, 923, 261); // JPanel의 크기를 설정

        ImageIcon btnImg1 = new ImageIcon("img/pickSeat.png");
        ImageIcon btnImg2 = new ImageIcon("img/bossPick.png");
        ImageIcon btnImg3 = new ImageIcon("img/onePerson.png");
        ImageIcon btnImg4 = new ImageIcon("img/presenterPick.png");

        JButton btn1 = new JButton(btnImg1);
        JButton btn2 = new JButton(btnImg2);
        JButton btn3 = new JButton(btnImg3);
        JButton btn4 = new JButton(btnImg4);

        // 버튼의 배경을 없애기
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);

        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);

        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);

        btn4.setOpaque(false);
        btn4.setContentAreaFilled(false);
        btn4.setBorderPainted(false);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new pickASeat();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new classPresidentElection();
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new determineRole();
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new choosingAPresenter();
            }
        });

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
