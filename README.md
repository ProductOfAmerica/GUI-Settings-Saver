# GUI-Settings-Saver
Saves a GUI's settings, and loads them for convenience

There is an example test-file that demonstrates the file saving capabilities this program has.

Example:
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
