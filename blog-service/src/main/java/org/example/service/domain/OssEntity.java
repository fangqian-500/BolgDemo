package org.example.service.domain;

//@Data
public class OssEntity {
    private static final String ENDPOINT = "oss-cn-hangzhou.aliyuncs.com";

    private static final String ACCESS_KEYID = "your access_keyId";

    private static final String ACCESS_SECRET = "your access_secret";

    private static final String BUCKEY_NAME = "your bucket_name";

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
