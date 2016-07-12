# GUI-Settings-Saver
Saves a GUI's settings, and loads them for convenience.

Settings are stored to and parsed from a .xml file. Beware that these files can easily be edited, and GUI settings could be changed manually. This is good to note in the case that you might rely on your GUI to enable/disable features based on certain requirements, but these parameters can be avoided by changing the .xml file's settings.

There is an example test-file that demonstrates the file saving capabilities this program has called "Test.java"

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

Example XML file output after saving:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<gui_settings>
    <check_box id="checkBox1">
        <enabled>true</enabled>
        <selected>true</selected>
    </check_box>
    <combo_box id="comboBox1">
        <enabled>true</enabled>
        <selected_index>2</selected_index>
        <item>Before Text4</item>
        <item>Before Text3</item>
        <item>Before Text2</item>
        <item>Before Text1</item>
    </combo_box>
    <label id="label1">
        <enabled>true</enabled>
        <text>Before Text</text>
    </label>
    <radio id="radioButton1">
        <enabled>true</enabled>
        <selected>true</selected>
    </radio>
    <toggle id="toggleButton1">
        <enabled>true</enabled>
        <selected>true</selected>
    </toggle>
    <button id="button1">
        <enabled>true</enabled>
    </button>
    <text_field id="textField1">
        <enabled>true</enabled>
        <text>Before Text@@@@</text>
    </text_field>
    <text_area id="textArea1">
        <enabled>true</enabled>
        <text>Before Text1234</text>
    </text_area>
    <text_pane id="textPane1">
        <enabled>true</enabled>
        <text>Before Text!!!!!</text>
    </text_pane>
    <spinner id="spinner1">
        <enabled>true</enabled>
        <amount>1111</amount>
    </spinner>
    <slider id="slider1">
        <enabled>true</enabled>
        <amount>72</amount>
    </slider>
</gui_settings>

```

###General Rules:
Objects you wish to save **MUST** be saved **and** loaded with the same IDs.

For example, if you save a JComboBox `.addComboBox(getComboBox1(), "comboBox1")` you need to load it the same way, using "comboBox1" as the parameter ID: `.loadComboBox(getComboBox1(), "comboBox1")`. Notice how both saving and loading share the same **comboBox1** parameter ID.
