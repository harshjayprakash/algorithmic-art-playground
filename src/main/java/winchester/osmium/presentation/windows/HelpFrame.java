package winchester.osmium.presentation.windows;

import javax.swing.*;

public class HelpFrame extends JFrame {
    private JScrollPane scrollPane;
    private JTextArea textArea;

    public HelpFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Functions List");

        this.initialiseComponents();
        this.initialiseHandlers();
    }

    private void initialiseComponents() {
        this.scrollPane = new JScrollPane();
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setText(
                """
                Assignment
                
                <variable-name> := <int-number>;
                
                You can only define integer types.
                
                Functions
                
                Position(<x>, <y>);
                Move(<x>, <y>);
                Rect(<x>, <y>, <width>, <height>;
                
                Loop
                
                For <variable-name> := <start> to | downto <end>
                begin
                    <statements>
                end;
                
                If statements
                
                If <variable> <equality-symbol> <number> then
                begin
                end;
                
                There is no else statement available.
                """);

        this.scrollPane.setViewportView(this.textArea);
        this.add(this.scrollPane);
    }

    private void initialiseHandlers() {

    }
}
