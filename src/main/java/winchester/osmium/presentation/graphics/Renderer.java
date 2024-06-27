package winchester.osmium.presentation.graphics;

import winchester.osmium.logic.Statement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {
    private BufferedImage bufferedImage;
    private Statement[] statements;
    private int xPosition;
    private int yPosition;

    public Renderer() {
        this.bufferedImage = new BufferedImage(1024, 768, Image.SCALE_DEFAULT);
    }

    public void setInstructions(Statement[] statements) {
        this.statements = statements;
    }

    private void executeInstructions() {
        Graphics graphics =  this.bufferedImage.getGraphics();

        for (Statement statement : this.statements) {
            switch (statement) {

            }
        }
    }

    public BufferedImage getOutputImage() {
        return this.bufferedImage;
    }

}
