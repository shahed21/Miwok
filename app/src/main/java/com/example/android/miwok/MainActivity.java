package com.example.android.miwok;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.v(LOG_TAG, "onCreate");
//
//        TextView numbers = (TextView)findViewById(R.id.numbers);
//        numbers.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                openNumbersList(view);
//            }
//        });
//        TextView colors = (TextView)findViewById(R.id.colors);
//        colors.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                openColorsList(view);
//            }
//        });
//        TextView familyMembers = (TextView)findViewById(R.id.family);
//        familyMembers.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                openFamilyMembersList(view);
//            }
//        });
//        TextView phrases = (TextView)findViewById(R.id.phrases);
//        phrases.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                openPhrasesList(view);
//            }
//        });
//    }
//
//    /**
//     * This method handles clicking on Numbers TextView
//     * @param view refering view
//     */
//    public void openNumbersList(View view) {
//        Log.v(LOG_TAG, "openNumbersList");
//        Intent intent = new Intent(this, NumbersFragment.class);
//        startActivity(intent);
//    }
//
//    /**
//     * This method handles clicking on Colors TextView
//     * @param view refering view
//     */
//    public void openColorsList(View view) {
//        Log.v(LOG_TAG, "openColorsList");
//        Intent intent = new Intent(this, ColorsFragment.class);
//        startActivity(intent);
//    }
//
//    /**
//     * This method handles clicking on Phrases TextView
//     * @param view refering view
//     */
//    public void openPhrasesList(View view) {
//        Log.v(LOG_TAG, "openPhrasesList");
//        Intent intent = new Intent(this, PhrasesFragment.class);
//        startActivity(intent);
//    }
//
//    /**
//     * This method handles clicking on Family Members TextView
//     * @param view refering view
//     */
//    public void openFamilyMembersList(View view) {
//        Log.v(LOG_TAG, "openFamilyMembersList");
//        Intent intent = new Intent(this, FamilyMembersFragment.class);
//        startActivity(intent);
//    }
}
