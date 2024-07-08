package winchester.osmium.presentation.windows;

import javax.swing.*;

import winchester.osmium.core.Metadata;
import winchester.osmium.presentation.components.EditorMenuBar;
import winchester.osmium.presentation.components.EditorStatusBar;
import winchester.osmium.presentation.components.EditorTextArea;
import winchester.osmium.presentation.events.EditorMenuBarHandler;
import winchester.osmium.presentation.events.EditorTextAreaHandler;

import java.awt.*;

public class EditorFrame extends JFrame {
    private EditorTextArea editorTextArea;
    private EditorMenuBar editorMenuBar;
    private EditorStatusBar editorStatusBar;

    public EditorFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setTitle(Metadata.getInstance().getAppTitle());

        this.initialiseEditor();
        this.initialiseMenuBar();
        this.initialiseStatusBar();
        this.initialiseHandlers();
    }

    private void initialiseEditor() {
        this.editorTextArea = new EditorTextArea();
        this.add(this.editorTextArea);
    }

    private void initialiseMenuBar() {
        this.editorMenuBar = new EditorMenuBar();
        this.setJMenuBar(editorMenuBar);
    }

    private void initialiseStatusBar() {
        this.editorStatusBar = new EditorStatusBar();
        this.add(this.editorStatusBar, BorderLayout.SOUTH);
    }

    private void initialiseHandlers() {
        this.editorMenuBar.setHandlers(new EditorMenuBarHandler(
                this.editorMenuBar,
                this.editorTextArea.getEditableTextArea(),
                this.editorTextArea.getLineNumbersTextArea(),
                this.editorStatusBar.getStatusLabel()));
        this.editorTextArea.setHandlers(new EditorTextAreaHandler(
                this.editorTextArea.getLineNumbersTextArea(),
                this.editorTextArea.getEditableTextArea()));
    }

}