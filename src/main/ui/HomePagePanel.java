package ui;

import javax.swing.*;
import java.awt.*;


public class HomePagePanel extends JPanel {
    private static final int WIDTH = 150;
    private static final int HEIGHT = 500;
    private ButtonOptions buttonOptions;

    public HomePagePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        setButtonOptions(buttonOptions);

    }

    public ButtonOptions getButtonOptions() {
        return buttonOptions;
    }

    public void setButtonOptions(ButtonOptions buttonOptions) {
        if (getButtonOptions() != buttonOptions) {
            this.buttonOptions = buttonOptions;
            buttonOptions.setHomePagePanel(this);
        }
    }
}
