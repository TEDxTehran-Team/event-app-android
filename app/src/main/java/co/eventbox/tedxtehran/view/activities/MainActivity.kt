package co.eventbox.tedxtehran.view.activities

import android.os.Bundle
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.view.ProfileBottomSheet
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-06.
 */

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imgProfile.setOnClickListener {
            val bottomSheetProfile = ProfileBottomSheet()
            bottomSheetProfile.show(supportFragmentManager, ProfileBottomSheet::javaClass.name)
        }
    }
}
