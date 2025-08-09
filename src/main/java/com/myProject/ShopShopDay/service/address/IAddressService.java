package com.myProject.ShopShopDay.service.address;

import com.myProject.ShopShopDay.dtos.AddressDto;
import com.myProject.ShopShopDay.model.Address;

import java.util.List;

public interface IAddressService {
    List<Address>  createAddress(List<Address> addressList);
    List<Address> getUserAddresses(Long userId);
    Address getAddressById(Long addressId);
    void deleteAddress(Long addressId);
    Address updateAddress(Long id, Address address);

    List<AddressDto> convertToDto(List<Address> addressList);

    AddressDto convertToDto(Address address);
}
