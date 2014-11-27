package com.erdalgunay.library.config;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
public class MongoConfig {

    @Bean
    public Mongo mongo() throws UnknownHostException {

        MongoURI mongoURI = new MongoURI("mongodb://erdal:123qwe@dogen.mongohq.com:10072/app31980562");
        Mongo mongo = mongoURI.connect();

        return mongo;
    }

    @Autowired
    public DB db(Mongo mongo) {

        DB db = mongo.getDB("app31980562");
        db.authenticate("erdal", "123qwe".toCharArray());

        return db;
    }



}
