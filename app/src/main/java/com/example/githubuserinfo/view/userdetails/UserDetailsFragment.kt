package com.example.githubuserinfo.view.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.githubuserinfo.databinding.FragmentUserDetailsBinding
import com.example.githubuserinfo.model.SavedUser
import com.example.githubuserinfo.model.UserDetails
import com.example.githubuserinfo.view.UserDetailsFragmentArgs
import com.example.githubuserinfo.viewmodel.SavedUsersViewModel
import com.example.githubuserinfo.viewmodel.UserDetailsViewModel

class UserDetailsFragment : Fragment() {

    private val viewModel: UserDetailsViewModel by viewModels()
    private val savedUsersViewModel: SavedUsersViewModel by viewModels()
    private var binding: FragmentUserDetailsBinding? = null

    private val args: UserDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUserDetails(args.login)

        viewModel.userDetails.observe(viewLifecycleOwner) { userDetails ->
            binding?.apply {
                Glide.with(this@UserDetailsFragment)
                    .load(userDetails.avatarUrl)
                    .into(avatarImageView)

                nameTextView.text = userDetails.name
                typeTextView.text = userDetails.type
                emailTextView.text = "Email: " + userDetails.email
                orgTextView.text = "Organization: " +userDetails.company

                followingTextView.text = "Following: " +userDetails.following.toString()
                followersTextView.text = "Followers: " + userDetails.followers.toString()
                createdTextView.text = "Created at: " +userDetails.createdDate

                saveButton.setOnClickListener {
                    saveUser(userDetails)
                }
            }

        }
    }

    private fun saveUser(userDetails: UserDetails){
        val user = SavedUser(
            id = userDetails.id,
            name = userDetails.name,
            email = userDetails.email,
            avatarUrl = userDetails.avatarUrl
        )
        savedUsersViewModel.insertUser(user)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}