import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class View extends JFrame {

    int width = 800;
    int height = 600;

    Color[] circleColors = {Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.YELLOW, Color.PINK};

    public View() {
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("FlyWeight");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel drawingPanel = new JPanel();
        JPanel infoPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JButton normalDrawButton = new JButton("Normal");
        JButton flyweightDrawButton = new JButton("Flyweight");
        JButton clearButton = new JButton("Clear");

        JLabel normalLabel = new JLabel("0");
        JLabel flyweightLabel = new JLabel("0");

        contentPane.add(drawingPanel, BorderLayout.CENTER);
        infoPane.add(normalLabel, BorderLayout.WEST);
        infoPane.add(normalDrawButton, BorderLayout.WEST);
        infoPane.add(clearButton, BorderLayout.CENTER);
        infoPane.add(flyweightDrawButton, BorderLayout.EAST);
        infoPane.add(flyweightLabel, BorderLayout.EAST);
        contentPane.add(infoPane, BorderLayout.SOUTH);

        this.add(contentPane);
        this.setVisible(true);

        normalDrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Graphics g = drawingPanel.getGraphics();
                long startTime = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    g.setColor(getRandomColor());
                    g.fillOval(getRandomX(), getRandomY(), getRandomX(), getRandomY());
                }

                long stopTime = System.currentTimeMillis();
                normalLabel.setText(Long.toString(stopTime - startTime));

            }
        });

        flyweightDrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Graphics g = drawingPanel.getGraphics();
                long startTime = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    Circle circle = CircleFactory.getCircle(getRandomColor());
                    circle.draw(g, getRandomX(), getRandomY(), getRandomX(), getRandomY());
                }

                long stopTime = System.currentTimeMillis();
                flyweightLabel.setText(Long.toString(stopTime - startTime));

            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.removeAll();
                drawingPanel.repaint();
            }
        });
    }

    private Color getRandomColor(){
        Random randomGenerator = new Random();
        int randInt = randomGenerator.nextInt(7);
        return circleColors[randInt];
    }
    private int getRandomX(){ return (int)(Math.random()*width); }
    private int getRandomY(){ return (int)(Math.random()*width); }

    public static void main(String[] args) {
        new View();
    }
}
