package com.designevolution.finalproject.connectToInsta.domain;

import java.lang.reflect.Type;

import com.designevolution.finalproject.connectToInsta.domain.api.InstagramResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class InstagramJSONParser {

    public InstagramResponse parseResponse(String stringJson) {
    	InstagramResponse instagramJson = new InstagramResponse();
        if (stringJson != null) {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(
                            FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            Type collectionType = new TypeToken<InstagramResponse>() {
            }.getType();
            instagramJson = gson.fromJson(stringJson, collectionType);
        }
        return instagramJson;
    }
}
