package co.eventbox.event.view.newtworking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.eventbox.event.R
import co.eventbox.event.utilities.MTab
import co.eventbox.event.view.newtworking.chat.ChatListFragment
import co.eventbox.event.view.newtworking.profile.ProfileFragment
import co.eventbox.event.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*


/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 2021/08.
 */

class NetworkingFragment : Fragment() {

    lateinit var tabView: MTab

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_networking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        // (activity as AppCompatActivity?)?.supportActionBar?.hide()

        tabView = MTab(
            requireActivity(),
            childFragmentManager,
            R.id.tabNetworking,
            R.id.viewPagerNetworking
        )
        tabView.add(ProfileFragment().javaClass, getString(R.string.profile_tab))
        tabView.add(ChatListFragment().javaClass, getString(R.string.chats_tab))


    }
}