package co.eventbox.event.view.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.eventbox.event.R
import co.eventbox.event.utilities.*
import co.eventbox.event.viewModel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_splash.*


/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 2020-12-28.
 */
class SplashFragment : Fragment(), Observer<Boolean> {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        hideAppbar()
        hideBottomNav()
        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashViewModel.cacheData().observe(viewLifecycleOwner, this)

        btnTryAgain.setOnClickListener {
            btnTryAgain.visibility = View.INVISIBLE
            progressBar.visible()
            splashViewModel.cacheData().observe(viewLifecycleOwner, this)
        }
    }


    override fun onChanged(t: Boolean?) {
        if (t != null && t) {
            findNavController().navigate(R.id.action_splashFragment_to_speakersFragment)
            showAppbar()
        } else {
            btnTryAgain.visible()
            progressBar.gone()
        }

    }
}