package co.eventbox.tedxtehran.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.viewModel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashViewModel.test().observe(this, Observer {
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        })
    }
}
