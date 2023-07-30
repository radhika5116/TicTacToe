import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tictactoe1 implements ActionListener {

    JFrame frame = new JFrame("Tic Tac Toe");
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    Tictactoe1() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setBackground(Color.BLACK);
        frame.setForeground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.CYAN);
        textfield.setForeground(Color.DARK_GRAY);
        textfield.setFont(new Font("Serif", Font.BOLD, 35));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 400, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(Color.BLUE);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textfield);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        player1_turn = false;
        textfield.setText("O turn");
    }
    

    public void check() {
        if ((buttons[0].getText().equals("X"))
         && (buttons[1].getText().equals("X"))
         && (buttons[2].getText().equals("X")))
        {
            xWin(0, 1, 2);
        } 
        else if ((buttons[3].getText().equals("X"))
         && (buttons[4].getText().equals("X"))
        && (buttons[5].getText().equals("X")))
        {
            xWin(3, 4, 5);
        }
        else if ((buttons[6].getText().equals("X")) 
        && (buttons[7].getText().equals("X"))
        && (buttons[8].getText().equals("X"))) 
        {
            xWin(6, 7, 8);
        } 
        else if ((buttons[0].getText().equals("X")) 
        && (buttons[3].getText().equals("X"))
        && (buttons[6].getText().equals("X")))
        {
            xWin(0, 3, 6);
        } 
        else if ((buttons[1].getText().equals("X")) 
        && (buttons[4].getText().equals("X"))
        && (buttons[7].getText().equals("X"))) 
        {
            xWin(1, 4, 7);
        } 
        else if ((buttons[2].getText().equals("X")) 
        && (buttons[5].getText().equals("X"))
        && (buttons[8].getText().equals("X"))) 
        {
            xWin(2, 5, 8);
        } 
        else if ((buttons[0].getText().equals("X")) 
        && (buttons[4].getText().equals("X"))
        && (buttons[8].getText().equals("X"))) 
        {
            xWin(0, 4, 8);
        } 
        else if ((buttons[2].getText().equals("X")) 
        && (buttons[4].getText().equals("X"))
        && (buttons[6].getText().equals("X"))) 
        {
            xWin(2, 4, 6);
        } 
        else if ((buttons[0].getText().equals("O")) 
        && (buttons[1].getText().equals("O"))
        && (buttons[2].getText().equals("O"))) 
        {
            oWin(0, 1, 2);
        } 
        else if ((buttons[3].getText().equals("O")) 
        && (buttons[4].getText().equals("O"))
        && (buttons[5].getText().equals("O"))) 
        {
            oWin(3, 4, 5);
        } 
        else if ((buttons[6].getText().equals("O")) 
        && (buttons[7].getText().equals("O"))
        && (buttons[8].getText().equals("O"))) 
        {
            oWin(6, 7, 8);
        } 
        else if ((buttons[0].getText().equals("O")) 
        && (buttons[3].getText().equals("O"))
        && (buttons[6].getText().equals("O"))) 
        {
            oWin(0, 3, 6);
        } 
        else if ((buttons[1].getText().equals("O")) 
        && (buttons[4].getText().equals("O"))
        && (buttons[7].getText().equals("O"))) 
        {
            oWin(1, 4, 7);
        } 
        else if ((buttons[2].getText().equals("O")) 
        && (buttons[5].getText().equals("O"))
        && (buttons[8].getText().equals("O"))) 
        {
            oWin(2, 5, 8);
        } 
        else if ((buttons[0].getText().equals("O")) 
        && (buttons[4].getText().equals("O"))
        && (buttons[8].getText().equals("O"))) 
        {
            oWin(0, 4, 8);
        } 
        else if ((buttons[2].getText().equals("O")) 
        && (buttons[4].getText().equals("O"))
        && (buttons[6].getText().equals("O"))) 
        {
            oWin(2, 4, 6);
        }
    }

    public void xWin(int a, int b, int c) {
        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWin(int a, int b, int c) {
        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O win");
    }
    public static void main(String[] args) {
        Tictactoe1 tictactoe =new Tictactoe1();
    }
}
