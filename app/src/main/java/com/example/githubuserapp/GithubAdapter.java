package com.example.githubuserapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GithubAdapter extends
        RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {
    private final ArrayList<Github> mGithubData;

    private final Context mContext;

    GithubAdapter(Context context, ArrayList<Github> gitUser) {
        this.mGithubData = gitUser;
        this.mContext = context;

        GradientDrawable mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.user11);

        if (drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GithubViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.github_user_list, parent, false));
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {
        Github currentGithub = mGithubData.get(position);
        holder.bindTo(currentGithub);
    }

    @Override
    public int getItemCount() {
        return mGithubData.size();
    }

    static class GithubViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mNameText;
        private final TextView mUsernameText;
        private final ImageView mAvatar;
        private final Context mContext;
        private Github mCurrentGithub;

        GithubViewHolder(Context context, View itemView) {
            super(itemView);
            mNameText = itemView.findViewById(R.id.github_name);
            mUsernameText = itemView.findViewById(R.id.github_username);
            mAvatar = itemView.findViewById(R.id.github_avatar);
            mContext = context;

            itemView.setOnClickListener(this);
        }

        void bindTo(Github currentGithub) {
            mNameText.setText(currentGithub.getName());
            mUsernameText.setText(currentGithub.getUsername());
            mCurrentGithub = currentGithub;

            Glide.with(mContext).load(currentGithub.
                    getAvatar()).apply(new RequestOptions().override(60,60)).
                    into(mAvatar);
        }

        @Override
        public void onClick(View view) {
            Github d = mCurrentGithub;
            Intent in = new Intent(view.getContext(), DetailActivity.class);

            in.putParcelableArrayListExtra("dataParcelable", d);
            mContext.startActivity(in);

            Toast.makeText(view.getContext(), "Anda memilih " + mCurrentGithub.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}