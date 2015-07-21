package com.ljaymori.androidstickyheader;

import android.view.View;
import android.widget.ImageView;

public class ItemPictureView extends ItemParentView {

    private ImageView ivPicture;

    public ItemPictureView(View itemView) {
        super(itemView);

        ivPicture = (ImageView) itemView.findViewById(R.id.image_picture_item);
    }

    public void setItemPictureView(ItemData id) {

    }
}
