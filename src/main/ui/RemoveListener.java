package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// code based on ListDemo.java on Oracle
public class RemoveListener implements ActionListener {
    private JList songList;
    private DefaultListModel listModel;
    private JButton button;

    public RemoveListener(JButton button, JList songList, DefaultListModel listModel) {
        this.button = button;
        this.songList = songList;
        this.listModel = listModel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = songList.getSelectedIndex();
        listModel.remove(index);

        int size = listModel.getSize();
        if (size == 0) {
            button.setEnabled(false);
        } else {
            if (index == listModel.getSize()) {
                index--;
            }

            songList.setSelectedIndex(index);
            songList.ensureIndexIsVisible(index);
        }

    }
}
