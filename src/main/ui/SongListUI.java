package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// Represents a panel in which a list of songs added to the playlist is displayed
// code based on ListDemo.java on Oracle
public class SongListUI extends JPanel implements ListSelectionListener {
    private static final int WIDTH = 450;
    private static final int HEIGHT = 500;

    private JList songList;
    private DefaultListModel listModel;

    private JButton addSongButton;
    private JButton removeSongButton;
    private JTextField songTitle;

    // EFFECTS: sets up the song list panel,
    //          creates a separate panel where user can add and remove songs
    public SongListUI() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        listModel = new DefaultListModel();

        songList = new JList(listModel);
        songList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        songList.setSelectedIndex(0);
        songList.addListSelectionListener(this);
        songList.setVisibleRowCount(5);
        JScrollPane songListScrollPane = new JScrollPane(songList);

        createAddSongButton();
        createRemoveSongButton();

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(songTitle);
        buttonPane.add(addSongButton);
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(removeSongButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(songListScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    // EFFECTS: creates a button to add a song,
    //          sets up an Action Listener for the button
    public void createAddSongButton() {
        addSongButton = new JButton("ADD SONG");
        songTitle = new JTextField(10);

        AddListener addListener = new AddListener(addSongButton, songTitle, songList, listModel);

        addSongButton.setActionCommand("add");
        addSongButton.setEnabled(false);
        addSongButton.addActionListener(addListener);

        songTitle.addActionListener(addListener);
        songTitle.getDocument().addDocumentListener(addListener);
//        String title = listModel.getElementAt(songList.getSelectedIndex()).toString();
    }

    // EFFECTS: creates a button to remove a song,
    //          sets up an Action Listener for the button
    public void createRemoveSongButton() {
        removeSongButton = new JButton("REMOVE SONG");
        removeSongButton.setActionCommand("remove");
        removeSongButton.setEnabled(false);
        removeSongButton.addActionListener(new RemoveListener(removeSongButton, songList, listModel));
    }

    // EFFECTS: enables/disables remove song button
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (songList.getSelectedIndex() == -1) {
                removeSongButton.setEnabled(false);
            } else {
                removeSongButton.setEnabled(true);
            }
        }
    }

    public JList getSongList() {
        return songList;
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

}
