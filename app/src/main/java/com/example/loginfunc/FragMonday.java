package com.example.loginfunc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragMonday extends Fragment {
    private View view;
    private Button guide_button1;
    private static GuideActivity activity;

    private String result;

    public static FragMonday newInstance(GuideActivity act){
        FragMonday fragMonday = new FragMonday();
        activity = act;
        return fragMonday;
    }




    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guide_1, container, false);
        guide_button1 = view.findViewById(R.id.guide_button);

        guide_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.movePage();
            }
        });

        return view;
    }
}
