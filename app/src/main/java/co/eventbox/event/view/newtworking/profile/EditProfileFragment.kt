package co.eventbox.event.view.newtworking.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.eventbox.event.R
import co.eventbox.event.model.User
import co.eventbox.event.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_edit_profile.*

/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 2021/08.
 */

class EditProfileFragment : Fragment() {

    //lateinit var viewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        btnEditProfileSave.setOnClickListener {
            val story = txtEditProfileStory.text.toString()
            val phone = txtEditProfilePhone.text.toString()
            val email = txtEditProfileEmail.text.toString()
            val name = txtEditProfileFullName.text.toString()
            val interested = txtEditProfileInterested.text.toString()
            val university = txtEditProfileUniversity.text.toString()
            val job = txtEditProfileJob.text.toString()

            val user = User.toUser()
            user.story = story
            user.phone = phone
            user.interested = interested
            user.email = email
            user.name = name
            user.university = university
            user.job = job

            viewModel._user.value = user

            findNavController().navigate(R.id.action_editProfileFragment_to_networkingFragment)

        }


    }

}