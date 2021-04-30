package ui;

import javax.swing.*;

public class MenuOptions {

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem saveItem;
        JMenuItem loadItem;

        menuBar = new JMenuBar();

        menu = new JMenu("More Options");
        menuBar.add(menu);

        saveItem = new JMenuItem("Save Playlist");
        menu.add(saveItem);

        loadItem = new JMenuItem("Load Playlist");
        menu.add(loadItem);

        return menuBar;
    }

}
