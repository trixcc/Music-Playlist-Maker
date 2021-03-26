package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
        playSound("button-3.wav");

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

    // code based on answer on stackoverflow
    // link: https://stackoverflow.com/questions/15526255/best-way-to-get-sound-on-button-press-for-a-java-calculator
    public void playSound(String soundName) {
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
