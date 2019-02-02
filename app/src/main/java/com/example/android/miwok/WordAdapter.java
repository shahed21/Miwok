package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * This class extends ArrayAdapter to override the getView method to accept a listItem View
 */
public class WordAdapter extends ArrayAdapter {
    private int mColorResourceId;

    /**
     * This is a constructor that takes the ArrayList of Words to form an ArrayAdapter with a
     * listItem View
     *
     * @param fragment
     * @param words ArrayList of Words
     * @param colorResourceId
     */
    public WordAdapter(Fragment fragment, ArrayList<Word> words, int colorResourceId) {
        // resource is zero, because second argument is not used when TextView is not used
        super(fragment.getContext(), 0, words);
        this.mColorResourceId = colorResourceId;
    }

    /**
     * This method overrides the ArrayAdapter method of the same name to populate Word data into a
     * listItem View already defined in resources
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} at this position in the list
        Word currentWord = (Word) getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.word_icon);
        LinearLayout textContainerLayout = (LinearLayout) listItemView.findViewById(R.id.text_container);

        textContainerLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        defaultTextView.setText(currentWord.getDefaultTranslation());
        miwokTextView.setText(currentWord.getMiwokTranslation());
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceID());
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
