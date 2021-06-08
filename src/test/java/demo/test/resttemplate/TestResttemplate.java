package demo.test.resttemplate;

import demo.request.DistributionStatisticsQueryRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestResttemplate {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * post请求，json
     */
    @Test
    public void postJSON(){
        String url ="https://supplierbff.maohaoduo.com/distributionstatistics/page";
        DistributionStatisticsQueryRequest distributionStatisticsQueryRequest = new DistributionStatisticsQueryRequest();
        distributionStatisticsQueryRequest.setDistributionNo(200246L);
        //请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNp8jc0KgzAQhN9lzyLZmJjovQehFOnPA6S6AcGYYD1USt-922J77G2Y-WbmAV0MyU1rM_nY9FBbabOvd14TQS0yGBLUgChzqXNZmFxbyMD1YZh-lTmOdHCBeeCMQhrjSvSOQXaV916QqXp1pY4EstIkBXoUQijmb0ucPzDKQmlTWsUbd37FUhalstqYDHbb6HaDFoVGWxWm4oU0usXHOXBwurTtvtkd2Z3JjX9qzxcAAAD__w.NaHzTyiKbxFteCvEchHj_9gBVPo6YHD5LNzMgxw1Ydg");
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(distributionStatisticsQueryRequest, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        System.out.println(responseEntity);
    }

    /**
     * post请求，x-www-form-urlencoded
     */
    @Test
    public void post(){
        String url ="https://bizapi.jd.com/api/product/getSkuByPage";
        //参数
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("token", "j4QFVJM3OyuqJ5nu1ALYQjlU2");
        param.add("pageNum", "20210416");
        param.add("pageNo", "1");
        //请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(param,httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        System.out.println(responseEntity);
    }

    @Test
    public void get(){
        String url ="https://bizapi.jd.com/api/product/getPageNum";
        //参数
        HashMap<String, String> map = new HashMap<>();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class,map);

        System.out.println(responseEntity);
    }

}
