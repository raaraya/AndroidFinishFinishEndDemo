package com.example.businessapp.ui.screens.usuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.businessapp.R;
import com.example.businessapp.api.models.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UsersRecyclerViewAdapter extends Adapter<UsersRecyclerViewAdapter.UserViewHolder> {
    private MutableLiveData<ArrayList<User>> usersList;

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.user_name_list_item_text);
        }
    }

    public UsersRecyclerViewAdapter(MutableLiveData<ArrayList<User>> users) {
        this.usersList = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_user_list_item, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textView.setText(usersList.getValue().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return usersList.getValue().size();
    }


}
