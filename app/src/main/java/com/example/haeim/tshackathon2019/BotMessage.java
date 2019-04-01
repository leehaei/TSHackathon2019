package com.example.haeim.tshackathon2019;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.Utils;

public class BotMessage extends RecyclerView.ViewHolder {

    TextView message, time, name;
    ImageView botImage;

    BotMessage(View view) {
        super(view);
        message = (TextView) itemView.findViewById(R.id.text_message_body);
        name = (TextView) itemView.findViewById(R.id.text_message_name);
        botImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
    }

    void bind(UserMessage message) {
        message.setText(message.getMessage());
        //Utils.displayRoundImageFromUrl;
    }
}
