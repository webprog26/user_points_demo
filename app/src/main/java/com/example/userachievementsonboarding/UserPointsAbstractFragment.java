package com.example.userachievementsonboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class UserPointsAbstractFragment extends Fragment {

    interface UserPointsSlidesOwner {

        int getSlidesNumber();
    }

    protected UserPointsSlidesOwner mSlidesOwner;
    private UserPointsPageMarksView mPageMarksView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof UserPointsSlidesOwner) {
            this.mSlidesOwner = (UserPointsSlidesOwner) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        @IdRes final int pageMarksViewId = getPageMarksViewId();
        if (pageMarksViewId != 0) {
            mPageMarksView = (UserPointsPageMarksView) view.findViewById(pageMarksViewId);
            if (mPageMarksView != null) {
                mPageMarksView.setPageMarksNumber(mSlidesOwner.getSlidesNumber());
            }
        }

        @IdRes final int pointsViewId = getPointsViewId();
        if (pointsViewId != 0) {
            final UserPointsView mPointsView = (UserPointsView) view.findViewById(pointsViewId);
            if (mPointsView != null) {
                final int pointsCount = getPointsCount();
                if (pointsCount != 0) {
                    mPointsView.setPoints(pointsCount);
                }
            }
        }
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    @IdRes
    protected abstract int getPageMarksViewId();

    @IdRes
    protected int getPointsViewId() {
        return 0;
    }

    protected int getPointsCount() {
        return 0;
    }

    public void updatePageMark(final int position) {

        if (mPageMarksView != null) {
            mPageMarksView.updatePageMark(position);
        }
    }

}
