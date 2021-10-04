package com.example.userachievementsonboarding;

public final class UserPointsWebsiteFragment extends UserPointsAbstractFragment {

    private static final int USER_POINTS_FOR_VISITING_WEBSITE = 1;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_user_points_website;
    }

    @Override
    protected int getPageMarksViewId() {
        return R.id.pagemarks;
    }

    @Override
    protected int getPointsViewId() {
        return R.id.points_view;
    }

    @Override
    protected int getPointsCount() {
        return USER_POINTS_FOR_VISITING_WEBSITE;
    }
}
