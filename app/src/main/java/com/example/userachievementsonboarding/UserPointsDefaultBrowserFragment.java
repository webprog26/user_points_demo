package com.example.userachievementsonboarding;;

public final class UserPointsDefaultBrowserFragment extends UserPointsAbstractFragment {

    private static final int USER_POINTS_FOR_SETTING_BROWSER_AS_DEFAULT = 100;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_user_points_default_browser;
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
        return USER_POINTS_FOR_SETTING_BROWSER_AS_DEFAULT;
    }
}
