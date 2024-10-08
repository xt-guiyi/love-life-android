package com.xtguiyi.play.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xtguiyi.play.databinding. FragmentHomeViewPageType2Binding
import com.xtguiyi.play.base.BaseFragment

private const val ARG_PARAM1 = "type"

class ViewPageType2Fragment : BaseFragment() {
    private var type: String? = null
    private lateinit var binding:  FragmentHomeViewPageType2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentHomeViewPageType2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initView() {}

    override fun initData() {}

    override fun bindingListener() { }

    companion object {
        @JvmStatic
        fun newInstance(type: String) =
            ViewPageType2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, type)
                }
            }
    }
}