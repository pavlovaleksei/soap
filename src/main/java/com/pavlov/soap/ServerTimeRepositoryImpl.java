package com.pavlov.soap;

import https.pavlovaleksei_github.ServerTime;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ServerTimeRepositoryImpl implements ServerTimeRepository {

    @Override
    public ServerTime getServerTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ServerTime time = new ServerTime();
        time.setTime(sdf.format(new Date(System.currentTimeMillis())));
        return time;
    }
}
