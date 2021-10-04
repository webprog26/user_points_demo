package com.example.userachievementsonboarding;

public final class UserPointsPointsSearchFragment extends UserPointsAbstractFragment {

    private static final int USER_POINTS_FOR_MAKING_WEB_SEARCH = 20;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_user_points_search;
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
        return USER_POINTS_FOR_MAKING_WEB_SEARCH;
    }
}
