package com.vvhien.repository;

import com.vvhien.entity.UserEntity;

public interface IUserRepository {
	Long insert(UserEntity entity);
}
