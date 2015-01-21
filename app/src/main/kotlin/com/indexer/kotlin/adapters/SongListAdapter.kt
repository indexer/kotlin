package com.indexer.kotlin.adapters

import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater
import android.content.Context
import com.indexer.kotlin.R
import com.indexer.kotlin.model.Song
import java.util.ArrayList

/**
 * Created by indexer on 1/21/15.
 */
open class SongListAdapter(val context: Context, val songList: ArrayList<Song>?) : BaseAdapter() {


    override fun getCount(): Int {
        return songList!!.size()
    }

    override fun getItem(position: Int): Any? {
        if (position >= songList!!.size()) return null
        return songList.get(position)
    }

    override fun getItemId(position: Int): Long {
        if (position >= songList!!.size()) return -1
        return songList.get(position).id
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View? {
        var viewHolder: viewHolder ?
        var contentView: View ? = view
        when (contentView) {
            null -> {
                contentView = LayoutInflater.from(context).inflate(R.layout.layout_item,
                        parent, false)
                viewHolder = viewHolder(textview = contentView?.findViewById(R.id.post) as TextView)
                contentView?.setTag(viewHolder)
            }
            else -> {
                viewHolder = contentView?.getTag() as viewHolder
            }
        }

        val currentSong = getItem(position)as Song
        viewHolder?.textview?.setText(currentSong.songTitle)
        return contentView
    }

    class viewHolder(val textview: TextView?)
}
