package com.myProject.ShopShopDay.service.user;

import com.myProject.ShopShopDay.dtos.UserDto;
import com.myProject.ShopShopDay.model.User;
import com.myProject.ShopShopDay.request.CreateUserRequest;
import com.myProject.ShopShopDay.request.UserUpdateRequest;

public interface IUserService {
    User createUser(CreateUserRequest request);

    User updateUser(UserUpdateRequest request, Long userId);

    User getUserById(Long userId);

    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
