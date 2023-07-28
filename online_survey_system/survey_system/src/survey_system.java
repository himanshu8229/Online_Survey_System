import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class survey_system {
    JFrame survey=new JFrame();
    private JButton Button;
    private JTextField textField1;
    private JTextArea textArea1;
    private JSlider slider1;
    private JLabel rate;
    private JPanel SurveyPanel;
    private JTextField textField2;


    public survey_system() {
        survey.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        survey.setContentPane(SurveyPanel);
        survey.pack();
        survey.setLocationRelativeTo(null);
        survey.setVisible(true);
        slider1.setMinimum(0);
        slider1.setMaximum(5);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setMajorTickSpacing(1);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("") ||textField2.getText().equals("")|| textArea1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Fill NAME and Feedback to submit.");
                } else {
                    try {
                        String sql = "insert into rate" + "(Name,Rating,Feedback)" + "values (?,?,?)";
                        Class.forName("Thankyou");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "root");
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, textField1.getText());
                        statement.setString(1, textField2.getText());
                        statement.setString(2, String.valueOf(slider1.getValue()));
                        statement.setString(3, textArea1.getText());
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "SUCCESSFULL");
                        textField1.setText("");
                        textField2.setText("");
                        textArea1.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        slider1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rate.setText(String.valueOf(slider1.getValue())+" Star");
            }
        });
    }
    public static void main(String[] args) {
        new survey_system();


    }
}

