package com.lts.main.gulimall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    public RestHighLevelClient getrestHighLevelClient(){
        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1",9200,"http")
                )
        );

        return restHighLevelClient;
    }
}
