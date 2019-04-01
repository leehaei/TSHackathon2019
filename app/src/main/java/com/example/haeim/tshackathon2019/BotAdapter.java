package com.example.haeim.tshackathon2019;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BotAdapter extends RecyclerView.Adapter {

    private Context mycontext;
    private List<BaseMessage> mylistMessage;

    BotAdapter(Context context, List<BaseMessage> listMessage) {
        mycontext = context;
        mylistMessage = listMessage;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == 1) {

        }
    }
}
