package com.example.springbootdemo.mapstruct;

import com.example.springbootdemo.domain.CarDto;
import com.example.springbootdemo.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mappings({
            @Mapping(source = "makes", target = "manufacturer"),
            @Mapping(source = "numberOfSeats", target = "seatCount"),
            @Mapping(target = "name", ignore = true)
    })
    CarDto carToCarDto(Car car);

//    @Mapping(source = "name", target = "fullName")
//    PersonDto personToPersonDto(Person person);
}