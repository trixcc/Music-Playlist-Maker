package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// code based on ListDemo.java on Oracle
public class SongListUI extends JPanel implements ListSelectionListener {
    private static final int WIDTH = 450;
    private static final int HEIGHT = 500;

    private JList songList;
    private DefaultListModel listModel;

    private JButton addSongButton;
    private JButton removeSongButton;
    private JTextField songTitle;

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

    public void createAddSongButton() {
        addSongButton = new JButton("ADD SONG");
        songTitle = new JTextField(10);

        AddListener addListener = new AddListener(addSongButton, songTitle, songList, listModel);

        addSongButton.setActionCommand("add");
        addSongButton.addActionListener(addListener);
        addSongButton.setEnabled(false);

        songTitle.addActionListener(addListener);
        songTitle.getDocument().addDocumentListener(addListener);
//        String title = listModel.getElementAt(songList.getSelectedIndex()).toString();
    }

    public void createRemoveSongButton() {
        removeSongButton = new JButton("REMOVE SONG");
        removeSongButton.setActionCommand("remove");
        removeSongButton.addActionListener(new RemoveListener(removeSongButton, songList, listModel));
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (songList.getSelectedIndex() == -1) {
                addSongButton.setEnabled(false);
            } else {
                addSongButton.setEnabled(true);
            }
        }
    }

//    public JList getSongList() {
//        return songList;
//    }

}
