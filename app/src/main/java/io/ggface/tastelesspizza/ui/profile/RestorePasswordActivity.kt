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
class RestorePasswordActivity : AppCompatActivity() {

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password)
        initToolbar()
    }
    //endregion Lifecycle

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    companion object {

        const val EXTRA_PHONE = "EXTRA_PHONE"

        fun start(activity: Activity, phone: String) {
            val intent = Intent(activity, RestorePasswordActivity::class.java)
            intent.putExtra(EXTRA_PHONE, phone)
            activity.startActivity(intent)
        }
    }
}