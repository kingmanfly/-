package com.kingman.bestchance;

import android.graphics.drawable.AnimationDrawable;
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
    boolean isStart = false;

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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coin:
                if(isStart){
                    isStart = false;
                    if(RandomGenerator.generator(1000) % 2 == 0){
                        coin.setImageResource(R.drawable.coin_positive);
                    }else {
                        coin.setImageResource(R.drawable.coin_negative);
                    }
                    return;
                }
                isStart = true;
                coin.setImageDrawable(getResources().getDrawable(R.drawable.coin_loading));
                Util.launchAnimation(coin);
                break;

        }
    }
}
