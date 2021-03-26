package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// code based on ListDemo.java on Oracle
public class AddListener implements ActionListener, DocumentListener {
    private boolean alreadyEnabled = false;
    private JButton button;
    private JTextField songTitle;
    private JList songList;
    private DefaultListModel listModel;

    public AddListener(JButton button, JTextField songTitle, JList songList, DefaultListModel listModel) {
        this.button = button;
        this.songTitle = songTitle;
        this.songList = songList;
        this.listModel = listModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = songTitle.getText();

        if (title.equals("") || alreadyInList(title)) {
            Toolkit.getDefaultToolkit().beep();
            songTitle.requestFocusInWindow();
            songTitle.selectAll();
            return;
        }

        int index = songList.getSelectedIndex();
        if (index == -1) {
            index = 0;
        } else {
            index++;
        }

        listModel.insertElementAt(songTitle.getText(), index);
        playAddSound("./data/button-09.wav");

        songTitle.requestFocusInWindow();
        songTitle.setText("");

        songList.setSelectedIndex(index);
        songList.ensureIndexIsVisible(index);
    }

    protected boolean alreadyInList(String title) {
        return listModel.contains(title);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        enableButton();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleEmptyTextField(e);
    }

    private boolean handleEmptyTextField(DocumentEvent e) {
        if (e.getDocument().getLength() <= 0) {
            button.setEnabled(false);
            alreadyEnabled = false;
            return true;
        }
        return false;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (!handleEmptyTextField(e)) {
            enableButton();
        }
    }

    private void enableButton() {
        if (!alreadyEnabled) {
            button.setEnabled(true);
        }
    }

    public void playAddSound(String soundName) {
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
