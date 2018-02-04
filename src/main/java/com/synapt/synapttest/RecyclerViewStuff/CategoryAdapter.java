package com.synapt.synapttest.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.synapt.synapttest.R;
import com.synapt.synapttest.cardStructures.Category;

import java.util.List;

/**
 * Created by Evan on 1/20/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    @Override
    public int getItemCount(){
        return categoryList.size();
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i){
        Category category = categoryList.get(i);
        categoryViewHolder.cTitle.setText(category.name);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_small, viewGroup, false);
        return new CategoryViewHolder(itemView);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        protected TextView cTitle;

        public CategoryViewHolder(View v) {
            super(v);
            cTitle = (TextView) v.findViewById(R.id.title_cardView_small);
        }
    }
}
