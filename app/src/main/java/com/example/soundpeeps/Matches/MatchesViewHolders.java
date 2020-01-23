package com.example.soundpeeps.Matches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundpeeps.Chat.ChatActivity;
import com.example.soundpeeps.R;

public class MatchesViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView mMatchId, mMatchName;
    public ImageView mMatchImage;
    public MatchesViewHolders(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        mMatchId = itemView.findViewById(R.id.Matchid);
        mMatchName = itemView.findViewById(R.id.MatchName);
        mMatchImage = itemView.findViewById(R.id.MatchImage);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent (itemView.getContext(), ChatActivity.class);
        Bundle b = new Bundle();
        b.putString("matchId", mMatchId.getText().toString());
        intent.putExtras(b);
        itemView.getContext().startActivity(intent);
    }
}
