package com.myProject.ShopShopDay.service.image;

import com.myProject.ShopShopDay.dtos.ImageDto;
import com.myProject.ShopShopDay.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {
    Image getImageById(Long imageId);
    void deleteImageById(Long imageId);
    void updateImage(MultipartFile file, Long imageId) throws IOException;
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);

}