package com.ssafy.enjoytrip.domain.image_util;

import com.ssafy.enjoytrip.domain.BoardImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 파일 저장을 위한 유틸 클래스
 */
@Component
public class FileStore {

    @Value("file.dir")
    private String fileDir;

    public String getFilePath(String fileName) {
        return fileDir + fileName;
    }

    public List<BoardImage> storeImages(List<MultipartFile> multipartFiles) throws IOException {

        List<BoardImage> imageResult = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFiles.isEmpty()) {
                imageResult.add(storeImage(multipartFile));
            }
        }

        return imageResult;
    }

    /**\
     * MultipartFile -> BoardImage로 변환하고 File 저장하는 메서드
     */
    public BoardImage storeImage(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFilePath(storeFileName)));
        
        return BoardImage.builder().userFileName(originalFilename).storedFileName(storeFileName).build();
    }

    /**
     * 저장할 때 줄 랜덤 이름 생성 메서드 (UUID 이용)
     */
    private String createStoreFileName(String fileName) {
        String name = extract(fileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + name;
    }

    /**
     * 확장자 추출 메서드
     */
    private String extract(String fileName) {
        int position = fileName.lastIndexOf(".");
        return fileName.substring(position + 1);
    }
}
