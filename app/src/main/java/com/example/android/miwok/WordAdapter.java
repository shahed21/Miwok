package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * This class extends ArrayAdapter to override the getView method to accept a listItem View
 */
public class WordAdapter extends ArrayAdapter {
    /**
     * This is a constructor that takes the ArrayList of Words to form an ArrayAdapter with a
     * listItem View
     * @param context
     * @param words ArrayList of Words
     */
    public WordAdapter(Activity context, ArrayList<Word> words) {
        // resource is zero, because second argument is not used when TextView is not used
        super(context, 0, words);
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

        defaultTextView.setText(currentWord.getDefaultTranslation());
        miwokTextView.setText(currentWord.getMiwokTranslation());
        return listItemView;
    }
}
