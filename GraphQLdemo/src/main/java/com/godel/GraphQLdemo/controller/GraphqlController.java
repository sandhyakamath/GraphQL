package com.godel.GraphQLdemo.controller;

import com.godel.GraphQLdemo.DTO.BillDTO;
import com.godel.GraphQLdemo.DTO.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GraphqlController {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public GraphqlController() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @QueryMapping
    public PersonDTO getPerson(@Argument Long id) throws Exception {
        // Fetch person
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/people/" + id))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        PersonDTO person = objectMapper.readValue(response.body(), PersonDTO.class);

        // Fetch bills
        HttpRequest billsRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8081/bills?personId=" + id))
                .GET()
                .build();
        HttpResponse<String> billsResponse = httpClient.send(billsRequest, HttpResponse.BodyHandlers.ofString());
        List<BillDTO> bills = objectMapper.readValue(billsResponse.body(), List.class);

        person.setBills(bills);
        return person;
    }


    @QueryMapping
    public List<BillDTO> getBillsByPerson(Long personId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8081/bills?personId=" + personId))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), List.class);
    }

    @SchemaMapping(typeName = "PersonDTO", field = "bills")
    public List<BillDTO> getBills(PersonDTO person) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8081/bills?personId=" + person.getId()))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), List.class);
    }
}
