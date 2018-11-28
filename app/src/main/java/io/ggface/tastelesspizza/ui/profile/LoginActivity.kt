package io.ggface.tastelesspizza.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ggface.tastelesspizza.R
import kotlinx.android.synthetic.main.view_toolbar.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class LoginActivity : AppCompatActivity() {

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
    //endregion Lifecycle

    companion object {

        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
        }
    }
}