package com.example.loginfunc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragStory2 extends Fragment {
    private View view;

    public static com.example.loginfunc.FragStory2 newInstance(){
        FragStory2 fragStory2 = new FragStory2();
        return fragStory2;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.story_2, container, false);

        return view;
    }
}
