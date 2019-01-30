package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method handles clicking on Numbers TextView
     * @param view refering view
     */
    public void openNumbersList(View view) {
        Intent intent = new Intent(this, NumbersActivity.class);
        startActivity(intent);
    }

    /**
     * This method handles clicking on Colors TextView
     * @param view refering view
     */
    public void openColorsList(View view) {
        Intent intent = new Intent(this, ColorsActivity.class);
        startActivity(intent);
    }

    /**
     * This method handles clicking on Phrases TextView
     * @param view refering view
     */
    public void openPhrasesList(View view) {
        Intent intent = new Intent(this, PhrasesActivity.class);
        startActivity(intent);
    }

    /**
     * This method handles clicking on Family Members TextView
     * @param view refering view
     */
    public void openFamilyMembersList(View view) {
        Intent intent = new Intent(this, FamilyMembersActivity.class);
        startActivity(intent);
    }
}
