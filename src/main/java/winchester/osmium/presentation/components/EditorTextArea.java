package winchester.osmium.presentation.components;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class EditorTextArea extends JScrollPane {
    private JTextArea textArea;
    private JTextArea textAreaLineNumbers;

    public EditorTextArea() {
        super();
        this.initialiseTextAreas();
    }

    private void initialiseTextAreas() {
        this.textArea = new JTextArea();
        this.textArea.setFont(new Font("monospaced", Font.PLAIN, 14));
        this.textArea.setTabSize(4);
        this.textArea.setLineWrap(true);
        this.textAreaLineNumbers = new JTextArea();
        this.textAreaLineNumbers.setText("1");
        this.textAreaLineNumbers.setEditable(false);
        this.textAreaLineNumbers.setFont(new Font("monospaced", Font.PLAIN, 14));
        this.textAreaLineNumbers.setMargin(new Insets(3, 10, 0, 10));

        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setViewportView(this.textArea);
        this.setRowHeaderView(this.textAreaLineNumbers);
    }

    public void setHandlers(DocumentListener handler) {
        this.textArea.getDocument().addDocumentListener(handler);
    }

    public JTextArea getEditableTextArea() {
        return this.textArea;
    }

    public JTextArea getLineNumbersTextArea() {
        return this.textAreaLineNumbers;
    }

}
