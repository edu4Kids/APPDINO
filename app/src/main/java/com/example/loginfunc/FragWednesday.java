package com.example.loginfunc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragWednesday extends Fragment {
    private View view;
    private Button guide_button3;
    private static GuideActivity activity;

    public static FragWednesday newInstance(GuideActivity act){
        FragWednesday fragWednesday = new FragWednesday();
        activity = act;
        return fragWednesday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guide_3, container, false);
        guide_button3 = view.findViewById(R.id.guide_button3);

        guide_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.movePage();
            }
        });

        return view;
    }
}
