package com.kingman.bestchance;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by wb-lijinwei.a on 2016/5/12.
 */
public class CoinFragment extends Fragment implements View.OnClickListener{
    ImageView coin;
    Drawable loading;
    boolean isStart = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loading = this.getActivity().getApplication().getResources().getDrawable(R.drawable.coin_loading);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_coin, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coin = (ImageView) view.findViewById(R.id.coin);
        coin.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Util.stopAnimation(coin);
        coin = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loading.setCallback(null);
        loading = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coin:
                if(isStart){
                    isStart = false;
                    if(RandomGenerator.generator(1000) % 2 == 0){
                        coin.setImageResource(R.drawable.coin_one);
                    }else {
                        coin.setImageResource(R.drawable.coin_four);
                    }
                    return;
                }
                isStart = true;
                coin.setImageDrawable(loading);
                Util.launchAnimation(coin);
                break;

        }
    }
}
