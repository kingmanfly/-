package com.kingman.bestchance;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

/**
 * Created by wb-lijinwei.a on 2016/5/13.
 */
public class Util {
    /*
    * after 6.0 need launch animation by manual
    * */
    public static void launchAnimation(ImageView imageView){
        if (null != imageView.getDrawable()
                && imageView.getDrawable() instanceof AnimationDrawable) {
            AnimationDrawable animation = (AnimationDrawable) imageView.getDrawable();
            animation.start();
        }
    }

    public static void stopAnimation(ImageView imageView){
        if (null != imageView.getDrawable()
                && imageView.getDrawable() instanceof AnimationDrawable) {
            AnimationDrawable animation = (AnimationDrawable) imageView.getDrawable();
            if(animation != null && animation.isRunning()){
                animation.stop();
            }
        }
    }

}
