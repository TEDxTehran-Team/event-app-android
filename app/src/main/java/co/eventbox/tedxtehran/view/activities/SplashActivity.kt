package co.eventbox.tedxtehran.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.utilities.visible
import co.eventbox.tedxtehran.viewModel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), Observer<Boolean> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashViewModel.cacheData().observe(this, this)

        btnTryAgain.setOnClickListener {
            btnTryAgain.visibility = View.INVISIBLE
            progressBar.visible()
            splashViewModel.cacheData().observe(this, this)
        }
    }

    override fun onChanged(t: Boolean?) {
        if (t != null && t) {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        } else {
            btnTryAgain.visible()
            progressBar.gone()
        }
    }


}
