package com.test.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myapplication.databinding.FragmentTodoBinding

class Todo : Fragment() {
    lateinit var todoAdapter: TodoAdapter
    private val datas = mutableListOf<Data>()
    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater)
        initRecycler()
        return binding.root
    }
    fun newInstant() : Todo
    {
        val args = Bundle()
        val frag = Todo()
        frag.arguments = args
        return frag
    }
    private fun initRecycler() {
        todoAdapter = TodoAdapter(requireContext())
        binding.rvTodo.adapter = todoAdapter


        datas.apply {
            add(Data(title = "todo1"))
            add(Data(title = "todo2"))
            add(Data(title = "todo3"))
            add(Data(title = "todo4"))
            add(Data(title = "todo5"))

            todoAdapter.datas = datas
            // 전체 업데이트라 생각하면 됨
            // 리스트의 크기와 아이템이 둘 다 변경되는 경우에 사용
            // 어느 상황에서나 사용 가능
            todoAdapter.notifyDataSetChanged()

        }
    }

}