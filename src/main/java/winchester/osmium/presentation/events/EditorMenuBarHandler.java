package winchester.osmium.presentation.events;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import winchester.osmium.core.Metadata;
import winchester.osmium.presentation.components.EditorMenuBar;
import winchester.osmium.presentation.windows.AboutFrame;
import winchester.osmium.presentation.windows.FontChangerFrame;
import winchester.osmium.presentation.windows.HelpFrame;
import winchester.osmium.presentation.windows.OutputFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EditorMenuBarHandler implements ActionListener {
    private final EditorMenuBar menuBar;
    private final JTextArea textArea;
    private final JTextArea lineNumbers;
    private final JLabel statusLabel;
    private String currentTextFile;
    private String currentFontFamily;
    private int currentFontSize;

    @Contract(pure = true)
    public EditorMenuBarHandler(EditorMenuBar menuBar, JTextArea editableTextArea, JTextArea lineNumbersTextArea,
                                JLabel statusLabel) {
        super();
        this.menuBar = menuBar;
        this.textArea = editableTextArea;
        this.lineNumbers = lineNumbersTextArea;
        this.statusLabel = statusLabel;
        this.currentFontFamily = "monospaced";
        this.currentFontSize = 14;
        this.currentTextFile = "null";
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        String eventCode = e.getActionCommand();

        switch (eventCode) {
            case "NEW_DOCUMENT":
                this.clearDocument();
                return;
            case "OPEN_DOCUMENT":
                this.openDocument();
                return;
            case "SAVE_DOCUMENT":
                this.saveDocument();
                return;
            case "SAVE_AS_DOCUMENT":
                this.saveNewDocument();
                return;
            case "CLOSE_DOCUMENT":
                this.closeDocument();
                return;
            case "FONT_SIZE_DECREASE":
                this.updateFontSize(false);
                return;
            case "FONT_SIZE_INCREASE":
                this.updateFontSize(true);
                return;
            case "RESET_FONT":
                this.resetFontSettings();
                return;
            case "CHANGE_FONT":
                this.updateFont();
                return;
            case "CHECK_SYNTAX":
            case "RUN_AND_SAVE_OUTPUT":
            case "DISPLAY_HELP":
                return;
            case "DISPLAY_FUNCTION_LIST":
                this.displayFunctionList();
                return;
            case "DISPLAY_ABOUT":
                this.displayAbout();
                return;
            case "RUN_CODE":
                this.runDocument();
                return;
            case "CHANGE_THEME":
                this.changeTheme(e);
        }
    }

    private void clearDocument() {
        this.textArea.setText("");
        this.currentTextFile = null;
        this.menuBar.disableSaveItem();
        this.statusLabel.setText("Blank Document Created.");
    }

    private void openDocument() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this.textArea.getParent());
        File file = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }

        if (file == null) {
            return;
        }

        this.clearDocument();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                this.textArea.append(line + "\n");
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            this.statusLabel.setText("Failed to Open File: File Not Available");
        } catch (IOException ex) {
            this.statusLabel.setText("Failed to Open File: Cannot Read File");
        }
        this.currentTextFile = file.getPath();
        this.statusLabel.setText("Successfully Opened File: " + this.currentTextFile);
    }

    private void runDocument() {
        OutputFrame outputFrame = new OutputFrame(this.textArea.getText());
        outputFrame.setVisible(true);
    }

    private void changeTheme(@NotNull ActionEvent e) {
        try {
            if (Metadata.getInstance().appInDarkTheme()) {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
            }
            else {
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
            }
            Metadata.getInstance().toggleDarkTheme();
        }
        catch (UnsupportedLookAndFeelException exception) {
            this.statusLabel.setText("Failed to Change Program Theme ");
        }

        JMenuItem menuItem = (JMenuItem) e.getSource();
        JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
        Component invoker = popupMenu.getInvoker();
        JComponent invokerAsJComponent = (JComponent) invoker;
        Container topLevel = invokerAsJComponent.getTopLevelAncestor();
        SwingUtilities.updateComponentTreeUI(topLevel);
    }

    private void saveDocument() {
        try {
            FileWriter fileWriter = new FileWriter(this.currentTextFile);
            fileWriter.write(this.textArea.getText());
            fileWriter.close();
            this.statusLabel.setText("Successfully Saved File: " + this.currentTextFile);
        } catch (IOException e) {
            this.statusLabel.setText("Failed to Save File: Cannot Read File");
        }
    }

    private void saveNewDocument() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retrieval = fileChooser.showSaveDialog(this.textArea.getParent());
        File file = null;

        if (retrieval == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }

        if (file == null) {
            this.statusLabel.setText("Save Error: Invalid File");
        }

        if (fileChooser.getSelectedFile().isDirectory()) {
            this.statusLabel.setText("Save Error: No Filename Chosen");
            return;
        }

        this.currentTextFile = file != null ? file.getPath() : "null";

        this.saveDocument();

        if (this.currentTextFile != null) {
            this.menuBar.enableSaveItem();
        }
    }

    private void closeDocument() {
        this.clearDocument();
    }

    private void displayFunctionList() {
        HelpFrame functionListFrame = new HelpFrame();
        functionListFrame.setVisible(true);
    }

    private void displayAbout() {
        AboutFrame aboutFrame = new AboutFrame();
        aboutFrame.setVisible(true);
    }

    private void updateFontSize(boolean increase) {
        if (increase) {
            this.currentFontSize += 2;
        }
        else {
            this.currentFontSize -= 2;
        }
        textArea.setFont(new Font(this.currentFontFamily, Font.PLAIN, this.currentFontSize));
        lineNumbers.setFont(new Font(this.currentFontFamily, Font.PLAIN, this.currentFontSize));
    }

    private void updateFont() {
        FontChangerFrame fontChangerFrame = new FontChangerFrame(this.currentFontFamily);
        fontChangerFrame.setVisible(true);

        fontChangerFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                EditorMenuBarHandler.this.currentFontFamily = fontChangerFrame.getFontFamily();
                textArea.setFont(new Font(EditorMenuBarHandler.this.currentFontFamily, Font.PLAIN, EditorMenuBarHandler.this.currentFontSize));
                lineNumbers.setFont(new Font(EditorMenuBarHandler.this.currentFontFamily, Font.PLAIN, EditorMenuBarHandler.this.currentFontSize));
                super.windowClosing(e);
            }
        });
    }

    private void resetFontSettings() {
        this.currentFontSize = 14;
        this.currentFontFamily = "monospaced";
        textArea.setFont(new Font(this.currentFontFamily, Font.PLAIN, this.currentFontSize));
        lineNumbers.setFont(new Font(this.currentFontFamily, Font.PLAIN, this.currentFontSize));
    }
}
