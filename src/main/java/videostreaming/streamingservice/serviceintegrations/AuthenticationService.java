package videostreaming.streamingservice.serviceintegrations;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class AuthenticationService {
    private final String serviceUrl = "http://host.docker.internal:9081/api/auth";

    private final RestTemplate restTemplate;

    @Autowired
    public AuthenticationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isUserAuthenticated(HttpServletRequest request) {
        String token = extractToken( request );
        if( token != null ){

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", request.getHeader(AUTHORIZATION));
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<Boolean> response = restTemplate.exchange(serviceUrl + "/verify", HttpMethod.GET, requestEntity, Boolean.class);

            return response.getBody() != null && response.getBody();
        }

        return false;
    }

    public String getUsernameFromToken(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", request.getHeader(AUTHORIZATION));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(serviceUrl + "/get-username-from-token", HttpMethod.GET, requestEntity, String.class);

        return response.getBody();
    }

    private String extractToken(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }


}
