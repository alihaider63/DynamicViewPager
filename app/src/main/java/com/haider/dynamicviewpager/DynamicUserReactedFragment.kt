package com.haider.dynamicviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.haider.dynamicviewpager.databinding.FragmentDynamicUserReactedBinding

class DynamicUserReactedFragment : Fragment() {

    lateinit var binding: FragmentDynamicUserReactedBinding
    lateinit var adapter: DynamicUserReactedAdapter

    companion object {
        const val DYNAMICUSERLIST = "dynamicuserlist"
        fun getNewInstance(userList: ArrayList<User>) = DynamicUserReactedFragment().apply {
            val bundle = Bundle()
            bundle.let {
                it.putParcelableArrayList(DYNAMICUSERLIST, userList)
            }
            arguments = bundle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDynamicUserReactedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userList = arguments?.getParcelableArrayList<User>(DYNAMICUSERLIST)

        val context = context
        if (userList != null && context != null) {
            adapter = DynamicUserReactedAdapter(userList, context)
        }

        binding.recyclerViewReactedUser.adapter = adapter
        binding.recyclerViewReactedUser.layoutManager = LinearLayoutManager(context)

    }

}