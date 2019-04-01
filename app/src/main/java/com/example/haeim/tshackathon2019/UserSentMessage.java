package com.example.haeim.tshackathon2019;

import android.view.View;
import android.widget.TextView;

public class UserSentMessage {

    TextView messageSent;

    UserSentMessage(View view) {
        super(view);
        messageSent = (TextView) itemView.findViewById(R.id.text_message_body);
    }

    void bind(UserMessage message) {
        messageSent.setText(message.getMessage());
    }
}