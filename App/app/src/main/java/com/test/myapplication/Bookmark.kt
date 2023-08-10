package com.test.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myapplication.databinding.FragmentBookmarkBinding

class Bookmark : Fragment() {
    lateinit var bookmarkAdapter: BookmarkAdapter
    private val datas = mutableListOf<Data>()
    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkBinding.inflate(inflater)
        initRecycler()
        return binding.root
    }

    fun newInstant() : Bookmark
    {
        val args = Bundle()
        val frag = Bookmark()
        frag.arguments = args
        return frag
    }
    private fun initRecycler() {
        bookmarkAdapter = BookmarkAdapter(requireContext())
        binding.rvBookmark.adapter = bookmarkAdapter


        datas.apply {
            add(Data(title = "bookmark1"))
            add(Data(title = "bookmark2"))
            add(Data(title = "bookmark3"))
            add(Data(title = "bookmark4"))
            add(Data(title = "bookmark5"))

            bookmarkAdapter.datas = datas
            // 전체 업데이트라 생각하면됨
            // 리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용
            //어느 상황에서나 사용 가능
            bookmarkAdapter.notifyDataSetChanged()

        }
    }
}