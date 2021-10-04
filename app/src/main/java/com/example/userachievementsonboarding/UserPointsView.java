package com.example.userachievementsonboarding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

final class UserPointsView extends FrameLayout {

    private TextView mTvPoints;

    public UserPointsView(@NonNull Context context) {
        super(context);
        init();
    }

    public UserPointsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.user_points_container_bg));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTvPoints = (TextView) findViewById(R.id.tv_user_points);
    }

    public void setPoints(final int points) {
        mTvPoints.setText(String.valueOf(points));
        setVisibility(View.VISIBLE);
    }
}
