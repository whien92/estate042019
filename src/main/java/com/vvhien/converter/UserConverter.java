package com.vvhien.converter;

import org.modelmapper.ModelMapper;

import com.vvhien.dto.BuildingDTO;
import com.vvhien.dto.UserDTO;
import com.vvhien.entity.UserEntity;

public class UserConverter {
	public UserDTO convertToDTO(UserEntity userEntity) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO result = modelMapper.map(userEntity, BuildingDTO.class);
		return result;
	}
	
	public UserEntity converToEntity(UserDTO userDTO) {
		ModelMapper modelMapper = new ModelMapper();
		UserEntity result = modelMapper.map(userDTO, UserEntity.class);
		return result;
	}
}
