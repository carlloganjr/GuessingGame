package guessinggame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Action;

public class GuessingGame extends JFrame{
    
    JFrame frame = new JFrame("Hi-Lo Guessing Game");
    JLabel pLabel = new JLabel("Enter a number between 1 and 100:");
    JLabel title = new JLabel("Hi-Lo Guessing Game");
    JTextField textField = new JTextField();
    JButton button;
    String guess;
    int setGuess;
    private int number;
    int count;
    private int guessAgain;
//    Scanner guess = new Scanner(System.in);
//    Scanner yes_no = new Scanner(System.in);
    String playAgain;
//    String label;
    JLabel bottomLabel = new JLabel(
            "Enter a number in the field above and press 'Guess!'");
    JLabel guessCount = new JLabel("Number of guesses: 0");
    JButton newGame = new JButton("New Game");

    public static void main(String[] args) {
        GuessingGame play = new GuessingGame();
        play.newGame();
    }
    
    GuessingGame() {
        this.button = new JButton("Guess!");
        
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font font24 = new Font("SansSerif", Font.BOLD, 24);
        Font font14 = new Font("SansSerif", Font.PLAIN, 14);
        
        title.setFont(font24);
        pLabel.setFont(font14);
        textField.setFont(font14);
        bottomLabel.setFont(font14);
        guessCount.setFont(font14);
        
        title.setBounds(10, 15, 420, 25);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(title);
        
        pLabel.setBounds(10, 75, 280, 25);
        pLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(pLabel);
        
        textField.setBounds(300, 75, 50, 25);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(textField);
        
        button.setBounds(158, 120, 100, 25);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(button);
        
        bottomLabel.setBounds(10, 160, 400, 50);
        bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(bottomLabel);
        
        newGame.setBounds(10, 220, 97, 25);
        newGame.setHorizontalAlignment(SwingConstants.LEFT);
        frame.getContentPane().add(newGame);
        
        guessCount.setBounds(210, 210, 200, 50);
        guessCount.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(guessCount);
        
        frame.setSize(450, 300);
        frame.setVisible(true);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guess();
            }
        });
        frame.getRootPane().setDefaultButton(button);
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomLabel.setText("You've started a new game!");
                newGame();
            }
        });
        
    }
    
    void guess() {
            guess = textField.getText();
            this.setGuess = Integer.parseInt(guess);
            guessAgain = this.setGuess;
            if (guessAgain == number) {
                bottomLabel.setText(
                        "You WON! You guessed the number " + number
                ); 
//                playAgain = this.guess;
//                if (playAgain.toLowerCase().equals("y") 
//                        || playAgain.toLowerCase().equals("yes")) {
//                    bottomLabel.setText("Enter a number to start a new game!");
//                    newGame();
//                }
//                else {
//                    bottomLabel.setText("HOORAY!");
////                    System.exit(0);
//                }
            }
            else if (guessAgain > number && guessAgain > number + 25 && guessAgain != 0) {
                bottomLabel.setText("You've guessed too high! Try again.");
            }
            else if (guessAgain < number && guessAgain < number - 25 && guessAgain != 0) {
                bottomLabel.setText("You've guessed too low! Try again.");
            }
            else if (guessAgain != number && guessAgain < number + 10 
                    && guessAgain > number - 10 && guessAgain != 0) {
                bottomLabel.setText("You are getting warmer! Try again.");
            }
//            else if (guessAgain == 0) {
//                System.exit(0);
//            }
            else {
                bottomLabel.setText("You're a little cold. Try again.");
            }
            count++;
            guessCount.setText("Number guesses: " + count);
            textField.setText("");
//        bottomLabel.setText("Thanks for playing!");
    }
    
    public void newGame() {
        number = (int)(Math.random()*100) + 1;
        count = 0;
        guessCount.setText("Number guesses: " + count);
        
    }
    
}
