package io.ggface.tastelesspizza.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import io.ggface.tastelesspizza.R;

/**
 * @author Ivan Novikov on 2017-09-19.
 */
public class ValidEditText extends AppCompatEditText {

    public ValidEditText(Context context) {
        super(context);
        init();
    }

    public ValidEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ValidEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onAttachedToWindow() {
        if (!isInEditMode()) {
            super.onAttachedToWindow();
        }
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(getText().toString().trim());
    }

    public boolean isCorrectValue() {
        boolean result;
        if (isEmpty()) {
            result = false;
            updateBackground(R.drawable.background_input_warning);
        } else {
            result = true;
            updateBackground(R.drawable.background_input);
        }
        return result;
    }

    private void init() {
        setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                updateBackground(R.drawable.background_input);
            }
        });
    }

    private void updateBackground(@DrawableRes int id) {
        setBackground(ContextCompat.getDrawable(getContext(), id));
    }
}