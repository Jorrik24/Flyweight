import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class View extends JFrame {

    int width = 800;
    int height = 600;

    Color[] circleColors = {Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.YELLOW, Color.PINK, Color.BLACK, Color.BLACK};

    public static void main(String[] args) {
        new View();
    }

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

        JButton flyweightDrawButton = new JButton("Flyweight");

        contentPane.add(drawingPanel, BorderLayout.CENTER);
        infoPane.add(flyweightDrawButton, BorderLayout.EAST);
        contentPane.add(infoPane, BorderLayout.SOUTH);

        flyweightDrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Graphics g = drawingPanel.getGraphics();

                for (int i = 0; i < 100000; i++) {
                    CircleColor color = CircleColorFactory.getCircleColor(getRandomColor());
                    Circle circle = new Circle(color, getRandomX(), getRandomY(), getRandomX(), getRandomY());
                    circle.draw(g);
                }

                printHashmap();
            }
        });

        this.add(contentPane);
        this.setVisible(true);
    }

    private void printHashmap() {
        CircleColorFactory.circlesByColor.entrySet().forEach(color -> {
            System.out.println(color.getValue().color);
        });
    }

    private Color getRandomColor(){
        Random randomGenerator = new Random();
        int randInt = randomGenerator.nextInt(9);
        return circleColors[randInt];
    }
    private int getRandomX(){ return (int)(Math.random()*width); }
    private int getRandomY(){ return (int)(Math.random()*width); }


}
