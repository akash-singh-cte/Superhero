package com.example.SuperHero.services;

import com.example.SuperHero.Services.SuperheroServices;
import com.example.SuperHero.dto.SuperheroRequestbody;
import com.example.SuperHero.repository.SuperheroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SuperheroServices2Tests {

    @Mock
    private SuperheroRepository superheroRepository;

    @InjectMocks
    private SuperheroServices superheroServices;

//    @Test
//    void testPersistSuperhero_whenUniverseIsDc(){
//        SuperheroRequestbody requestBody =getSuperheroRequestbody("batman");
//
//        doReturn(getSuperhero()).when(superheroRepository).save(any());
//    }

}
