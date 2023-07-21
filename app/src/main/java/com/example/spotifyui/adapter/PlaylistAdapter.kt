package com.example.spotifyui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyui.databinding.CardDesignBinding
import com.example.spotifyui.entity.PlayList

class PlaylistAdapter(var mContext: Context, var playlistList: List<PlayList>) :
    RecyclerView.Adapter<PlaylistAdapter.CardDesignHolder>() {

    //Adapter verileri recyclerview a baglar. Verileri bir viewholder içinde görüntülenebilecek sekilde uyarlar.
    //RecyclerView, verilerin ekranda nasıl görüntüleneceğini anlamak için Adapter kullanır.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    //görüntülünecek her data icin tek tek yapılan islem
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val playlist = playlistList.get(position)
        val t = holder.design

        //set image
        t.imageViewList.setImageResource(
            mContext.resources.getIdentifier(
                playlist.listImage,
                "drawable",
                mContext.packageName
            )
        )

        t.textViewList.text = playlist.listName

    }

    override fun getItemCount(): Int {
        return playlistList.size
    }

    inner class CardDesignHolder(var design: CardDesignBinding) :
        RecyclerView.ViewHolder(design.root)

}