package com.example.haeim.tshackathon2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
    private static final String TAG = "BotActivity";
    //TextView testing = (TextView) findViewById(R.id.test);

/*
    public interface AIListener {
        void onResult(AIResponse result); // here process response
        void onError(AIError error); // here process error
        void onAudioLevel(float level); // callback for sound level visualization
        void onListeningStarted(); // indicate start listening here
        void onListeningCanceled(); // indicate stop listening here
        void onListeningFinished(); // indicate stop listening here


    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        sendRequest();
        init();

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
    }

    private void sendRequest () {
        aiRequest.setQuery("hi");
        Request request = new Request(BotActivity.this, aiDataService, customAIServiceContext);
        request.execute(aiRequest);

    }

    public void getResponse(AIResponse aiResponse) {
        String response = aiResponse.getResult().getFulfillment().getSpeech();
        //testing.setText(response);
        Toast.makeText(BotActivity.this, "Response: " + response, Toast.LENGTH_LONG).show();
        Log.d(TAG, "Response: " + response);
    }


}


