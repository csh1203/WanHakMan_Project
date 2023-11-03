import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Main extends Frame {

    SettingClass setting = new SettingClass();
    Color mainColor = setting.mainColor;
    public static void main(String[] args) {
       new Main();
//        서현
//        - 메인 (0)
//        - 자리뽑기
//        - 발표자정하기
//
//        가윤
//        - 1인1역
//        - 회장선거
    }

    public Main() {
        // JFrame 생성
        JFrame frame = new JFrame("완벽한 학급 만들기");
        frame.setBounds(100, 100, 1280, 832);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        frame.setBackground(Color.WHITE);

        JLabel titleImg = new JLabel();
        titleImg.setBounds(512, 85, 256, 133);
        titleImg.setIcon(new ImageIcon("img/title.png"));
        frame.getContentPane().add(titleImg);

//      JPanel 생성
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(257, 530, 765, 210); // JPanel의 크기를 설정


        RoundedButton button1 = new RoundedButton("");
        button1.setBounds(0, 0, 375, 100);
        button1.setLayout(new BorderLayout());

        ImageIcon InnerTextImg1 = new ImageIcon("img/mainPickASeatBtn.png");
        JLabel label1 = new JLabel(InnerTextImg1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);

        button1.add(label1);
        panel.add(button1);

        RoundedButton button2 = new RoundedButton("");
        button2.setBounds(390, 0, 375, 100);
        button2.setLayout(new BorderLayout());

        ImageIcon InnerTextImg2 = new ImageIcon("img/mainPickClassPresidentBtn.png");
        JLabel label2 = new JLabel(InnerTextImg2);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setVerticalAlignment(SwingConstants.CENTER);

        button2.add(label2);
        panel.add(button2);

        RoundedButton button3 = new RoundedButton("");
        button3.setBounds(0, 110, 375, 100);
        button3.setLayout(new BorderLayout());

        ImageIcon InnerTextImg3 = new ImageIcon("img/mainClassRoleBtn.png");
        JLabel label3 = new JLabel(InnerTextImg3);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setVerticalAlignment(SwingConstants.CENTER);

        button3.add(label3);
        panel.add(button3);

        RoundedButton button4 = new RoundedButton("");
        button4.setBounds(390, 110, 375, 100);
        button4.setLayout(new BorderLayout());

        ImageIcon InnerTextImg4 = new ImageIcon("img/mainPickPresenterBtn.png");
        JLabel label4 = new JLabel(InnerTextImg4);
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setVerticalAlignment(SwingConstants.CENTER);

        button4.add(label4);
        panel.add(button4);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new PickASeatSetting();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ClassPresidentElection();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DetermineRole();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ChoosingAPresenterSetting();
            }
        });

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
class RoundedButton extends JButton {
    private int arcWidth = 20;
    private int arcHeight = 20;

    SettingClass setting = new SettingClass();
    Color mainColor = setting.mainColor;

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBackground(mainColor); // JButton의 배경색을 초록색으로 설정
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground());
            setForeground(mainColor);
        } else {
            g.setColor(getBackground());
            setForeground(mainColor);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));
    }
}