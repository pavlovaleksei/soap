package com.pavlov.soap;

import https.pavlovaleksei_github.GetServerTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ServerTimeEndpoint {

    private static final String NAMESPACE_URI = "https://pavlovaleksei.github.io";

    private ServerTimeRepositoryImpl serverTimeRepositoryImpl;

    @Autowired
    public ServerTimeEndpoint(ServerTimeRepositoryImpl serverTimeRepositoryImpl) {
        this.serverTimeRepositoryImpl = serverTimeRepositoryImpl;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServerTimeRequest")
    @ResponsePayload
    public GetServerTimeResponse getServerTime() {
        GetServerTimeResponse response = new GetServerTimeResponse();
        response.setServerTime(serverTimeRepositoryImpl.getServerTime());
        return response;
    }
}


