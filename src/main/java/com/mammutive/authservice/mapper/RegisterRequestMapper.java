package com.mammutive.authservice.mapper;

import com.mammutive.authservice.dto.RegisterRequestDto;
import com.mammutive.authservice.model.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface RegisterRequestMapper {

    RegisterRequest dtoToModel(RegisterRequestDto requestDto);
}
