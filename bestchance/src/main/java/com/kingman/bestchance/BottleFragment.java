package com.kingman.bestchance;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * Created by wb-lijinwei.a on 2016/5/12.
 */
public class BottleFragment extends Fragment implements View.OnClickListener{
    ImageView bottle;
    boolean isStart = false;
    ObjectAnimator animator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_bottle, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottle = (ImageView) view.findViewById(R.id.imageview_bottle);
        bottle.setOnClickListener(this);
        animator = ObjectAnimator.ofFloat(bottle, "rotation", 0f, 360f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //System.out.println("ppp values = " +  (Integer) animation.getAnimatedValue());
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(200);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageview_bottle:
                if(isStart){
                    isStart = false;
                    animator.pause();
                    return;
                }
                isStart = true;
                animator.start();
                break;
        }
    }
}
