package com.example.haeim.tshackathon2019;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.bassaer.chatmessageview.view.ChatView;

import ai.api.android.AIService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.AIError;
import ai.api.android.AIConfiguration;


public class BotActivity extends AppCompatActivity {

    private ChatView chatview;

    public interface AIListener {
        void onResult(AIResponse result); // here process response
        void onError(AIError error); // here process error
        void onAudioLevel(float level); // callback for sound level visualization
        void onListeningStarted(); // indicate start listening here
        void onListeningCanceled(); // indicate stop listening here
        void onListeningFinished(); // indicate stop listening here
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        chatview = (ChatView) findViewById(R.id.chat_view);

        chatview.setOnClickSendButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Instance of AIConfiguration, specifying the access token, locale, and recognition engine.
        final AIConfiguration config = new AIConfiguration("f8ad05838e684915993f0f281ae0be85",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        //Use the AIConfiguration object to get a reference to the AIService, which will make the query requests.
        AIService aiService = AIService.getService(this, config);

        AIRequest aiRequest = new AIRequest();

        aiService.setListener(this);

        //Set the AIListener instance for the AIService instance.
        aiService.startListening();

        String msg = "hi";
        aiRequest.setQuery(msg);

        //String botReply = aiResponse.getResult().getFulfillment().getSpeech();

    }

    public void onResult(AIResponse result) {

    }

}