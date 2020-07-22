package com.example.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Github> githubData;
    private GithubAdapter githubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView githubList = findViewById(R.id.list_items);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        githubList.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        githubData = new ArrayList<>();

        githubAdapter = new GithubAdapter(this, githubData);
        githubList.setAdapter(githubAdapter);

        initializeData();

        setTitle("Github User's");
    }

    private void initializeData() {
        TypedArray githubAvatar = getResources().obtainTypedArray(R.array.avatar);
        String[] githubName = getResources().getStringArray(R.array.name);
        String[] githubUsername = getResources().getStringArray(R.array.username);
        String[] githubCompany = getResources().getStringArray(R.array.company);
        String[] githubLocation = getResources().getStringArray(R.array.location);
        String[] githubRepository = getResources().getStringArray(R.array.repository);
        String[] githubFollowers = getResources().getStringArray(R.array.followers);
        String[] githubFollowing = getResources().getStringArray(R.array.following);

        githubData.clear();

        for(int i=0; i<githubName.length; i++){
            githubData.add(new Github(githubName[i],
                    githubUsername[i],
                    githubCompany[i],
                    githubLocation[i],
                    githubRepository[i],
                    githubFollowers[i],
                    githubFollowing[i],
                    githubAvatar.getResourceId(i,0)));
        }

        githubAvatar.recycle();
        githubAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
