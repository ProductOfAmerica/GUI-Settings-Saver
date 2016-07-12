package SettingsSaver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;

import static SettingsSaver.ParseConstants.*;

/**
 * Created by Calculus on 6/30/2016.
 */

public class SettingsLoader {
    private Document document = null;

    public SettingsLoader(File xmlFile) {
        if(xmlFile.exists())
            try {
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
                document.getDocumentElement().normalize();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    public SettingsLoader loadCheckBox(JCheckBox checkBox, String checkBoxID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(CHECK_BOX);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, checkBoxID)){ //Make sure the checkboxID is the right one...
                    checkBox.setEnabled(getElementBoolean(element, ENABLED));
                    checkBox.setSelected(getElementBoolean(element, SELECTED));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadComboBox(JComboBox<String> comboBox, String comboBoxID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(COMBO_BOX);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, comboBoxID)){
                    NodeList list = element.getElementsByTagName(COMBO_ITEM);
                    LinkedList<String> strings = new LinkedList<>();
                    for(int j = 0; j < list.getLength(); j++){
                        strings.push(list.item(j).getTextContent()); //Gets every item stored in the combo box
                    }
                    comboBox.setModel(new DefaultComboBoxModel<>(strings.toArray(new String[strings.size()])));

                    comboBox.setEnabled(getElementBoolean(element, ENABLED));
                    comboBox.setSelectedIndex(getElementInteger(element, SELECTED_INDEX));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadTextField(JTextField textField, String textFieldID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(TEXT_FIELD);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, textFieldID)){
                    textField.setEnabled(getElementBoolean(element, ENABLED));
                    textField.setText(getElementText(element, TEXT));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadTextArea(JTextArea textArea, String textAreaID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(TEXT_AREA);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, textAreaID)){
                    textArea.setEnabled(getElementBoolean(element, ENABLED));
                    textArea.setText(getElementText(element, TEXT));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadLabel(JLabel label, String labelID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(LABEL);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, labelID)){
                    label.setEnabled(getElementBoolean(element, ENABLED));
                    label.setText(getElementText(element, TEXT));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadRadioButton(JRadioButton radioButton, String buttonID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(RADIO_BUTTON);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, buttonID)){
                    radioButton.setEnabled(getElementBoolean(element, ENABLED));
                    radioButton.setSelected(getElementBoolean(element, SELECTED));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadToggleButton(JToggleButton toggleButton, String buttonID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(TOGGLE_BUTTON);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, buttonID)){
                    toggleButton.setEnabled(getElementBoolean(element, ENABLED));
                    toggleButton.setSelected(getElementBoolean(element, SELECTED));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadButton(JButton button, String buttonID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(BUTTON);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, buttonID)){
                    button.setEnabled(getElementBoolean(element, ENABLED));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadTextPane(JTextPane textPane, String textPaneID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(TEXT_PANE);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, textPaneID)){
                    textPane.setEnabled(getElementBoolean(element, ENABLED));
                    textPane.setText(getElementText(element, TEXT));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadSpinner(JSpinner spinner, String spinnerID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(SPINNER);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, spinnerID)){
                    spinner.setEnabled(getElementBoolean(element, ENABLED));
                    spinner.setValue(getElementInteger(element, AMOUNT));
                }
            }
        }
        return this;
    }

    public SettingsLoader loadSlider(JSlider slider, String sliderID){
        if (document == null)
            return this;
        NodeList nodeList = getNodeList(SLIDER);
        Element element;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if((element = getElement(nodeList.item(i))) != null){ //Make sure the element exists
                if(checkIDs(element, sliderID)){
                    slider.setEnabled(getElementBoolean(element, ENABLED));
                    slider.setValue(getElementInteger(element, AMOUNT));
                }
            }
        }
        return this;
    }



    private Element getElement(Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            return (Element) node;
        }
        return null;
    }

    private boolean checkIDs(Element element, String ID2){
        return element.getAttribute(ID).equals(ID2);
    }

    private String getElementText(Element element, String elementType){
        return element.getElementsByTagName(elementType).item(0).getTextContent();
    }

    private boolean getElementBoolean(Element element, String elementType){
        return Boolean.parseBoolean(getElementText(element, elementType));
    }

    private int getElementInteger(Element element, String elementType){
        return Integer.parseInt(getElementText(element, elementType));
    }

    private NodeList getNodeList(String tagName){
        return document.getElementsByTagName(tagName);
    }
}
