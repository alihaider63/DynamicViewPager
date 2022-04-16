package com.haider.dynamicviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.haider.dynamicviewpager.databinding.WhoReactedBottomSheetBinding

class WhoReactedBottomSheet: BottomSheetDialogFragment() {

    private lateinit var binding: WhoReactedBottomSheetBinding

    companion object {
        const val WHOREACTEDLIST = "whoreactedlist"
        fun getNewInstance(whoReactedList: ArrayList<WhoReacted>) = WhoReactedBottomSheet().apply {
            val bundle = Bundle()
            bundle.putParcelableArrayList(WHOREACTEDLIST, whoReactedList)
            arguments = bundle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WhoReactedBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val whoReactedList = arguments?.getParcelableArrayList<WhoReacted>(WHOREACTEDLIST)

        val adapter = BottomSheetAdapter(childFragmentManager)

        if (whoReactedList != null) {
            for (whoReacted in whoReactedList) {
                val fragment = DynamicUserReactedFragment.getNewInstance(whoReacted.userList)
                adapter.addFragment(fragment, whoReacted.reactionTabTitle)
            }
        }

        binding.whoReactedViewpager.adapter = adapter
        binding.whoReactedTab.setupWithViewPager(binding.whoReactedViewpager)

    }
}