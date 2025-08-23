package com.mycompany.gui_lab_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    
    private JLabel nameLabel, emailLabel, genderLabel, countryLabel, passwordLabel, confirmPasswordLabel;
    private JTextField nameTextField, emailTextField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JList<String> countryList;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton submitButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(10);   

        emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(20);  

        genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        countryLabel = new JLabel("Country:");
        String[] countries = {"USA", "Canada", "UK", "Bangladesh", "Australia"};
        countryList = new JList<>(countries);

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);  

        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField(20);  

        submitButton = new JButton("Submit");

       
        setLayout(new GridLayout(7, 2, 5, 5));

        add(nameLabel);
        add(nameTextField);

        add(emailLabel);
        add(emailTextField);

        add(genderLabel);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        add(genderPanel);

        add(countryLabel);
        add(new JScrollPane(countryList));

        add(passwordLabel);
        add(passwordField);

        add(confirmPasswordLabel);
        add(confirmPasswordField);

        add(new JLabel()); // empty space
        add(submitButton);

        // Button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" :
                                (femaleRadioButton.isSelected() ? "Female" : "");
                String country = countryList.getSelectedValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Please fill all required fields!");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Passwords do not match!");
                    return;
                }

                JOptionPane.showMessageDialog(RegistrationForm.this, "Registration Successful!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistrationForm registrationForm = new RegistrationForm();
                registrationForm.setVisible(true);
            }
        });
    }
}
