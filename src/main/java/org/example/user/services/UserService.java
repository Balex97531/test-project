package org.example.user.services;

import lombok.RequiredArgsConstructor;
import org.example.user.controllers.NewUser;
import org.example.user.persistence.UserEntity;
import org.example.user.persistence.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public void createUser(NewUser newUser) {
        UserModel userModel = userMapper.mapToModel(newUser);
        UserEntity userEntity = userMapper.mapToEntity(userModel);
        userEntity.setCreationDate(OffsetDateTime.now());
        userRepository.save(userEntity);
    }

    public boolean isUserExists(Long userId) {
       return userRepository.findById(userId).isPresent();
    }


}
