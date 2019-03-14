package com.example.haeim.tshackathon2019;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.github.bassaer.chatmessageview.model.ChatUser;
import com.github.bassaer.chatmessageview.model.Message;
import com.github.kittinunf.fuel.Fuel;
//import com.github.kittinunf.fuel.android.extension.responseJson;
import com.github.kittinunf.fuel.core.FuelManager;

import ai.api.AIDataService;
import ai.api.AIServiceContextBuilder;
import ai.api.android.AIConfiguration;
import ai.api.model.AIRequest;

import ai.api.AIServiceContext;
import ai.api.AIServiceContextBuilder;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

import java.util.UUID;


public class BotActivity extends AppCompatActivity {

    //String ACCESS_TOKEN = "f8ad05838e684915993f0f281ae0be85";

    // Android client
    private AIRequest aiRequest;
    private AIDataService aiDataService;
    private AIServiceContext customAIServiceContext;
    private String uuid = UUID.randomUUID().toString();

    // Java V2
//    private SessionsClient sessionsClient;
//    private SessionName session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FuelManager.instance.baseHeaders = mapOf(
//                "Authorization" to "Bearer $ACCESS_TOKEN"
//        )


    }

    private void initChatbot() {
        final AIConfiguration config = new AIConfiguration("f8ad05838e684915993f0f281ae0be85",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiDataService = new AIDataService(this, config);
        customAIServiceContext = AIServiceContextBuilder.buildFromSessionId(uuid);
        aiRequest = new AIRequest();
    }




}