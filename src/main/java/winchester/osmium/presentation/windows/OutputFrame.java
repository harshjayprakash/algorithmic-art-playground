package winchester.osmium.presentation.windows;

import winchester.osmium.presentation.components.OutputCanvas;

import javax.swing.*;

public class OutputFrame extends JFrame {
    private OutputCanvas drawingCanvas;
    private final String inputCode;
    
    public OutputFrame(String code) {
        super();
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Output");
        this.inputCode = code;

        this.initialiseComponents();
        this.initialiseHandlers();
    }

    private void initialiseComponents() {
        this.drawingCanvas = new OutputCanvas(inputCode);
        this.drawingCanvas.runLexericalAnalysis();
        this.add(this.drawingCanvas);
    }

    private void initialiseHandlers() {

    }

}
