package com.ljaymori.androidstickyheader;

import android.view.View;
import android.widget.TextView;

public class ItemTabView extends ItemParentView {

    private TextView tvTab1;
    private TextView tvTab2;
    private TextView tvTab3;

    public ItemTabView(View itemView) {
        super(itemView);

        tvTab1 = (TextView) itemView.findViewById(R.id.text_tab1);
        tvTab2 = (TextView) itemView.findViewById(R.id.text_tab2);
        tvTab3 = (TextView) itemView.findViewById(R.id.text_tab3);
    }

    public void setItemTabView(ItemData id) {

    }

}
