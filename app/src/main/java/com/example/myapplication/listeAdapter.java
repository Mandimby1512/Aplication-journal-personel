package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class listeAdapter extends ArrayAdapter<liste> {

    private ArrayList<liste> listeArrayList;

    public listeAdapter(Context context, ArrayList<liste> listeArrayList) {
        super(context, 0, listeArrayList);
        this.listeArrayList = listeArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layoutliste, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textView2);
        liste currentListe = getItem(position);

        if (currentListe != null) {
            textView.setText(currentListe.getName());
        }

        return convertView;
    }
}
