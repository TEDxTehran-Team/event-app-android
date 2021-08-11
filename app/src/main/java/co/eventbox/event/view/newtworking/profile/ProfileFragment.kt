package co.eventbox.event.view.newtworking.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import co.eventbox.event.R
import co.eventbox.event.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.security.auth.login.LoginException

/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 2021/08.
 */

class ProfileFragment : Fragment() {

    //lateinit var viewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val viewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel::class.java)

        viewModel._user.observe(viewLifecycleOwner, {
                Log.i("test", "profile: null")

            if (it != null) {
                Log.i("test", "profile: ${it}")
                Log.i("test", "profile: ${it.name}")

                with(it) {
                    txtProfileName.text = name
                    txtProfileStory.text = story
                    txtProfilePhone.text = phone
                    txtProfileInterested.text = interested
                    txtProfileEmail.text = email
                    txtProfileJob.text = job
                    txtProfileUnivesity.text = university
                }
            }
        })

        viewModel.log()

        btnRegisterCode.setOnClickListener {
            findNavController().navigate(R.id.action_networkingFragment_to_editProfileFragment)
        }

    }
}