package co.eventbox.event.view.newtworking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.eventbox.event.R
import co.eventbox.event.utilities.CustomTabView
import co.eventbox.event.view.newtworking.chat.ChatListFragment
import co.eventbox.event.view.newtworking.profile.ProfileFragment


/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 2021/08.
 */

class NetworkingFragment : Fragment() {

    lateinit var tabView: CustomTabView

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

        tabView = CustomTabView(
            requireActivity(),
            childFragmentManager,
            R.id.tabNetworking,
            R.id.viewPagerNetworking
        )
        tabView.add(ProfileFragment().javaClass, getString(R.string.profile_tab))
        tabView.add(ChatListFragment().javaClass, getString(R.string.chats_tab))


    }
}