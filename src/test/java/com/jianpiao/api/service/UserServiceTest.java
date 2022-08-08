package com.jianpiao.api.service;

import com.jianpiao.api.exception.WrongRegisterInfoException;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * @Author: BaBy
 * @Date: 2022/8/8 15:33
 */
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository mockUserRepository;

    @Test
    void should_return_WrongRegisterInfoException_when_register_not_have_enough_info_call_api_given_service() {
        // given
        User user = new User();

        // when
        given(mockUserRepository.save(any())).willReturn(user);

        // then
        assertThrows(WrongRegisterInfoException.class, () -> {
            userService.register(user);
        });
    }
}