# My Personal Project

## A Music Playlist Maker

#### What does this application do?
This application allows users to generate personalized music playlists.

#### Who can use this application?
This application is beneficial for music-lovers who like to stay organized.

#### Why is this project of interest to me?
I am interested in this project because I listen to a lot of different genres of music and tend to have all my
songs on one big playlist. Often times, a song will play that doesn't fit my mood.  

I want to create a simple-to-use application that can organize my music (eg. based on different moods).

#### User Stories:
- As a user, I want to be able to create and name a new playlist.
- As a user, I want to be able to add a song to a playlist.
- As a user, I want to be able to remove a song from a playlist.
- As a user, I want to be able to see how many songs are in a playlist.
- As a user, I want to be able to view a list of all the song titles in a playlist.
- As a user, I want to be able to save my playlist to file.
- As a user, I want to be able to load my playlist from file.

#### Phase 4: Task 2
Test and design a class in your model package that is robust.  
Playlist class: constructor and addSong method are now robust.

#### Phase 4: Task 3
- put the save and load playlist options (MoreOptionsUI) in a menu bar instead of a panel with buttons
    - this way, I could get rid of the HomePagePanel class and reduce coupling between 
    HomePagePanel, MoreOptionsUI, and PlaylistMakerFrame
- create a superclass for AddListener and RemoveListener to abstract duplicated code
  


