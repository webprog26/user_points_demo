package com.example.userachievementsonboarding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserAchievementsCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_points_card);
        findViewById(R.id.btn_how_it_works).setOnClickListener((v) -> {
            startActivity(new Intent(UserAchievementsCardActivity.this, UserPointsActivity.class));
        });
    }
}