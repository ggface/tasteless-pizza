package io.ggface.tastelesspizza.ui.profile

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import io.ggface.tastelesspizza.R
import io.ggface.tastelesspizza.ui.widget.ValidEditText
import kotlinx.android.synthetic.main.fragment_create_account.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class CreateAccountFragment : Fragment() {

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        terms_check_box.movementMethod = LinkMovementMethod()
        switch_to_login_button.setOnClickListener { LoginActivity.start(activity!!) }

        create_account_button.setOnClickListener {
            if (!isCorrectInputValues(name_edit_text, phone_edit_text, email_edit_text, password_edit_text)) {
                Snackbar.make(activity!!.findViewById(R.id.content), "Fill gaps", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    //endregion Lifecycle

    private fun isCorrectInputValues(vararg editText: ValidEditText): Boolean {
        var correct = true

        for (view in editText) {
            if (!view.isCorrectValue) {
                if (correct) {
                    correct = false
                }
            }
        }
        return correct
    }
}