import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ChoosingAPresenterMain {
//    public static void main(String args[]){
//        new choosingAPresenterMain();
//    }
    public ChoosingAPresenterMain(String allPerson, String presentPerson, ArrayList<Integer> exceptPerson) {
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

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(0, 134, 851, 123);
        resultLabel.setFont(new Font("Noto Sans", Font.PLAIN, 80)); // 폰트 및 글자 크기 설정
        resultLabel.setHorizontalAlignment(JLabel.CENTER); // 텍스트를 가운데에 정렬
        resultFrame.add(resultLabel);

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
                List<Integer> randomNumbers = generateRandomNumbers(1, Integer.parseInt(allPerson), Integer.parseInt(presentPerson), exceptPerson);
                resultLabel.setText(randomNumbers.toString().substring(1, randomNumbers.toString().length()-1));
            }
        });
        frame.add(makePresenterBtn);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static List<Integer> generateRandomNumbers(int min, int max, int count, ArrayList<Integer> exceptPerson) {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        while (numbers.size() < count) {
            int randomNum = rand.nextInt(max - min + 1) + min;
            if (!exceptPerson.contains(randomNum) && !numbers.contains(randomNum)) {
                numbers.add(randomNum);
            }
        }
        return numbers;
    }
}
