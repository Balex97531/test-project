package org.example.user.services;

import org.example.user.controllers.NewUser;
import org.example.user.persistence.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

   static UserModel mapToModel(NewUser newUser) {
        return UserModel.builder()
                .name(newUser.getName())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .build();

    }

   static UserEntity mapToEntity(UserModel userModel) {
        return UserEntity.builder()
                .name(userModel.getName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .build();

    }


}
