package com.myProject.ShopShopDay.controller;

import com.myProject.ShopShopDay.dtos.AddressDto;
import com.myProject.ShopShopDay.model.Address;
import com.myProject.ShopShopDay.response.ApiResponse;
import com.myProject.ShopShopDay.service.address.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/addresses")
public class AddressController {

    private final IAddressService addressService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse> createAddresses(@RequestBody List<Address> addresses) {
        List<Address> addressList = addressService.createAddress(addresses);
        List<AddressDto> addressDto = addressService.convertToDto(addressList);
        return ResponseEntity.ok(new ApiResponse("Success!", addressDto));
    }

    @GetMapping("/{userId}/address")
    public ResponseEntity<ApiResponse> getUserAddresses(@PathVariable Long userId) {
        List<Address> addressList = addressService.getUserAddresses(userId);
        List<AddressDto> addressDto = addressService.convertToDto(addressList);
        return ResponseEntity.ok(new ApiResponse("Found!", addressDto));
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<ApiResponse> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        AddressDto addressDto = addressService.convertToDto(address);
        return ResponseEntity.ok(new ApiResponse("Found!", addressDto));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ApiResponse> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        AddressDto addressDto = addressService.convertToDto(updatedAddress);
        return ResponseEntity.ok(new ApiResponse("Success!", addressDto));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ApiResponse> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok(new ApiResponse("Address deleted", null));
    }
}



  /* "addressList" : [
    {
        "country": "USA",
        "state": "California",
        "city": "Los Angeles",
        "street": "123 Main St",
        "addressType": "HOME"
    },
    {
        "country": "USA",
        "state": "California",
        "city": "San Francisco",
        "street": "456 Market St",
        "addressType": "OFFICE"
    }
]


*/
