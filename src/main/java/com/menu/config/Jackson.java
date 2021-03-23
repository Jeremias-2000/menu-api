package com.menu.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.menu.enums.FoodType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Jackson {


    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();

        //propriedades nao mapeadas
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        //falha de alguma propriedade estiver vazia
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

        //serve para compatibilidade de arrays
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //Serialize datas
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(foodTypeModuleMapper());
        return objectMapper;
    }

    public SimpleModule foodTypeModuleMapper(){
        SimpleModule dateModule = new SimpleModule("JsonFoodTypeModule", PackageVersion.VERSION);
        dateModule.addSerializer(FoodType.class,new FoodTypeCerialize());
        dateModule.addDeserializer(FoodType.class,new FoodTypeDeserialize());
        return dateModule;
    }
    class FoodTypeCerialize extends StdSerializer<FoodType>{

        public FoodTypeCerialize(){
            super(FoodType.class);
        }

        @Override
        public void serialize(FoodType foodType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(foodType.getDescription());
        }
    }
    class FoodTypeDeserialize extends StdDeserializer<FoodType>{


        protected FoodTypeDeserialize() {
            super(FoodType.class);
        }

        @Override
        public FoodType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return FoodType.of(jsonParser.getText());
        }
    }
}
