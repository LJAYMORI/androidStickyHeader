package com.ljaymori.androidstickyheader;

import android.view.View;
import android.widget.ImageView;

public class ItemIntroView extends ItemParentView {

    private ImageView ivIntro;

    public ItemIntroView(View itemView) {
        super(itemView);

        ivIntro = (ImageView) itemView.findViewById(R.id.image_intro);
    }

    public void setItemIntroView(ItemData id) {

    }
}
