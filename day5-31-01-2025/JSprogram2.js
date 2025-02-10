/*
You are managing a nested array of music playlists, where each playlist contains a collection of song objects. 
Each song object has the following properties:

title (string): The name of the song.
artist (string): The artist of the song.
duration (number): The duration of the song in seconds.
Your task is to implement the following operations:

Find the Playlist: Identify the playlist that contains a song with a specific title using findIndex.
Remove the Song: Once the playlist is identified, locate the song in that playlist using findIndex and remove it using splice.
Flatten the Playlists: Combine all playlists into a single-level array using flat.
Filter Long Songs: Retain only the songs with a duration longer than 3 minutes (180 seconds) using filter.
Calculate Total Duration: Use reduce to calculate the total duration of the remaining songs.

Expected Output:
----------------
Long Songs: [
  { title: "Shape of You", artist: "Ed Sheeran", duration: 233 },
  { title: "Blinding Lights", artist: "The Weeknd", duration: 200 },
  { title: "Bad Guy", artist: "Billie Eilish", duration: 194 },
  { title: "Peaches", artist: "Justin Bieber", duration: 210 }
]
Total Duration (seconds): 837

*/
const playlists = [
    [
        { title: "Shape of You", artist: "Ed Sheeran", duration: 233 },
        { title: "Blinding Lights", artist: "The Weeknd", duration: 200 }
    ],
    [
        { title: "Levitating", artist: "Dua Lipa", duration: 178 },
        { title: "Someone You Loved", artist: "Lewis Capaldi", duration: 182 }
    ],
    [
        { title: "Bad Guy", artist: "Billie Eilish", duration: 194 },
        { title: "Peaches", artist: "Justin Bieber", duration: 210 }
    ]
];

const songToRemove = "Levitating";

const flatPlaylist = playlists.flat();

const removeInd = flatPlaylist.findIndex((p) => p.title === songToRemove);
if(removeInd != -1) {
    flatPlaylist.splice(removeInd, 1);
}

const longSongs = flatPlaylist.filter((p) => p.duration > 182)
const totalTime = longSongs.reduce((sum, song) => sum + song.duration, 0)

console.log("Long Songs:", longSongs)
console.log(`Total Duration (seconds): ${totalTime}`)