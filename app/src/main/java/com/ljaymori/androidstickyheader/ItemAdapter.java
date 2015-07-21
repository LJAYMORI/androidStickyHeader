package com.ljaymori.androidstickyheader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemParentView> {

    private Context mContext;
    private ArrayList<ItemData> items = new ArrayList<ItemData>();

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(ArrayList<ItemData> list) {
        items.addAll(list);
    }

    @Override
    public ItemParentView onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == MainActivity.ITEM_TYPE_PICTURE) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_picture, viewGroup, false);
            return new ItemPictureView(v);

        } else if (viewType == MainActivity.ITEM_TYPE_INTRO) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_intro, viewGroup, false);
            return new ItemIntroView(v);

        } else if (viewType == MainActivity.ITEM_TYPE_TAB) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_tab, viewGroup, false);
            return new ItemTabView(v);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(ItemParentView itemParentView, int i) {
        ItemData data = items.get(i);
        int type = data.getType();

        if (type == MainActivity.ITEM_TYPE_PICTURE) {
            ((ItemPictureView) itemParentView).setItemPictureView(data);

        } else if (type == MainActivity.ITEM_TYPE_INTRO) {
            ((ItemIntroView) itemParentView).setItemIntroView(data);

        } else if (type == MainActivity.ITEM_TYPE_TAB) {
            ((ItemTabView) itemParentView).setItemTabView(data);

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

}
