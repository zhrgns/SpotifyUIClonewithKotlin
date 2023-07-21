package com.example.spotifyui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.spotifyui.adapter.PlaylistAdapter
import com.example.spotifyui.adapter.RecommendationAdapter
import com.example.spotifyui.databinding.FragmentHomePageBinding
import com.example.spotifyui.entity.PlayList
import com.example.spotifyui.entity.RecommendationList

class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.toolbarHomePage.title = "Günaydın"

        // toplayout manager
        binding.rvPlaylists.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        //an arraylist to hold playlists
        val playListList = ArrayList<PlayList>()

        //put values to arraylist
        val pl1 = PlayList(1, "Beğendiğin Şarkılar", "bgn")
        val pl2 = PlayList(2, "Haftalık Keşif", "haftalikkesif")
        val pl3 = PlayList(3, "Kozmos", "kozmos")
        val pl4 = PlayList(4, "Billie Ellish Mix", "billieellish")
        val pl5 = PlayList(5, "trend 2023", "trend")
        val pl6 = PlayList(6, "Lia Shine", "liashine")
        playListList.add(pl1)
        playListList.add(pl2)
        playListList.add(pl3)
        playListList.add(pl4)
        playListList.add(pl5)
        playListList.add(pl6)

        val playListAdapter = PlaylistAdapter(requireContext(), playListList)
        binding.rvPlaylists.adapter = playListAdapter

        //mid layout manager
        binding.rvPlaylistsRecom.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        //an arraylist to hold playlists
        val recomListList = ArrayList<RecommendationList>()

        //put values to arraylist
        val rl1 = RecommendationList(1, "Hot Hits Türkiye", "hothitstr","Dinlemekten vazgeçemediklerin ve en yeni hitler.")
        val rl2 = RecommendationList(2, "En İyi 50 - Global", "region_global_default","Şu anda tüm dünyada en çok çalınan parçaları ...")
        val rl3 = RecommendationList(3, "Lia Shine", "liashine","Dinlemekten vazgeçemediklerin ve en yeni hitler.")

        recomListList.add(rl1)
        recomListList.add(rl2)
        recomListList.add(rl3)

        val recomListAdapter = RecommendationAdapter(requireContext(), recomListList)
        binding.rvPlaylistsRecom.adapter = recomListAdapter

        return binding.root
    }

}