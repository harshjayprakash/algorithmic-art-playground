package winchester.osmium.presentation.windows;

import javax.swing.*;

public class HelpFrame extends JFrame {
    private JScrollPane scrollPane;
    private JEditorPane textArea;

    public HelpFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Help");

        this.initialiseComponents();
    }

    private void initialiseComponents() {
        this.scrollPane = new JScrollPane();
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.textArea = new JEditorPane();
        this.textArea.setEditable(false);
        this.textArea.setContentType("text/html");
        this.textArea.setHighlighter(null);
        this.textArea.setText(
                """
                <style>
                    code { font-size: 2rem; }
                </style>
                
                <h1>Variable Assignment</h1>
                <code>var := 94;</code>
                <p>
                    Defining variables allows values to be reused throughout the program.
                    <ul>
                    <li>The variable must be defined before use.</li>
                    <li>You may only define unsigned Integers (whole numbers)</li>
                    <li>Variable names must only contains letters, numbers (not at the start) or underscores</li>
                    <li>Variable names must not be a keyword: for, if, else, begin, end, to, downto, then, do</li>
                    </ul>
                </p>
                
                <h1>Built In Functions</h1>
                
                <code>Position(x, y);</code>
                <p>
                A function sets the cursor to start drawing. This can be set at any point. Arguments Include:
                <ul>
                    <li><code>x</code> => The x position</li>
                    <li><code>y</code> => The y position</li>
                </ul>
                </p>
                
                <code>Move(x, y);</code>
                <p>
                A function that move the cursor by specified x and y direction. Arguments Include:
                <ul>
                    <li><code>x</code> => Move in the x direction</li>
                    <li><code>y</code> => Move in the y direction</li>
                </ul>
                </p>
                
                <code>Rect(x, y, width, height);</code>
                <p>
                A function that draws a rectangle. Arguments Include:
                <ul>
                    <li><code>x</code> => Start x coordinate of the rectangle</li>
                    <li><code>y</code> => Start y coordinate of the rectangle</li>
                    <li><code>width</code> => Width of the rectangle</li>
                    <li><code>height</code> => Height of the rectangle</li>
                </ul>
                </p>
                
                <h1>Notes</h1>
                <p>This language is not case sensitive but is very limited with functionality</p>
                """);

        this.scrollPane.setViewportView(this.textArea);
        this.add(this.scrollPane);
    }
}
