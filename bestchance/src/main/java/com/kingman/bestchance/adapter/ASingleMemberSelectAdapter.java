package com.kingman.bestchance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kingman.bestchance.R;

public abstract class ASingleMemberSelectAdapter<T> extends BaseSingleSelectStatusAdapter<T> {
    private static final int IS_NORMAL = 1;
    private static final int IS_HEADER = 2;
    private static final int IS_FOOTER = 3;

    public interface OnFooterClick{
        void onFooterClick(View view);
    }

    static OnFooterClick mOnFooterClick;

    public ASingleMemberSelectAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == IS_NORMAL){
            return new SingleSelectViewHolder(mLayoutInflater.inflate(R.layout.item_databelong_member_select, parent, false), this);
        }
        return new SingleSelectViewHolder(mLayoutInflater.inflate(R.layout.item_databelong_member_select, parent, false), this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SingleSelectViewHolder) {
            ((SingleSelectViewHolder) holder).bindViewData(
                    getItemImage(position),
                    getItemTitle(position),
                    position);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getDataList().size()){
            return IS_FOOTER;
        }else {
            return IS_NORMAL;
        }
    }

    public abstract int getItemImage(int position);
    public abstract String getItemTitle(int position);

    static class SingleSelectViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mFL_check;
        TextView mTvName;
        ImageView mIvCheck;
        ImageView mIvAvatar;
        ASingleMemberSelectAdapter mAdapter;

        SingleSelectViewHolder(View view, ASingleMemberSelectAdapter adapter) {
            super(view);
            mAdapter = adapter;
            mFL_check = (RelativeLayout) view.findViewById(R.id.rl_check);
            mTvName = (TextView) view.findViewById(R.id.tv_name);
            mIvCheck = (ImageView) view.findViewById(R.id.iv_check);
            mIvAvatar = (ImageView) view.findViewById(R.id.iv_avatar);
            mFL_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSelected();
                }
            });
        }

        public void bindViewData(int avatar, String name, int position) {
            mIvCheck.setVisibility((position == mAdapter.mCurrentSelect) ? View.VISIBLE : View.GONE);
            mTvName.setText(name);
            mIvAvatar.setImageResource(avatar);
        }

        void onSelected() {
            if (mAdapter.isEnableSelect) {
                mAdapter.setCurrentSelect(getPosition());
            }
        }
    }
}
