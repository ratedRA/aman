package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    @Autowired
    private static Person person;
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.removeIf(
                httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
        converters.add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        converters.add(new MappingJackson2HttpMessageConverter());

        PhpMailerPayloadClass phpMailerPayloadClass = new PhpMailerPayloadClass();
        phpMailerPayloadClass.setEmail("roxxxaman286@gmail.com");
        phpMailerPayloadClass.setFirstName("verify");
        phpMailerPayloadClass.setPassword("ne124323eedw");

        HttpEntity<PhpMailerPayloadClass> request =
                new HttpEntity<PhpMailerPayloadClass>(phpMailerPayloadClass);

        try {
            ResponseEntity<ResponseClass> response
                    = restTemplate.getForEntity("http://localhost:8080/cb-be-service/welcome", ResponseClass.class);
            System.out.println(response);
//            URI uri = new URI("https://codersbid.herokuapp.com/1/biders/register");
//
//            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(uri, request, String.class);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
