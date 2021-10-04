package com.example.userachievementsonboarding;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class FirstRunPager extends ViewPager {

    @IntDef({
            SwipeDirection.ALL,
            SwipeDirection.LEFT,
            SwipeDirection.RIGHT,
            SwipeDirection.NONE
    })
    @Retention(RetentionPolicy.SOURCE)

    @interface SwipeDirection {

        int ALL = 0;

        int LEFT = 1;

        int RIGHT = 2;

        int NONE = 3;
    }

    private float initialXValue;
    private @SwipeDirection int direction;

    public FirstRunPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.direction = SwipeDirection.NONE;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isSwipeAllowed(event)) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (isSwipeAllowed(event)) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    private boolean isSwipeAllowed(MotionEvent event) {
        if (direction == SwipeDirection.ALL) return true;

        if (direction == SwipeDirection.NONE)//disable any swipe
            return false;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            initialXValue = event.getX();
            return true;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            final float diffX = event.getX() - initialXValue;
            if (diffX > 0 && (direction == SwipeDirection.RIGHT)) {
                return false;
            } else return !(diffX < 0) || (direction != SwipeDirection.LEFT);
        }

        return true;
    }
}

