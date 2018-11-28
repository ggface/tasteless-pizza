package io.ggface.tastelesspizza.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import io.ggface.tastelesspizza.R;
import io.ggface.tastelesspizza.utils.PixelUtils;

/**
 * @author Ivan Novikov on 2017-09-19.
 */
public class CountDrawable extends Drawable {

    private Paint mBadgePaint;
    private Paint mTextPaint;
    private Rect mTxtRect = new Rect();
    private String mCount = "";
    private boolean mWillDraw;

    final private int mHorizontalPadding, mVerticalPaddind;

    public CountDrawable(Context context) {
        float mTextSize = context.getResources().getDimension(R.dimen.text_counter_size);

        mBadgePaint = new Paint();
        mBadgePaint.setColor(ContextCompat.getColor(context.getApplicationContext(), R.color.colorAccent));
        mBadgePaint.setAntiAlias(true);
        mBadgePaint.setStyle(Paint.Style.FILL);
        mBadgePaint.setAlpha(240);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTypeface(Typeface.DEFAULT);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mHorizontalPadding = PixelUtils.getPixelsFromDp(context, 1);
        mVerticalPaddind = PixelUtils.getPixelsFromDp(context, 1);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (!mWillDraw) {
            return;
        }
        Rect bounds = getBounds();
        float width = bounds.right - bounds.left;
        float height = bounds.bottom - bounds.top;

        float radius = ((Math.max(width, height) / 2)) / 2;
        float centerX = (width - radius - 1) + 5;
        float centerY = height - radius;//radius - 5;
        if (mCount.length() <= 2) {
            // Draw badge circle.
            canvas.drawCircle(centerX, centerY, (int) (radius + 5.5 + mHorizontalPadding + mVerticalPaddind), mBadgePaint);
        } else {
            canvas.drawCircle(centerX, centerY, (int) (radius + 7.5 + mHorizontalPadding + mVerticalPaddind), mBadgePaint);
        }
        // Draw badge count text inside the circle.
        mTextPaint.getTextBounds(mCount, 0, mCount.length(), mTxtRect);
        float textHeight = mTxtRect.bottom - mTxtRect.top;
        float textY = centerY + (textHeight / 2f);
        if (mCount.length() > 2) {
            canvas.drawText("99+", centerX, textY, mTextPaint);
        } else {
            canvas.drawText(mCount, centerX, textY, mTextPaint);
        }
    }

    public void setCount(String count) {
        mCount = count;

        // Only draw a badge if there are notifications.
        mWillDraw = !count.equalsIgnoreCase("0");
        invalidateSelf();
    }

    @Override
    public void setAlpha(int alpha) {
        // do nothing
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        // do nothing
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}