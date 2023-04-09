package com.example.githubuserinfo.view.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.githubuserinfo.R
import com.example.githubuserinfo.databinding.FragmentUserListBinding
import com.example.githubuserinfo.view.UsersListFragmentDirections
import com.example.githubuserinfo.viewmodel.UserListViewModel

class UsersListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private lateinit var viewModel: UserListViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UserListViewModel::class.java]

        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupObservers()
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getUsers()
        }
    }

    private fun setupObservers() {
        viewModel.users.observe(viewLifecycleOwner) { users ->
            binding.swipeRefreshLayout.isRefreshing = false
            val adapter = UsersListAdapter(users) { user ->
                val action =
                    UsersListFragmentDirections.actionUsersListFragmentToUserDetailsFragment(user.login)
                navController.navigate(action)
            }
            binding.usersRecyclerView.adapter = adapter
        }
    }
}