package com.example.spotifyui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyui.databinding.CardDesign2Binding
import com.example.spotifyui.databinding.CardDesignBinding
import com.example.spotifyui.entity.PlayList
import com.example.spotifyui.entity.RecommendationList

class RecommendationAdapter(var mContext: Context, var recomListList: List<RecommendationList>) :
    RecyclerView.Adapter<RecommendationAdapter.CardDesign2Holder>() {

    //Adapter verileri recyclerview a baglar. Verileri bir viewholder içinde görüntülenebilecek sekilde uyarlar.
    //RecyclerView, verilerin ekranda nasıl görüntüleneceğini anlamak için Adapter kullanır.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign2Holder {
        val binding2 = CardDesign2Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesign2Holder(binding2)
    }

    //görüntülünecek her data icin tek tek yapılan islem
    override fun onBindViewHolder(holder2: CardDesign2Holder, position: Int) {
        val recomList = recomListList.get(position)
        val t = holder2.design

        //set image
        t.imageViewList.setImageResource(
            mContext.resources.getIdentifier(
                recomList.listImage,
                "drawable",
                mContext.packageName
            )
        )

        t.textViewRecomTitle.text = recomList.listName
        t.textViewDesc.text = recomList.listDesc

    }

    override fun getItemCount(): Int {
        return recomListList.size
    }

    inner class CardDesign2Holder(var design: CardDesign2Binding) :
        RecyclerView.ViewHolder(design.root)
}