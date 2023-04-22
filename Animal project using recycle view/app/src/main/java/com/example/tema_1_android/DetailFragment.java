package com.example.tema_1_android;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    private static Animal a;
    public DetailFragment() {
        // Required empty public constructor
    }
    public static DetailFragment newInstance(Animal param1) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        a = param1;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        TextView titleTV= view.findViewById(R.id.titleTV);
        titleTV.setText(a.getContinent()+"\n"+a.getName());
        switch (a.getContinent()) {
            case "Europa":
                titleTV.setBackgroundResource(R.color.europa);
                break;
            case "Americi":
                titleTV.setBackgroundResource(R.color.americi);
                break;
            case "Australia":
                titleTV.setBackgroundResource(R.color.australia);
                break;
            case "Asia":
                titleTV.setBackgroundResource(R.color.asia);
                break;
            case "Africa":
                titleTV.setBackgroundResource(R.color.africa);
                break;
            default:
                titleTV.setBackgroundColor(Color.TRANSPARENT);
        }

        return view;
    }
}