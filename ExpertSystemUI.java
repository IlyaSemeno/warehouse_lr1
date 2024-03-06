import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExpertSystemUI extends JFrame {
    private Question currentQuestion;
    private JLabel questionLabel;
    private JLabel stateLabel; // Окно состояния системы
    private JPanel buttonPanel;

    public ExpertSystemUI(Question initialQuestion) {
        setTitle("Expert System Interface");
        setSize(600, 400); // Увеличил размер окна, чтобы уместились все компоненты
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentQuestion = initialQuestion;

        questionLabel = new JLabel(currentQuestion.getText());
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Увеличение размера шрифта вопроса
        add(questionLabel, BorderLayout.NORTH);

        stateLabel = new JLabel("Состояние: 0"); // Начальное состояние системы - 0
        add(stateLabel, BorderLayout.WEST); // Отображается рядом с вопросом

        buttonPanel = new JPanel(new GridLayout(1, currentQuestion.getAnswers().size()));
        createAnswerButtons();

        add(buttonPanel, BorderLayout.CENTER); // Перемещаем кнопки в центр

        ControlPanel controlPanel = new ControlPanel(this);
        add(controlPanel, BorderLayout.SOUTH); // Помещаем панель управления вниз

        setVisible(true);
    }

    private void createAnswerButtons() {
        List<Answer> answers = currentQuestion.getAnswers();

        buttonPanel.removeAll();

        for (Answer answer : answers) {
            JButton answerButton = new JButton(answer.getText());
            answerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentQuestion = answer.getNextQuestion();
                    if (currentQuestion != null) {
                        questionLabel.setText(currentQuestion.getText());
                        createAnswerButtons();
                    } else {
                        JOptionPane.showMessageDialog(ExpertSystemUI.this, "End of questions.");
                        stateLabel.setText("State: 1"); // Изменение состояния системы на 1 при достижении конца вопросов
                    }
                }
            });
            buttonPanel.add(answerButton);
        }

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    public void restart() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                new ExpertSystemUI(new InitialQuestion().getInitialQuestion());
            }
        });
    }
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExpertSystemUI(new InitialQuestion().getInitialQuestion());
            }
        });
    }
}