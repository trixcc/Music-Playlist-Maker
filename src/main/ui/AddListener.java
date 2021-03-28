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

// Represent the Action Listener for the Add Song button in the SongListUI
// code based on ListDemo.java on Oracle
public class AddListener implements ActionListener, DocumentListener {
    private boolean alreadyEnabled = false;
    private JButton button;
    private JTextField songTitle;
    private JList songList;
    private DefaultListModel listModel;

    // EFFECTS: initializes the fields of the class
    public AddListener(JButton button, JTextField songTitle, JList songList, DefaultListModel listModel) {
        this.button = button;
        this.songTitle = songTitle;
        this.songList = songList;
        this.listModel = listModel;
    }

    // MODIFIES: songList
    // EFFECTS: adds a song title at the selected index of the song list and plays a sound
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

    // EFFECTS: returns true if listModel contains given song title
    protected boolean alreadyInList(String title) {
        return listModel.contains(title);
    }

    // EFFECTS: see super class, enables add song button
    @Override
    public void insertUpdate(DocumentEvent e) {
        enableButton();
    }

    // EFFECTS: see superclass
    @Override
    public void removeUpdate(DocumentEvent e) {
        handleEmptyTextField(e);
    }

    // EFFECTS: disables add song button if text field is empty
    private boolean handleEmptyTextField(DocumentEvent e) {
        if (e.getDocument().getLength() <= 0) {
            button.setEnabled(false);
            alreadyEnabled = false;
            return true;
        }
        return false;
    }

    // EFFECTS: see superclass, enables add song button if text field is not empty
    @Override
    public void changedUpdate(DocumentEvent e) {
        if (!handleEmptyTextField(e)) {
            enableButton();
        }
    }

    // EFFECTS: enables add song button
    private void enableButton() {
        if (!alreadyEnabled) {
            button.setEnabled(true);
        }
    }

    // EFFECTS: plays a sound when user clicks on add song button
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
