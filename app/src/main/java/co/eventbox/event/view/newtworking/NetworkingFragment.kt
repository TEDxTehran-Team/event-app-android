package co.eventbox.event.view.newtworking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.eventbox.event.R
import co.eventbox.event.utilities.MTab
import kotlinx.android.synthetic.main.fragment_networking.*

/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 2021/08.
 */

class NetworkingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_networking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val makeTab = MTab(requireActivity(), R.id.tabNetworking, R.id.viewPagerNetworking)
        makeTab.add(ProfileFragment().javaClass, "پروفایل شما")
        makeTab.add(ChatListFragment().javaClass, "لیست چت ها")


    }
}