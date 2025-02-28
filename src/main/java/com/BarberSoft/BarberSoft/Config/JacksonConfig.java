package com.BarberSoft.BarberSoft.Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
	
	    @Bean
	    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
	        return builder
	                .modules(new JavaTimeModule())  // Habilita suporte para LocalDateTime
	                .build();
	    }
	   
	   @Bean
	   public Jackson2ObjectMapperBuilder jacksonBuilder() {
	       return new Jackson2ObjectMapperBuilder()
	               .modules(new JavaTimeModule())
	               .simpleDateFormat("dd/MM/yyyy HH:mm:ss")
	               .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
	               .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	   }

}
