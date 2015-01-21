package com.indexer.kotlin

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.indexer.kotlin.adapters.SongListAdapter
import java.util.ArrayList
import android.widget.ListView
import com.indexer.kotlin.model.Song

public class MainActivity : Activity() {
    var SongListAdapter: SongListAdapter? = null
    val songList: ArrayList<Song> = ArrayList()

    var songListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ToDo update Data
        var song = Song()

        song.songTitle = "Good by My Lover"

        var newSong = Song()
        newSong.songTitle = "If i die young"

        songList.add(song)
        songList.add(newSong)

        SongListAdapter = SongListAdapter(this, songList)
        songListView = findViewById(R.id.songList) as ListView
        songListView!!.setAdapter(SongListAdapter);

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
