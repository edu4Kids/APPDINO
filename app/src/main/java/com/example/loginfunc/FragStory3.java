package com.example.loginfunc;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragStory3 extends Fragment {
    private View view;
    private Button gotoguide;
    public static StorytellingActivity activity;

    public static com.example.loginfunc.FragStory3 newInstance(StorytellingActivity act){
        FragStory3 fragStory3 = new FragStory3();
        activity = act;
        return fragStory3;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.story_3, container, false);
        gotoguide = view.findViewById(R.id.gotoguidebutton);

        gotoguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle(); //꾸러미
//                bundle.putString("fromFragStorytelling", "toGuideStorytelling");
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                FragMonday fragMonday = new FragMonday();
//                fragMonday.setArguments(bundle);
//                transaction.replace(R.id.frameLayout, fragMonday);
//                transaction.commit();
                activity.movePage();
            }
        });
        return view;
    }
}
