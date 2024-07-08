package winchester.osmium.presentation.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EditorMenuBar extends JMenuBar {
    private JMenu menuFile;
    private JMenu menuFormat;
    private JMenu menuRun;
    private JMenu menuHelp;
    private JMenuItem menuItemNew;
    private JMenuItem menuItemOpen;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemSaveAs;
    private JMenuItem menuItemClose;
    private JMenuItem menuItemResetEditorFont;
    private JMenuItem menuItemLargerFont;
    private JMenuItem menuItemSmallerFont;
    private JMenuItem menuItemChangeFontFamily;
    private JMenuItem menuItemSyntaxCheck;
    private JMenuItem menuItemRun;
    private JMenuItem menuItemRunSave;
    private JMenuItem menuItemFunctionList;
    private JMenuItem menuItemAbout;
    private JMenuItem menuItemTheme;

    public EditorMenuBar() {
        super();
        this.initialiseMenuItems();
    }

    private void initialiseMenuItems() {
        this.menuFile = new JMenu("File");
        this.menuItemNew = new JMenuItem("New");
        this.menuItemNew.setActionCommand("NEW_DOCUMENT");
        this.menuItemOpen = new JMenuItem("Open");
        this.menuItemOpen.setActionCommand("OPEN_DOCUMENT");
        this.menuItemSave = new JMenuItem("Save");
        this.menuItemSave.setActionCommand("SAVE_DOCUMENT");
        this.menuItemSave.setEnabled(false);
        this.menuItemSaveAs = new JMenuItem("Save As");
        this.menuItemSaveAs.setActionCommand("SAVE_AS_DOCUMENT");
        this.menuItemClose = new JMenuItem("Close");
        this.menuItemClose.setActionCommand("CLOSE_DOCUMENT");

        this.menuFormat = new JMenu("Format");
        this.menuItemSmallerFont = new JMenuItem("Decrease Font Size");
        this.menuItemSmallerFont.setActionCommand("FONT_SIZE_DECREASE");
        this.menuItemLargerFont = new JMenuItem("Increase Font Size");
        this.menuItemLargerFont.setActionCommand("FONT_SIZE_INCREASE");
        this.menuItemChangeFontFamily = new JMenuItem("Change Font Family");
        this.menuItemChangeFontFamily.setActionCommand("CHANGE_FONT");
        this.menuItemResetEditorFont = new JMenuItem("Reset Font Preferences");
        this.menuItemResetEditorFont.setActionCommand("RESET_FONT");

        this.menuRun = new JMenu("Run");
        this.menuItemSyntaxCheck = new JMenuItem("Syntax Check");
        this.menuItemSyntaxCheck.setActionCommand("CHECK_SYNTAX");
        this.menuItemRun = new JMenuItem("Run");
        this.menuItemRun.setActionCommand("RUN_CODE");
        this.menuItemRunSave = new JMenuItem("Run and Save As File");
        this.menuItemRunSave.setActionCommand("RUN_AND_SAVE_OUTPUT");

        this.menuHelp = new JMenu("Help");
        this.menuHelp.setActionCommand("DISPLAY_HELP");
        this.menuItemFunctionList = new JMenuItem("Show Functions List");
        this.menuItemFunctionList.setActionCommand("DISPLAY_FUNCTION_LIST");
        this.menuItemTheme = new JMenuItem("Change Theme (Light/Dark)");
        this.menuItemTheme.setActionCommand("CHANGE_THEME");
        this.menuItemAbout = new JMenuItem("About");
        this.menuItemAbout.setActionCommand("DISPLAY_ABOUT");

        this.menuFile.add(this.menuItemNew);
        this.menuFile.add(this.menuItemOpen);
        this.menuFile.add(this.menuItemSave);
        this.menuFile.add(this.menuItemSaveAs);
        this.menuFile.add(this.menuItemClose);
        this.add(this.menuFile);
        this.menuFormat.add(this.menuItemLargerFont);
        this.menuFormat.add(this.menuItemSmallerFont);
        this.menuFormat.add(this.menuItemChangeFontFamily);
        this.menuFormat.add(this.menuItemResetEditorFont);
        this.add(this.menuFormat);
        this.menuRun.add(this.menuItemSyntaxCheck);
        this.menuRun.add(this.menuItemRun);
        this.menuRun.add(this.menuItemRunSave);
        this.add(this.menuRun);
        this.menuHelp.add(this.menuItemFunctionList);
        this.menuHelp.add(this.menuItemTheme);
        this.menuHelp.add(this.menuItemAbout);
        this.add(this.menuHelp);
    }

    public void setHandlers(ActionListener handler) {
        this.menuItemNew.addActionListener(handler);
        this.menuItemOpen.addActionListener(handler);
        this.menuItemSave.addActionListener(handler);
        this.menuItemSaveAs.addActionListener(handler);
        this.menuItemClose.addActionListener(handler);
        this.menuItemLargerFont.addActionListener(handler);
        this.menuItemSmallerFont.addActionListener(handler);
        this.menuItemChangeFontFamily.addActionListener(handler);
        this.menuItemResetEditorFont.addActionListener(handler);
        this.menuItemSyntaxCheck.addActionListener(handler);
        this.menuItemRun.addActionListener(handler);
        this.menuItemRunSave.addActionListener(handler);
        this.menuItemFunctionList.addActionListener(handler);
        this.menuItemAbout.addActionListener(handler);
        this.menuItemTheme.addActionListener(handler);
    }

    public void disableSaveItem() {
        this.menuItemSave.setEnabled(false);
    }

    public void enableSaveItem() {
        this.menuItemSave.setEnabled(true);
    }

}
