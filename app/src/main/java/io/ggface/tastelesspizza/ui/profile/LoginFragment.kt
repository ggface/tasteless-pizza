package io.ggface.tastelesspizza.ui.profile

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ggface.tastelesspizza.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class LoginFragment : Fragment() {

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        terms_text_view.movementMethod = LinkMovementMethod()
        forgot_password_button.setOnClickListener { RestorePasswordActivity.start(activity!!, phone_edit_text.text.toString().trim()) }
    }
    //endregion Lifecycle
}