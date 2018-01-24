/*
 * Created by omrobbie.
 * Copyright (c) 2018. All rights reserved.
 * Last modified 10/21/17 11:45 AM.
 */

package com.omrobbie.kamus.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.omrobbie.kamus.DetailActivity;
import com.omrobbie.kamus.R;
import com.omrobbie.kamus.data.model.KamusModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by omrobbie on 20/10/2017.
 */

class SearchViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_word)
    TextView tv_word;

    @BindView(R.id.tv_translate)
    TextView tv_translate;

    public SearchViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final KamusModel item) {
        tv_word.setText(item.getWord());
        tv_translate.setText(item.getTranslate());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.ITEM_WORD, item.getWord());
                intent.putExtra(DetailActivity.ITEM_TRANSLATE, item.getTranslate());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
