package com.example.SuperHero.controllers;

import com.example.SuperHero.Services.SuperheroServices;
import com.example.SuperHero.configs.SqsConfig;
import com.example.SuperHero.dto.SuperHero;
import com.example.SuperHero.dto.SuperheroRequestbody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.List;


@RestController
public class SuperHeroController {
    private SuperheroServices superheroservice;

    @Autowired
    private SqsConfig sqsConfig;

    @Autowired
    public SuperHeroController (SuperheroServices superheroservice){
        this.superheroservice=superheroservice;
    }

    @GetMapping("/superhero")
    public List<SuperHero> getSuperhero(@RequestParam(value="name",required=false) String name,
                                        @RequestParam(value="Universe",required = false) String Universe,
                                        @RequestParam(value="universe",required=false) String universe
    ){
        return superheroservice.getSuperhero(name,Universe,universe);
    }

    @Autowired
    private SqsClient sqsClient;


    @GetMapping("/hello")
    public String hello(){
//        sqsClient.sendMessage(SendMessageRequest.builder()
//                .queueUrl(sqsConfig.getQueueUrl())
//                .messageBody("Akash Singh")
//                .build());
        ReceiveMessageResponse res = sqsClient.receiveMessage(ReceiveMessageRequest.builder()
                .queueUrl(sqsConfig.getQueueUrl())
                .build());
        return sqsConfig.getQueueName() + res.messages().get(0).body();
    }

    @PostMapping("/superhero")
    public SuperHero persistSuperhero(@RequestBody SuperheroRequestbody superherorequestbody){
        return superheroservice.persistSuperhero(superherorequestbody);
    }

    @DeleteMapping("/superhero/{name}")
    public void deleteSuperHero(@PathVariable (value="name") String name){
        superheroservice.deleteSuperhero(name);
    }

    @PutMapping("/superhero/{name}")
    public SuperHero updateSuperHero(@PathVariable (value="name") String name,
                                     @RequestBody SuperheroRequestbody superherorequestbody
                                     ){
        return superheroservice.UpdateSuperhero(name,superherorequestbody);
    }
}
