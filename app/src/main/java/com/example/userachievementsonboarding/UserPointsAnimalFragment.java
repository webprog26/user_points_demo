package com.example.userachievementsonboarding;

public final class UserPointsAnimalFragment extends UserPointsAbstractFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_user_points_animal;
    }

    @Override
    protected int getPageMarksViewId() {
        return R.id.pagemarks;
    }
}
