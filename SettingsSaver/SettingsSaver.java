package SettingsSaver;

import java.io.*;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static SettingsSaver.ParseConstants.*;
import static java.lang.String.valueOf;

public class SettingsSaver {
    private Document document;
    private Element rootElement;

    public SettingsSaver() {
        initializeFile();
    }

    public SettingsSaver addCheckBox(JCheckBox checkBox, String checkBoxID){
        Element checkBoxElement = addDocumentElement(CHECK_BOX, checkBoxID);
        addToParentElement(checkBoxElement, ENABLED, valueOf(checkBox.isEnabled()));
        addToParentElement(checkBoxElement, SELECTED, valueOf(checkBox.isSelected()));
        return this;
    }

    public SettingsSaver addComboBox(JComboBox<String> comboBox, String comboBoxID){
        Element comboBoxElement = addDocumentElement(COMBO_BOX, comboBoxID);
        addToParentElement(comboBoxElement, ENABLED, valueOf(comboBox.isEnabled()));
        addToParentElement(comboBoxElement, SELECTED_INDEX, valueOf(comboBox.getSelectedIndex()));

        for (int i = comboBox.getModel().getSize() - 1; i >= 0; i--){ //Reverse order...for loading purposes
            addToParentElement(comboBoxElement, COMBO_ITEM, valueOf(comboBox.getModel().getElementAt(i)));
        }
        return this;
    }

    public SettingsSaver addTextField(JTextField textField, String textFieldID){
        Element textFieldElement = addDocumentElement(TEXT_FIELD, textFieldID);
        addToParentElement(textFieldElement, ENABLED, valueOf(textField.isEnabled()));
        addToParentElement(textFieldElement, TEXT, textField.getText());
        return this;
    }

    public SettingsSaver addTextArea(JTextArea textArea, String textAreaID){
        Element textAreaElement = addDocumentElement(TEXT_AREA, textAreaID);
        addToParentElement(textAreaElement, ENABLED, valueOf(textArea.isEnabled()));
        addToParentElement(textAreaElement, TEXT, textArea.getText());
        return this;
    }

    public SettingsSaver addLabel(JLabel label, String labelID){
        Element labelElement = addDocumentElement(LABEL, labelID);
        addToParentElement(labelElement, ENABLED, valueOf(label.isEnabled()));
        addToParentElement(labelElement, TEXT, label.getText());
        return this;
    }

    public SettingsSaver addTextPane(JTextPane textPane, String textPaneID){
        Element textPaneElement = addDocumentElement(TEXT_PANE, textPaneID);
        addToParentElement(textPaneElement, ENABLED, valueOf(textPane.isEnabled()));
        addToParentElement(textPaneElement, TEXT, textPane.getText());
        return this;
    }

    public SettingsSaver addRadioButton(JRadioButton radioButton, String radioButtonID){
        Element radioButtonElement = addDocumentElement(RADIO_BUTTON, radioButtonID);
        addToParentElement(radioButtonElement, ENABLED, valueOf(radioButton.isEnabled()));
        addToParentElement(radioButtonElement, SELECTED, String.valueOf(radioButton.isSelected()));
        return this;
    }

    public SettingsSaver addToggleButton(JToggleButton toggleButton, String toggleButtonID){
        Element toggleButtonElement = addDocumentElement(TOGGLE_BUTTON, toggleButtonID);
        addToParentElement(toggleButtonElement, ENABLED, valueOf(toggleButton.isEnabled()));
        addToParentElement(toggleButtonElement, SELECTED, String.valueOf(toggleButton.isSelected()));
        return this;
    }

    public SettingsSaver addButton(JButton button, String buttonID){
        Element buttonElement = addDocumentElement(BUTTON, buttonID);
        addToParentElement(buttonElement, ENABLED, valueOf(button.isEnabled()));
        return this;
    }

    public SettingsSaver addSpinner(JSpinner spinner, String spinnerID){
        Element spinnerElement = addDocumentElement(SPINNER, spinnerID);
        addToParentElement(spinnerElement, ENABLED, valueOf(spinner.isEnabled()));
        addToParentElement(spinnerElement, AMOUNT, valueOf(spinner.getValue().toString().replaceAll(",", "")));
        return this;
    }

    public SettingsSaver addSlider(JSlider slider, String sliderID){
        Element sliderElement = addDocumentElement(SLIDER, sliderID);
        addToParentElement(sliderElement, ENABLED, valueOf(slider.isEnabled()));
        addToParentElement(sliderElement, AMOUNT, valueOf(slider.getValue()));
        return this;
    }

    public void saveToFile(String filePath) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            tf.setAttribute("indent-number", 4); //Formatting...

            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //More formatting...

            transformer.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(
                    new FileOutputStream(new File(filePath)), "utf-8")));

            System.out.println("File saved!");
        } catch (UnsupportedEncodingException | FileNotFoundException | TransformerException e) {
            e.printStackTrace();
            System.err.println("File not saved!");
        }
    }

    /**
     * Resets all global variables and removes all saved settings.
     */
    public void resetSettings(){
        initializeFile();
    }


    /**
     * Adds a parent element to the document element. Returns the created element, so that the user
     * is able to add children to the returned element.
     * @param elementName The name of the element we're adding to the document.
     * @param elementID The ID of the element we're adding to the document.
     * @return The element we just added to the document. Used to add children to this parent element.
     */
    private Element addDocumentElement(String elementName, String elementID){
        Element documentElement = document.createElement(elementName);
        rootElement.appendChild(documentElement);
        documentElement.setAttribute("id", elementID);

        return documentElement;
    }

    /**
     * Adds a new child element node to a parent element. This is used to add multiple elements to
     * a main element. For example: <textField id="field1">CHILDREN APPEND INSIDE HERE</textField>
     * @param parentElement The parent XML element to add an element to.
     * @param elementName The name of the element we're adding.
     * @param elementValue The value of the element we're adding.
     */
    private void addToParentElement(Element parentElement, String elementName, String elementValue){
        Element element = document.createElement(elementName);
        element.appendChild(document.createTextNode(elementValue));
        parentElement.appendChild(element);
    }

    /**
     * Creates a new instance of the document builder, and saves it in |document|.
     * This is simply used to create a fresh copy of the document.
     */
    private void initializeFile(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            document = docBuilder.newDocument();
            rootElement = document.createElement(PARENT);

            document.appendChild(rootElement);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
