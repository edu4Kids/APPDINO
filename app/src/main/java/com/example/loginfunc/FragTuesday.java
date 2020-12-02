package com.example.loginfunc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragTuesday extends Fragment {
    private View view;
    private Button guide_button2;
    private static GuideActivity activity;

    public static FragTuesday newInstance(GuideActivity act){
        FragTuesday fragTuesday = new FragTuesday();
        activity = act;
        return fragTuesday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guide_2, container, false);
        guide_button2 = view.findViewById(R.id.guide_button2);

        guide_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.movePage();
            }
        });
        return view;
    }
}
