package com.hackathontv.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathontv.R;

public class HowToRoastDialog extends DialogFragment {

    public static final String TAG = "HOW_TO_ROAST";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.how_to_roast_dialog, container);
    }
}
