package io.ggface.tastelesspizza.ui.profile

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ggface.tastelesspizza.R
import kotlinx.android.synthetic.main.fragment_restore_password.*

/**
 * @author Ivan Novikov on 2017-09-19.
 */
class RestorePasswordFragment : Fragment() {

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_restore_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restore_button.setOnClickListener { }

        if (null == savedInstanceState) {
            val phone = activity!!.intent.getStringExtra(RestorePasswordActivity.EXTRA_PHONE)
            if (!TextUtils.isEmpty(phone)) {
                phone_edit_text.append(phone)
            }
        }
    }
    //endregion Lifecycle
}