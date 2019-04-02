package com.example.haeim.tshackathon2019;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.Utils;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.SendBird;
import com.sendbird.android.UserMessage;

import java.util.List;

public class BotAdapter extends RecyclerView.Adapter {

    private Context mycontext;
    private List<BaseMessage> myListMessage;

    BotAdapter(Context context, List<BaseMessage> listMessage) {
        mycontext = context;
        myListMessage = listMessage;
    }

    @Override
    public int getItemCount() {
        return myListMessage.size();
    }

    // Determines the appropriate ViewType according to the sender of the message.
    @Override
    public int getItemViewType(int position) {
        UserMessage message = (UserMessage) myListMessage.get(position);

        if (message.getSender().getUserId().equals(SendBird.getCurrentUser().getUserId())) {
            // If the current user is the sender of the message
            return 1;
        } else {
            // If some other user sent the message
            return 2;
        }
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.botreceived, parent, false);
            return new UserSentMessage(view);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.usersent, parent, false);
            return new BotMessage(view);
        }

        return null;
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserMessage message = (UserMessage) myListMessage.get(position);

        switch (holder.getItemViewType()) {
            case 1:
                ((UserSentMessage) holder).bind(message);
                break;
            case 2:
                ((BotMessage) holder).bind(message);
        }
    }

    private class UserSentMessage extends RecyclerView.ViewHolder {

        TextView messageSent;

        UserSentMessage(View view) {
            super(view);
            messageSent = (TextView) view.findViewById(R.id.text_message_body);
        }

        void bind(UserMessage message) {

            messageSent.setText(message.getMessage());
        }
    }

    public class BotMessage extends RecyclerView.ViewHolder {

        TextView mymessage, myname;
        ImageView botImage;

        BotMessage(View view) {
            super(view);
            mymessage = (TextView) view.findViewById(R.id.text_message_body);
            //myname = (TextView) view.findViewById(R.id.text_message_name);
            //botImage = (ImageView) view.findViewById(R.id.image_message_profile);
        }

        void bind(UserMessage message) {
            mymessage.setText(message.getMessage());
            //Utils.displayRoundImageFromUrl(mContext, message.getSender().getProfileUrl(), profileImage);
        }
    }
}
