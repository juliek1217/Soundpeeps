package com.example.soundpeeps.Fragment.ui.concerts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

//import com.example.soundpeeps.Matches.R;
import com.example.soundpeeps.R;

public class ConcertsFragment extends Fragment {

    private ConcertsViewModel concertsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        concertsViewModel =
                ViewModelProviders.of(this).get(ConcertsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_concerts, container, false);
        final TextView textView = root.findViewById(R.id.text_concerts);
        concertsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}