# GUI-Settings-Saver
Saves a GUI's settings, and loads them for convenience.

Settings are stored to and parsed from a .xml file. Beware that these files can easily be edited, and GUI settings could be changed manually. This is good to note in the case that you might rely on your GUI to enable/disable features based on certain requirements, but these parameters can be avoided by changing the .xml file's settings.

There is an example test-file that demonstrates the file saving capabilities this program has.

###Example to load settings:
```java
SettingsLoader loader = new SettingsLoader(new File(System.getProperty("user.home") + "/Desktop")));
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
```

###Example to save settings:
```java
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

                saver.saveToFile(System.getProperty("user.home") + "/Desktop");
            }
        });
```

###General Rules:
Objects you wish to save **MUST** be saved **and** loaded with the same IDs. For example, if you save a JComboBox `.addComboBox(getComboBox1(), "comboBox1")` you need to load it the same way, using "comboBox1" as the parameter ID: `.loadComboBox(getComboBox1(), "comboBox1")`. Notice how both saving and loading share the same **comboBox1** parameter ID.
