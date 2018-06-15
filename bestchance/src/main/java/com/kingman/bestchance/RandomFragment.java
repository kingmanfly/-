package com.kingman.bestchance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wb-lijinwei.a on 2016/5/12.
 */
public class RandomFragment extends Fragment implements View.OnClickListener{
    boolean isStart = false;
    TextView textViewRandom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_random, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewRandom = (TextView) view.findViewById(R.id.textview_random);
        textViewRandom.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isStart = false;
        textViewRandom = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textview_random:
                if(isStart){
                    isStart = false;
                    return;
                }
                isStart = true;
                new MyThread().start();
                break;
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            int  i = 0;
            while(isStart){
                Log.v("xxxxx", "MyThread" + i++);
                ThreadTool.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewRandom.setText("" + RandomGenerator.generator(100));
                    }
                });
                try {
                    Thread.sleep(50l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
