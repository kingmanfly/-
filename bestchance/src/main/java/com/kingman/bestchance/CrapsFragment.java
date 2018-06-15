package com.kingman.bestchance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by wb-lijinwei.a on 2016/5/12.
 */
public class CrapsFragment  extends Fragment implements View.OnClickListener{
    LinearLayout container;
    ImageView craps;
    boolean isStart = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_craps, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = (LinearLayout)view.findViewById(R.id.linearLayout_craps);
        craps = (ImageView) view.findViewById(R.id.craps);
        craps.setOnClickListener(this);
        container.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Util.stopAnimation(craps);
        craps = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearLayout_craps:
                if(isStart){
                    isStart = false;
                    switch (RandomGenerator.generator(1000) % 6){
                        case 0:
                            craps.setImageResource(R.drawable.dice_one);
                            break;
                        case 1:
                            craps.setImageResource(R.drawable.dice_two);
                            break;
                        case 2:
                            craps.setImageResource(R.drawable.dice_three);
                            break;
                        case 3:
                            craps.setImageResource(R.drawable.dice_four);
                            break;
                        case 4:
                            craps.setImageResource(R.drawable.dice_five);
                            break;
                        case 5:
                            craps.setImageResource(R.drawable.dice_six);
                            break;

                    }
                    return;
                }
                isStart = true;
                craps.setImageResource(R.drawable.craps_loading);
                Util.launchAnimation(craps);
                break;
        }
    }
}
