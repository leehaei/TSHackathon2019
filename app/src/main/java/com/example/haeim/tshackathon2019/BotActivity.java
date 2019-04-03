package com.example.haeim.tshackathon2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ai.api.AIServiceContext;
import ai.api.AIServiceContextBuilder;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.android.AIConfiguration;


public class BotActivity extends AppCompatActivity {

    private AIDataService aiDataService;
    private AIRequest aiRequest;
    private String uuid = UUID.randomUUID().toString();
    private AIServiceContext customAIServiceContext;
    private String sendResponse;

    private static final String TAG = "BotActivity";

    private static final int USER = 0;
    private static final int BOT = 1;

    private LinearLayout chatLayout;
    private EditText queryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        chatLayout = findViewById(R.id.chatLayout);
        final Button sendButton = (Button) findViewById(R.id.button);
        //final TextView request = (TextView) findViewById(R.id.queryEditText);

        //ImageView sendBtn = findViewById(R.id.sendBtn);

        queryEditText = findViewById(R.id.queryEditText);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendResponse = queryEditText.getText().toString();
                init();
            }
        });
    }

    private void init() {
        //Instance of AIConfiguration, specifying the access token, locale, and recognition engine.
        final AIConfiguration config = new AIConfiguration("f8ad05838e684915993f0f281ae0be85",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        //Use the AIConfiguration object to get a reference to the AIService, which will make the query requests.
        aiDataService = new AIDataService(this, config);
        customAIServiceContext = AIServiceContextBuilder.buildFromSessionId(uuid);
        aiRequest = new AIRequest();
        sendRequest();
    }

    private void sendRequest () {
        aiRequest.setQuery(sendResponse);
        Request request = new Request(BotActivity.this, aiDataService, customAIServiceContext);
        request.execute(aiRequest);
        sendMessage(sendResponse, USER);
        queryEditText.setText("");
    }

    public void getResponse(AIResponse aiResponse) {
        String response = aiResponse.getResult().getFulfillment().getSpeech();
        Toast.makeText(BotActivity.this, "Response: " + response, Toast.LENGTH_LONG).show();
        sendMessage(response, BOT);
    }

    private void sendMessage(String message, int type) {
        FrameLayout layout;
        switch(type) {
            case USER:
                layout = userLayout();
                break;
            case BOT:
                layout = botLayout();
                break;
            default:
                layout = botLayout();
                break;
        }
        layout.setFocusableInTouchMode(true);
        chatLayout.addView(layout);
        TextView tView = layout.findViewById(R.id.chatMsg);
        tView.setText(message);
        layout.requestFocus();
        queryEditText.requestFocus();
    }

    FrameLayout userLayout() {
        LayoutInflater inflater = LayoutInflater.from(BotActivity.this);
        return (FrameLayout) inflater.inflate(R.layout.usersent, null);
    }

    FrameLayout botLayout() {
        LayoutInflater inflater = LayoutInflater.from(BotActivity.this);
        return (FrameLayout) inflater.inflate(R.layout.botreceived, null);
    }

}


