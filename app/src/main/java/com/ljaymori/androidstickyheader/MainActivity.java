package com.ljaymori.androidstickyheader;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public static final int ITEM_TYPE_PICTURE = 0;
    public static final int ITEM_TYPE_TAB = 1;
    public static final int ITEM_TYPE_INTRO = 2;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private ItemAdapter mAdapter;

    private View viewTab;
    private TextView tvTab1;
    private TextView tvTab2;
    private TextView tvTab3;

    private float introHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introHeight = getResources().getDimension(R.dimen.item_intro_height);

        viewTab = findViewById(R.id.tab_main);
        tvTab1 = (TextView) viewTab.findViewById(R.id.text_tab1);
        tvTab2 = (TextView) viewTab.findViewById(R.id.text_tab2);
        tvTab3 = (TextView) viewTab.findViewById(R.id.text_tab3);

        viewTab.setVisibility(View.GONE);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

//                Log.i("dy", recyclerView.computeVerticalScrollOffset() + "");
                View view = gridLayoutManager.getChildAt(0);
//                Log.i("height", "" + view.getHeight());
                if(view.getHeight() == introHeight) {
                    viewTab.setVisibility(View.GONE);
                } else {
                    viewTab.setVisibility(View.VISIBLE);
                }



            }
        });


        gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new ItemAdapter(this);
        mAdapter.addAll(initData());

        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<ItemData> initData() {
        ArrayList<ItemData> list = new ArrayList<ItemData>();

        ItemData introData = new ItemData();
        introData.setType(ITEM_TYPE_INTRO);
        list.add(introData);

        ItemData tabData = new ItemData();
        tabData.setType(ITEM_TYPE_TAB);
        list.add(tabData);


        for (int i = 0; i < 30; i++) {
            ItemData id = new ItemData();
            id.setType(ITEM_TYPE_PICTURE);

            list.add(id);
        }

        return list;
    }

}
