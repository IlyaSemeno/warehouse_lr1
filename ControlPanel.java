
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class ControlPanel extends JPanel {
    private ExpertSystemUI expertSystemUI;

    public ControlPanel(ExpertSystemUI expertSystemUI) {
        this.expertSystemUI = expertSystemUI;

        setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertSystemUI.restart(); // Вызываем метод restart из ExpertSystemUI
            }
        });
        add(restartButton);

        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement help functionality here
                // For now, just display a message
                JOptionPane.showMessageDialog(ControlPanel.this, expertSystemUI.getCurrentQuestion().getHelpMessage());
            }
        });
        add(helpButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}
