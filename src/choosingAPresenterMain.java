import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class choosingAPresenterMain {
//    public static void main(String args[]){
//        new choosingAPresenterMain();
//    }
    public choosingAPresenterMain(String allPerson, String presentPerson, String exceptPerson) {
        // JFrame 생성
        JFrame frame = new JFrame("발표자 정하기");
        frame.setBounds(100, 100, 1280, 832);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 동작 설정
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel resultFrame = new JLabel();
        resultFrame.setBounds(215, 140, 851, 390);
        resultFrame.setIcon(new ImageIcon("img/presenterResultFrame.png"));
        frame.getContentPane().add(resultFrame);

        int minValue = 1;
        int maxValue = Integer.parseInt(allPerson);
        int excludedNumber;
        if(exceptPerson.isEmpty()) excludedNumber = -1;
        else excludedNumber = Integer.parseInt(exceptPerson);
        int numberOfRandomNumbers = Integer.parseInt(presentPerson);

        Set<Integer> randomNumbers = new HashSet<>();

        Random random = new Random();

        while (randomNumbers.size() < numberOfRandomNumbers) {
            int randomNumber = generateRandomNumber(minValue, maxValue, random);
            if (randomNumber != excludedNumber) {
                randomNumbers.add(randomNumber);
            }
        }
        ArrayList<Integer> sortedList = new ArrayList<>(randomNumbers);
        Collections.sort(sortedList);
        String result = sortedList.toString().substring(1, sortedList.toString().length() - 1);

        JLabel resultLabel = new JLabel(result);
        resultLabel.setBounds(0, 134, 851, 123);
        resultLabel.setFont(new Font("Noto Sans", Font.PLAIN, 80)); // 폰트 및 글자 크기 설정
        resultLabel.setHorizontalAlignment(JLabel.CENTER); // 텍스트를 가운데에 정렬
        resultFrame.add(resultLabel);

//        JLabel makePresenterBtn = new JLabel();
//        makePresenterBtn.setBounds(397, 606, 485, 92);
//        makePresenterBtn.setIcon(new ImageIcon("img/makePresenterBtn.png"));
//        frame.add(makePresenterBtn);

        ImageIcon makePresenterBtnImg = new ImageIcon("img/makePresenterBtn.png");
        JButton makePresenterBtn = new JButton(makePresenterBtnImg);
        makePresenterBtn.setBounds(397, 606, 485, 92);
        makePresenterBtn.setIcon(new ImageIcon("img/makePresenterBtn.png"));

        // 버튼의 배경을 없애기
        makePresenterBtn.setOpaque(false);
        makePresenterBtn.setContentAreaFilled(false);
        makePresenterBtn.setBorderPainted(false);

        makePresenterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomNumber(minValue, maxValue, random);
            }
        });
        frame.add(makePresenterBtn);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    // 주어진 범위 내에서 랜덤 숫자 생성
    public static int generateRandomNumber(int minValue, int maxValue, Random random) {
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }
}
