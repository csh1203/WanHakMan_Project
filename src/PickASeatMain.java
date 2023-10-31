import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.FileLock;

public class PickASeatMain {
    public static void main(String args[]){
        new PickASeatMain(15, 3);
    }
    PickASeatMain(int people, int division){
        Color setting = new Color(0x474747);
        Color fontColor = new Color(0x47815E);

        // JFrame 생성
        JFrame frame = new JFrame("자리 뽑기");
        frame.setBounds(100, 100, 1280, 832);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        JButton settingBtn = new JButton("설정");
        settingBtn.setBounds(1100, 31, 100, 33);
        settingBtn.setFont(new Font("Noto Sans", Font.BOLD, 24)); // 폰트 및 글자 크기 설정
        settingBtn.setForeground(setting); // 글자 색상 설정

        // 버튼의 배경을 없애기
        settingBtn.setOpaque(false);
        settingBtn.setContentAreaFilled(false);
        settingBtn.setBorderPainted(false);
        settingBtn.setFocusPainted(false);

        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new PickASeatSetting();
            }
        });
        frame.add(settingBtn);

        ImageIcon home = new ImageIcon("img/homeBtn.png");
        JButton homeBtn = new JButton(home);
        homeBtn.setBounds(1190, 24, 45, 45);

        // 버튼의 배경을 없애기
        homeBtn.setOpaque(false);
        homeBtn.setContentAreaFilled(false);
        homeBtn.setBorderPainted(false);
        homeBtn.setFocusPainted(false);
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Main();
            }
        });
        frame.add(homeBtn);

        ImageIcon teachingDeskImg = new ImageIcon("img/teachingDesk.png");
        JLabel teachingDeskLabel = new JLabel(teachingDeskImg);
        teachingDeskLabel.setBounds(463, 104, 355,95);
        frame.add(teachingDeskLabel);

        int seatHeight = (int)(Math.ceil(people / (division * 2.0)));
        seatHeight = seatHeight * 75 + (seatHeight - 1) * 16;
        JPanel seat = new JPanel();
        seat.setLayout(new GridLayout(1, division));
//        seat.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        seat.setBounds(0, 259, 1280, seatHeight);

        int[] divisionCnt = new int[division];
        int Remain = people % (division * 2);
        for(int i = 0; i<division; i++){
            int plus = 0;
            if(Remain - 2 >= 0) {
                plus = 2;
                Remain -= 2;
            }else if(Remain - 1 >= 0){
                plus = 1;
                Remain -= 1;
            }
            int repeat = (people / (division * 2)) * 2 + plus;
            divisionCnt[i] = repeat;
        }
//        JOptionPane.showMessageDialog(frame, divisionCnt);
//        System.out.println(divisionCnt[0] + " "+  divisionCnt[1] + " " +  divisionCnt[2]);

        for(int i = 0; i<divisionCnt.length; i++){

            int cnt = 0;
            int repeat = divisionCnt[i];
            int height = (int)(Math.ceil(repeat / 2.0));
            height = height * 75 + (height - 1) + 16;

            int margin = (1200 / division - 259) / 2;

            JPanel divisions = new JPanel();
            divisions.setLayout(new GridLayout((int)(Math.ceil(repeat / 2.0)),2));
            divisions.setBounds(margin, 0, 259, height);

            JLabel l = new JLabel();
            l.setSize(259, height);
            l.setHorizontalAlignment(SwingConstants.CENTER);
            l.setOpaque(true);

            for(int j = 0; j<(int)(Math.ceil(repeat / 2.0)); j++){ // 0 1 2
                int index = (i + 1) * 2 - 1;
                for(int k = index; k<=index + 1; k++){
                    cnt++;
                    if(cnt > repeat) break;
                    String tableNumber = (k + (j * 6))+"";
                    JLabel table = new JLabel(tableNumber);
                    table.setIcon(new ImageIcon("img/sm_table.png"));
                    table.setHorizontalTextPosition(JLabel.CENTER);
                    table.setVerticalTextPosition(JLabel.CENTER);
                    table.setForeground(fontColor);
                    table.setFont(new Font("Noto Sans", Font.BOLD, 20)); // 폰트 및 글자 크기 설정
                    divisions.add(table);
                }
            }
//            seat.add(divisions);
            l.add(divisions);
            seat.add(l);
        }
        frame.add(seat);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
