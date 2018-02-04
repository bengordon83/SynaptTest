package com.synapt.synapttest.RecyclerViewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.synapt.synapttest.R;
import com.synapt.synapttest.User.User;

import java.util.List;

/**
 * Created by Evan on 1/20/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> UserList;

    public UserAdapter(List<User> UserList){
        this.UserList = UserList;
    }

    @Override
    public int getItemCount(){
        return UserList.size();
    }

    @Override
    public void onBindViewHolder(UserViewHolder UserViewHolder, int i){
        String userName = UserList.get(i).getUserName();
        User user = UserList.get(i);
        //holder.bind(userName);
        UserViewHolder.cTitle.setText(user.getUserName());
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_small, viewGroup, false);
        return new UserViewHolder(itemView);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        protected TextView cTitle;
        //RecyclerItemBinding binding;

        public UserViewHolder(View v) {
            super(v);
            cTitle = (TextView) v.findViewById(R.id.title_cardView_small);
        }
    }
}



