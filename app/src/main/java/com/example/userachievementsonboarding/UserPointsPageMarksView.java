package com.example.userachievementsonboarding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

final class UserPointsPageMarksView extends LinearLayout {

    private ImageView[] mPageMarks;

    public UserPointsPageMarksView(Context context) {
        super(context);
        init();
    }

    public UserPointsPageMarksView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public void setPageMarksNumber(final int pageMarksCount) {
        final ImageView[] pageMarks = new ImageView[pageMarksCount];
        final Context context = getContext();
        for (int i = 0; i < pageMarksCount; i++) {

            final ImageView pageMarkView = new ImageView(context);
            final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            final int PAGE_MARK_ITEM_MARGIN_END = 18;
            layoutParams.setMarginEnd(PAGE_MARK_ITEM_MARGIN_END);
            pageMarkView.setLayoutParams(layoutParams);
            pageMarkView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.user_points_pagemark_inactive));

            addView(pageMarkView);
            pageMarks[i] = pageMarkView;
        }
        this.mPageMarks = pageMarks;
        updatePageMark(0);

    }

    public void updatePageMark(final int position) {
        if (mPageMarks != null && !(position > mPageMarks.length)) {
            maybeResetPageMark(0);
            final ImageView pageMarkView = mPageMarks[position];
            if (pageMarkView != null) {
                final Drawable pageMarkActiveDrawable = ContextCompat.getDrawable(getContext(), R.drawable.user_points_pagemark_active);
                pageMarkView.setImageDrawable(pageMarkActiveDrawable);
            }
        }
    }

    private void maybeResetPageMark(final int position) {
        final ImageView pageMarkView = mPageMarks[position];
        if (pageMarkView != null) {
            final Drawable pageMarkInactiveDrawable = ContextCompat.getDrawable(getContext(), R.drawable.user_points_pagemark_inactive);
            pageMarkView.setImageDrawable(pageMarkInactiveDrawable);
        }
    }
}
