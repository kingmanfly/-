package com.kingman.bestchance.adapter;

import android.content.Context;

import com.kingman.bestchance.model.Selecter;

/**
 * Created by wb-lijinwei.a on 2015/12/17.
 */
public class SingleMemberSelectAdapter extends ASingleMemberSelectAdapter<Selecter> {

    public SingleMemberSelectAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemImage(int position) {
        return getDataList().get(position).getResDrawable();
    }

    @Override
    public String getItemTitle(int position) {
        return getDataList().get(position).getTitle();
    }
}
