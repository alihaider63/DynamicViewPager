package com.haider.dynamicviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.haider.dynamicviewpager.databinding.ComponentWhoReactedBottomSheetBinding

class WhoReactedBottomSheet: BottomSheetDialogFragment() {

    private lateinit var binding: ComponentWhoReactedBottomSheetBinding

    companion object {
        const val WHO_REACTED_LIST = "who_reacted_list"
        fun getNewInstance(whoReactedList: ArrayList<WhoReacted>) = WhoReactedBottomSheet().apply {
            val bundle = Bundle()
            bundle.putParcelableArrayList(WHO_REACTED_LIST, whoReactedList)
            arguments = bundle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ComponentWhoReactedBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val whoReactedList = arguments?.getParcelableArrayList<WhoReacted>(WHO_REACTED_LIST)

        val adapter = BottomSheetAdapter(this)

        if (whoReactedList != null) {
            for (whoReacted in whoReactedList) {
                val fragment = DynamicUserReactedFragment.getNewInstance(whoReacted.userList)
                adapter.addFragment(fragment, whoReacted.reactionTabTitle)
            }
        }

        val sheetBehavior = BottomSheetBehavior.from(view.parent as View)

        binding.whoReactedViewpager.adapter = adapter

        binding.whoReactedViewpager.children.find { it is RecyclerView }?.let {
            (it as RecyclerView).isNestedScrollingEnabled = false
            (it as RecyclerView).overScrollMode = View.OVER_SCROLL_NEVER
        }
        //binding.whoReactedTab.setupWithViewPager(binding.whoReactedViewpager)
        TabLayoutMediator(binding.whoReactedTab, binding.whoReactedViewpager) { tab, position ->
            tab.text = whoReactedList?.get(position)?.reactionTabTitle//"OBJECT ${(position + 1)}"
        }.attach()

    }
}