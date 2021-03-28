package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// Represents a panel that displays the songs that have been added to the playlist,
// and a panel where user can add and remove songs
// code based on ListDemo.java on Oracle
public class SongListUI extends JPanel implements ListSelectionListener {
    private static final int WIDTH = 450;
    private static final int HEIGHT = 350;

    private JList songList;
    private DefaultListModel listModel;

    private JButton addSongButton;
    private JButton removeSongButton;
    private JTextField songTitle;

    // EFFECTS: sets up the list of songs panel,
    //          creates an attached panel where user can add and remove songs from the song list
    public SongListUI() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        listModel = new DefaultListModel();
        songList = new JList(listModel);
        songList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        songList.setSelectedIndex(0);
        songList.addListSelectionListener(this);
        songList.setVisibleRowCount(5);
        JScrollPane songListScrollPane = new JScrollPane(songList);
        add(songListScrollPane, BorderLayout.CENTER);

        createAddSongButton();
        createRemoveSongButton();
        createAddAndRemovePanel();

    }

    // EFFECTS: creates an add song button,
    //          sets up an Action Listener for the button
    public void createAddSongButton() {
        addSongButton = new JButton("Add Song");
        songTitle = new JTextField(10);
        addSongButton.setActionCommand("add");
        addSongButton.setEnabled(false);

        AddListener addListener = new AddListener(addSongButton, songTitle, songList, listModel);
        addSongButton.addActionListener(addListener);
        songTitle.addActionListener(addListener);
        songTitle.getDocument().addDocumentListener(addListener);
    }

    // EFFECTS: creates a remove song button,
    //          sets up an Action Listener for the button
    public void createRemoveSongButton() {
        removeSongButton = new JButton("Remove Song");
        removeSongButton.setActionCommand("remove");
        removeSongButton.setEnabled(false);

        RemoveListener removeListener = new RemoveListener(removeSongButton, songList, listModel);
        removeSongButton.addActionListener(removeListener);
    }

    // EFFECTS: sets up a panel where user can add and remove songs
    public void createAddAndRemovePanel() {
        JPanel addAndRemovePanel = new JPanel();
        addAndRemovePanel.setLayout(new BoxLayout(addAndRemovePanel, BoxLayout.LINE_AXIS));
        addAndRemovePanel.add(Box.createHorizontalStrut(5));
        addAndRemovePanel.add(songTitle);
        addAndRemovePanel.add(addSongButton);
        addAndRemovePanel.add(new JSeparator(SwingConstants.VERTICAL));
        addAndRemovePanel.add(removeSongButton);
        addAndRemovePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.add(addAndRemovePanel, BorderLayout.PAGE_END);
    }

    // EFFECTS: enables/disables remove song button when the value of selection
    //          of a song in the song list changes
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            removeSongButton.setEnabled(songList.getSelectedIndex() != -1);
        }
    }

    public JList getSongList() {
        return songList;
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

}
