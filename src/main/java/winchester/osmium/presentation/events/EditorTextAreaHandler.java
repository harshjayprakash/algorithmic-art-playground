package winchester.osmium.presentation.events;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class EditorTextAreaHandler implements DocumentListener {
    private final JTextArea lineTextArea;
    private final JTextArea editorTextArea;

    public EditorTextAreaHandler(JTextArea lineTextArea, JTextArea editorTextArea) {
        super();
        this.lineTextArea = lineTextArea;
        this.editorTextArea = editorTextArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.lineTextArea.setText(this.getLineNumbers());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.lineTextArea.setText(this.getLineNumbers());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.lineTextArea.setText(this.getLineNumbers());
    }

    private String getLineNumbers() {
        int caretPosition = this.editorTextArea.getDocument().getLength();
        Element rootElement = this.editorTextArea.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersStringBuilder = new StringBuilder();
        lineNumbersStringBuilder.append("1").append(System.lineSeparator());

        for (int index = 2; index < rootElement.getElementIndex(caretPosition) + 2; index++) {
            lineNumbersStringBuilder.append(index).append(System.lineSeparator());
        }

        return lineNumbersStringBuilder.toString();
    }


}
