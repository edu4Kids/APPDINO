package com.example.loginfunc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragThursday extends Fragment {
    private View view;
    private Button guide_button4;
    private static GuideActivity activity;

    public static FragThursday newInstance(GuideActivity act){
        FragThursday fragThursday = new FragThursday();
        activity = act;
        return fragThursday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guide_4, container, false);
        guide_button4 = view.findViewById(R.id.guide_button4);

        guide_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.movePage();
            }
        });
        return view;
    }
}
