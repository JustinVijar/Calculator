import javax.swing.*;
public class GUI extends JFrame {

    private StringBuilder numberStr = new StringBuilder("0");
    private double bigNumber = 0;
    private String currentOperation = null;
    private JPanel mainPanel;
    private JLabel numberDisplay;
    private JButton backspaceButton;
    private JButton CEButton;
    private JButton CButton;
    private JButton divideButton;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton multiplyButton;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton minusButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton plusButton;
    private JButton button0;
    private JButton dotButton;
    private JButton equalButton;

    public GUI() {
        initializeUI();
        buttonAction();
    }

    private void initializeUI() {
        setContentPane(mainPanel);
        setTitle("Calculator");
        setSize(250, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        updateDisplayNumber();
    }
    private void checkNumberStringZero() {
        if (numberStr.toString().equals("0")) {
            numberStr = new StringBuilder();
        }
    }

    private void updateDisplayNumber() {
        numberDisplay.setText(numberStr.toString());
    }

    private void displayBigNumber() {
        numberDisplay.setText(String.valueOf(bigNumber));
    }

    private void clearDisplayNumber() {
        numberDisplay.setText("0");
    }

    private void clearNumberString() {
        numberStr = new StringBuilder("0");
    }

    private void clearAll() {
        clearNumberString();
        clearDisplayNumber();
        bigNumber = 0;
        currentOperation = null;
    }

    private void buttonAction() {
        backspaceButton.addActionListener(e -> {
            if (numberStr.length() > 0) {
                numberStr.deleteCharAt(numberStr.length() - 1);
            }
            updateDisplayNumber();
            if (numberStr.length() == 0) {
                numberDisplay.setText("0");
            }
        });

        CButton.addActionListener(e -> {
            clearAll();
        });

        CEButton.addActionListener(e -> {
            clearNumberString();
            clearDisplayNumber();
        });

        dotButton.addActionListener(e -> {
            if (!numberStr.toString().contains(".")) {
                numberStr.append(".");
            }
            updateDisplayNumber();
        });

        button0.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("0");
            updateDisplayNumber();
        });

        button1.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("1");
            updateDisplayNumber();
        });

        button2.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("2");
            updateDisplayNumber();
        });

        button3.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("3");
            updateDisplayNumber();
        });

        button4.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("4");
            updateDisplayNumber();
        });

        button5.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("5");
            updateDisplayNumber();
        });

        button6.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("6");
            updateDisplayNumber();
        });

        button7.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("7");
            updateDisplayNumber();
        });

        button8.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("8");
            updateDisplayNumber();
        });

        button9.addActionListener(e -> {
            checkNumberStringZero();
            numberStr.append("9");
            updateDisplayNumber();
        });

        plusButton.addActionListener(e -> {
            performOperation("+");
        });

        minusButton.addActionListener(e -> {
            performOperation("-");
        });

        divideButton.addActionListener(e -> {
            performOperation("/");
        });

        multiplyButton.addActionListener(e -> {
            performOperation("*");
        });

        equalButton.addActionListener(e -> {
            performOperation("=");
        });
    }

    private void performOperation(String operation) {
        if (currentOperation == null) {
            // If no previous operation, set bigNumber to the current number
            bigNumber = Double.parseDouble(numberStr.toString());
        } else {
            double currentBigDecimal = Double.parseDouble(numberStr.toString());
            switch (currentOperation) {
                case "+":
                    bigNumber = bigNumber + currentBigDecimal;
                    break;
                case "-":
                    bigNumber = bigNumber - currentBigDecimal;
                    break;
                case "/":
                    if (currentBigDecimal == 0) {
                        // Handle division by zero
                        numberDisplay.setText("Error");
                        return;
                    }
                    bigNumber = bigNumber / currentBigDecimal;
                    break;
                case "*":
                    bigNumber = bigNumber * currentBigDecimal;
                    break;
            }
        }

        // Update the current operation
        if (!operation.equals("=")) {
            currentOperation = operation;
        } else {
            currentOperation = null;

        }
        clearNumberString();
        displayBigNumber();
    }

    public static void main(String[] args) {
        GUI g = new GUI();
    }
}