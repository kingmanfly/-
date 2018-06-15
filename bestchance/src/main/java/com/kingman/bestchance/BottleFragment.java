package com.kingman.bestchance;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * Created by wb-lijinwei.a on 2016/5/12.
 */
public class BottleFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "BottleFragment";
    ImageView bottle;
    boolean isStart = false;
    ObjectAnimator animator = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_bottle, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v(TAG, "onViewCreated");
        bottle = (ImageView) view.findViewById(R.id.imageview_bottle);
        bottle.setOnClickListener(this);
        animator = ObjectAnimator.ofFloat(bottle, "rotation", 0f, 360f);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(200);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(TAG, "onDestroyView");
        if(animator != null){
            if(animator.isStarted() || animator.isRunning()){
                animator.end();
            }
            animator.cancel();
            animator = null;
        }
        bottle = null;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageview_bottle:
                if(isStart){
                    isStart = false;
                    animator.pause();
                }else {
                    isStart = true;
                    animator.start();
                }
                break;
        }
    }
}
