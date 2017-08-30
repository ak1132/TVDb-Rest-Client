package com.tvdbRestClient.models.response;

import java.util.List;

import com.tvdbRestClient.models.request.Actor;

public class ActorResponse extends ErrorResponse {

    public List<Actor> data;
}