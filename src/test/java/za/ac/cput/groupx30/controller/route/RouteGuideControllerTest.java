package za.ac.cput.groupx30.controller.route;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.RouteGuideFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RouteGuideControllerTest
{
    private static RouteGuide routeGuide = RouteGuideFactory.createRouteGuide("" , "");

    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/routeGuide";

    @Test
    void create()
    {
        String url = BASE_URL + "/create";
        ResponseEntity<RouteGuide> postResponse = restTemplate.postForEntity(url, routeGuide , RouteGuide.class);
    }

    @Test
    void read()
    {
        String url = BASE_URL + "/read";
        ResponseEntity<RouteGuide> postResponse = restTemplate.getForEntity(url, RouteGuide.class);
    }

    @Test
    void update()
    {
        RouteGuide updated = new RouteGuide.Builder().copy(routeGuide).setRouteId("515613").setGuideId("Foreshore").build();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updated, RouteGuide.class);
    }

    @Test
    void delete()
    {
        String url = BASE_URL + "/delete/";
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}