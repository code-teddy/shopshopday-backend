package com.myProject.ShopShopDay.service.address;

import com.myProject.ShopShopDay.dtos.AddressDto;
import com.myProject.ShopShopDay.model.Address;
import com.myProject.ShopShopDay.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<Address> createAddress(List<Address> addressList) {
        return addressRepository.saveAll(addressList);
    }

    @Override
    public List<Address> getUserAddresses(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found!"));
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.findById(addressId).ifPresentOrElse(addressRepository::delete, () -> {
            throw new EntityNotFoundException("Address not found!");
        });
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        return addressRepository.findById(id).map(existingAddress -> {
            existingAddress.setCountry(address.getCountry());
            existingAddress.setState(address.getState());
            existingAddress.setCity(address.getCity());
            existingAddress.setStreet(address.getStreet());
            existingAddress.setAddressType(address.getAddressType());
            return addressRepository.save(existingAddress);
        }).orElseThrow(() -> new EntityNotFoundException("Address not found!"));
    }

    @Override
    public List<AddressDto> convertToDto(List<Address> addressList){
        return addressList.stream().map(this :: convertToDto).toList();

    }

    @Override
    public AddressDto convertToDto(Address address){
        return modelMapper.map(address, AddressDto.class);
    }
}
