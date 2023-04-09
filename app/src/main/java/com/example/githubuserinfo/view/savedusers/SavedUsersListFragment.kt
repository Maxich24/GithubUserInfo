package com.example.githubuserinfo.view.savedusers

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuserinfo.databinding.FragmentSavedUsersListBinding
import com.example.githubuserinfo.viewmodel.SavedUsersViewModel

class SavedUsersListFragment : Fragment() {

    private val viewModel: SavedUsersViewModel by viewModels()

    private var binding: FragmentSavedUsersListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedUsersListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.allUsers.observe(viewLifecycleOwner) { userList ->
            val adapter = SavedUserListAdapter(userList)
            binding?.recyclerView?.adapter = adapter
        }
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}