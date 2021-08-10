package co.eventbox.event.view.newtworking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.eventbox.event.R
import co.eventbox.event.utilities.MTab
import co.eventbox.event.view.newtworking.chat.ChatListFragment
import co.eventbox.event.view.newtworking.profile.ProfileFragment

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

        tabView = MTab(requireActivity(), childFragmentManager, R.id.tabNetworking, R.id.viewPagerNetworking)
        tabView.add(ProfileFragment().javaClass, "پروفایل شما")
        tabView.add(ChatListFragment().javaClass, "لیست چت ها")


    }
}