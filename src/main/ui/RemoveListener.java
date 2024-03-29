package ui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// Represents the Action Listener for the Remove Song button in the SongListUI
// code based on ListDemo.java on Oracle
public class RemoveListener implements ActionListener {
    private JButton button;
    private JList songList;
    private DefaultListModel listModel;

    // EFFECTS: initializes the fields of the class
    public RemoveListener(JButton button, JList songList, DefaultListModel listModel) {
        this.button = button;
        this.songList = songList;
        this.listModel = listModel;
    }

    // MODIFIES: songList
    // EFFECTS: adds a song title at the selected index of the song list and plays a sound
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = songList.getSelectedIndex();
        listModel.remove(index);
        playRemoveSound("./data/button-3.wav");

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

    // EFFECTS: plays a sound when user clicks on the remove song button
    public void playRemoveSound(String soundName) {
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Could not play sound.");
        }
    }

}
