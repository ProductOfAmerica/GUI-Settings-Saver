package SettingsSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Test extends JFrame {
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        initComponents();

        SettingsLoader loader = new SettingsLoader(new File("C:\\Users\\lee.tarnow\\Desktop\\file.xml"));
        loader.loadCheckBox(getCheckBox1(), "checkBox1")
                .loadComboBox(getComboBox1(), "comboBox1")
                .loadTextField(getTextField1(), "textField1")
                .loadTextArea(getTextArea1(), "textArea1")
                .loadSlider(getSlider1(), "slider1")
                .loadSpinner(getSpinner1(), "spinner1")
                .loadButton(getButton1(), "button1")
                .loadRadioButton(getRadioButton1(), "radioButton1")
                .loadLabel(getLabel1(), "label1")
                .loadToggleButton(getToggleButton1(), "toggleButton1")
                .loadTextPane(getTextPane1(), "textPane1");

        setVisible(true);
    }

    private void initComponents() {
        comboBox1 = new JComboBox<>();
        textField1 = new JTextField();
        checkBox1 = new JCheckBox();
        textArea1 = new JTextArea();
        radioButton1 = new JRadioButton();
        toggleButton1 = new JToggleButton();
        button1 = new JButton();
        slider1 = new JSlider();
        label1 = new JLabel();
        textPane1 = new JTextPane();
        spinner1 = new JSpinner();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SettingsSaver saver = new SettingsSaver();
                saver.addCheckBox(getCheckBox1(), "checkBox1")
                        .addComboBox(getComboBox1(), "comboBox1")
                        .addLabel(getLabel1(), "label1")
                        .addRadioButton(getRadioButton1(), "radioButton1")
                        .addToggleButton(getToggleButton1(), "toggleButton1")
                        .addButton(getButton1(), "button1")
                        .addTextField(getTextField1(), "textField1")
                        .addTextArea(getTextArea1(), "textArea1")
                        .addTextPane(getTextPane1(), "textPane1")
                        .addSpinner(getSpinner1(), "spinner1")
                        .addSlider(getSlider1(), "slider1");

                saver.saveToFile("C:\\Users\\lee.tarnow\\Desktop\\file.xml");
            }
        });

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Before Text1",
            "Before Text2",
            "Before Text3",
            "Before Text4"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(10, 5, 135, 40);

        //---- textField1 ----
        textField1.setText("Before Text");
        contentPane.add(textField1);
        textField1.setBounds(10, 90, 120, textField1.getPreferredSize().height);

        //---- checkBox1 ----
        checkBox1.setText("CheckBox");
        contentPane.add(checkBox1);
        checkBox1.setBounds(new Rectangle(new Point(10, 55), checkBox1.getPreferredSize()));

        //---- textArea1 ----
        textArea1.setText("Before Text");
        contentPane.add(textArea1);
        textArea1.setBounds(10, 145, 252, 92);

        //---- radioButton1 ----
        radioButton1.setText("RadioButton");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(10, 118), radioButton1.getPreferredSize()));

        //---- toggleButton1 ----
        toggleButton1.setText("ToggleButton");
        contentPane.add(toggleButton1);
        toggleButton1.setBounds(new Rectangle(new Point(10, 245), toggleButton1.getPreferredSize()));

        //---- button1 ----
        button1.setText("Button");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(10, 280), button1.getPreferredSize()));
        contentPane.add(slider1);
        slider1.setBounds(new Rectangle(new Point(10, 320), slider1.getPreferredSize()));

        //---- label1 ----
        label1.setText("Before Text");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(300, 20), label1.getPreferredSize()));

        //---- textPane1 ----
        textPane1.setText("Before Text");
        contentPane.add(textPane1);
        textPane1.setBounds(300, 100, 155, 160);
        contentPane.add(spinner1);
        spinner1.setBounds(300, 60, 110, spinner1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(515, 415));
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JToggleButton toggleButton1;
    private JButton button1;
    private JSlider slider1;
    private JLabel label1;
    private JTextPane textPane1;
    private JSpinner spinner1;


    public JComboBox<String> getComboBox1() {
        return comboBox1;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JRadioButton getRadioButton1() {
        return radioButton1;
    }

    public JToggleButton getToggleButton1() {
        return toggleButton1;
    }

    public JButton getButton1() {
        return button1;
    }

    public JSlider getSlider1() {
        return slider1;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public JTextPane getTextPane1() {
        return textPane1;
    }

    public JSpinner getSpinner1() {
        return spinner1;
    }
}
