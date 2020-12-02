package com.example.loginfunc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragStory1 extends Fragment {
    private View view;

    public static com.example.loginfunc.FragStory1 newInstance(){
        FragStory1 fragStory1 = new FragStory1();
        return fragStory1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.story_1, container, false);

        return view;
    }



}
