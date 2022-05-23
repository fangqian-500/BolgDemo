package org.example.service.domain;

//@Data
public class OssEntity {
    private static final String ENDPOINT = "oss-cn-hangzhou.aliyuncs.com";

    private static final String ACCESS_KEYID = "LTAI4G7qJNTvA6uZqm2Vfn1E";

    private static final String ACCESS_SECRET = "pZE76IOwN7Gznm2TtmjXwCXJ6qqPi8";

    private static final String BUCKEY_NAME = "blog7.oss-cn-hangzhou.aliyuncs.com";

    public String getEndpoint(){
        return OssEntity.ENDPOINT;
    }

    public String getAccessKeyid(){
        return OssEntity.ACCESS_KEYID;
    }

    public String getAccessSecret(){
        return OssEntity.ACCESS_SECRET;
    }

    public String getBuckeyName(){
        return OssEntity.BUCKEY_NAME;
    }
}
