package com.example.soundpeeps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.soundpeeps.Cards.cards;
import com.example.soundpeeps.Matches.MatchesActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MainConcertActivity extends AppCompatActivity {
    private cards cards_data[];
    private com.example.soundpeeps.Cards.arrayAdapter arrayAdapter;
    private int i;
    private FirebaseAuth mAuth;
    private String currentUId;
    private DatabaseReference usersDb;
    ListView listView;
    List<cards> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainconcert);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_concerts, R.id.navigation_likes, R.id.navigation_chat, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }







    public void goToMatches(View view) {
        Intent intent = new Intent(MainConcertActivity.this, MatchesActivity.class);
        startActivity(intent);
        return;
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(MainConcertActivity.this, SettingsActivity.class);
        startActivity(intent);
        return;
    }

    public void logoutUser(android.view.View view) {
        mAuth.signOut();
        Intent intent = new Intent(MainConcertActivity.this, SelectLoginSignupActivity.class);
        startActivity(intent);
        finish();
        return;
    }


}