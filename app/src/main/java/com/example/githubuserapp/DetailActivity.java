package com.example.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView githubAvatar = findViewById(R.id.detailAvatar);
        TextView githubName = findViewById(R.id.detailName);
        TextView githubUsername = findViewById(R.id.detailUsername);
        TextView githubCompany = findViewById(R.id.detailCompany);
        TextView githubLocation = findViewById(R.id.detailLocation);
        TextView githubRepository = findViewById(R.id.detailRepository);
        TextView githubFollowers = findViewById(R.id.detailFollowers);
        TextView githubFollowing = findViewById(R.id.detailFollowing);

        Github gitHub = getIntent().getParcelableExtra("dataParcelable");

        githubName.setText(gitHub.getName());
        githubUsername.setText(gitHub.getUsername());
        githubCompany.setText(gitHub.getCompany());
        githubLocation.setText(gitHub.getLocation());
        githubRepository.setText(gitHub.getRepository());
        githubFollowers.setText(gitHub.getFollowers());
        githubFollowing.setText(gitHub.getFollowing());
        Glide.with(this).load(gitHub.getAvatar())
                .apply(new RequestOptions().override(200,200))
                .into(githubAvatar);

        setTitle(gitHub.getUsername());
    }
}
