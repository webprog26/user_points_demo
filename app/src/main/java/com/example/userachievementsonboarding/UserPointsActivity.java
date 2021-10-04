package com.example.userachievementsonboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public final class UserPointsActivity extends AppCompatActivity implements UserPointsAbstractFragment.UserPointsSlidesOwner {

    private final List<UserPointsAbstractFragment> mSlides = new ArrayList<>();

    private interface OnPageChangedCallback {
        void onPageChanged(final int position);
    }

    private FirstRunPager mPager;
    private Button mBtnNext;
    private IteoraUserAchievementsAdapter mAdapter;
    private int mPagerCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_points);

        mSlides.add(new UserPointsAboutFragment());
        mSlides.add(new UserPointsDefaultBrowserFragment());
        mSlides.add(new UserPointsPointsSearchFragment());
        mSlides.add(new UserPointsWebsiteFragment());
        mSlides.add(new UserPointsAnimalFragment());

        final int slidesNumber = mSlides.size() - 1;

        mBtnNext = (Button) findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener((v) -> {
            if (mPagerCurrentPosition < slidesNumber) {
                mPager.setCurrentItem(mPagerCurrentPosition + 1);
            } else {
                finish();
            }
        });

        this.mPager = (FirstRunPager) findViewById(R.id.pager);
        this.mAdapter = new IteoraUserAchievementsAdapter(getSupportFragmentManager(), mSlides);
        mPager.setAdapter(mAdapter);
        final OnSlidesPageChangeListener pageChangeListener = new OnSlidesPageChangeListener((position) -> {
            mPagerCurrentPosition = position;
            updatePageMark(position);

            if (mPagerCurrentPosition == slidesNumber) {
                mBtnNext.setText(getString(R.string.user_achievements_button_done_text));
            }
        });
        mPager.addOnPageChangeListener(pageChangeListener);
    }

    private static class IteoraUserAchievementsAdapter extends FragmentPagerAdapter {

        private final List<UserPointsAbstractFragment> slides;

        public IteoraUserAchievementsAdapter(FragmentManager fm, List<UserPointsAbstractFragment> slides) {
            super(fm);
            this.slides = slides;
        }

        @Override
        public Fragment getItem(int position) {
            return slides.get(position);
        }

        @Override
        public int getCount() {
            return slides.size();
        }
    }

    @Override
    public int getSlidesNumber() {
        return mSlides.size();
    }

    private void updatePageMark(final int position) {
        final Fragment currentFragment = mAdapter.getItem(position);
        if (currentFragment instanceof UserPointsAbstractFragment) {
            ((UserPointsAbstractFragment) currentFragment).updatePageMark(position);
        }
    }

    private static class OnSlidesPageChangeListener implements ViewPager.OnPageChangeListener {
        private final OnPageChangedCallback mPageChangedCallback;

        public OnSlidesPageChangeListener(OnPageChangedCallback mPageChangedCallback) {
            this.mPageChangedCallback = mPageChangedCallback;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (mPageChangedCallback != null) {
                mPageChangedCallback.onPageChanged(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}