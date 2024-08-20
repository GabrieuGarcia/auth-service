package com.mammutive.authservice.mapper;

import com.mammutive.authservice.dto.AuthenticationRequestDto;
import com.mammutive.authservice.model.AuthenticationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AuthenticationRequesMapper {

    AuthenticationRequest dtoToModel(AuthenticationRequestDto requestDto);

}
