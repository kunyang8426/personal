package com.kazma.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class CommonUtil {

    public static String prePic="59.110.226.16/image/";
    public static String path="/usr/image/";


    public static String uploadImg(String name,  MultipartFile pic) throws Exception {
        if (!pic.isEmpty()) {
            String originalFileName = pic.getOriginalFilename();
            // 新的图片名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            // 新的图片
            File newFile = new File(path + newFileName);
            // 将内存中的数据写入磁盘
            pic.transferTo(newFile);

            return prePic + newFileName;
        } else {
            throw new Exception();
        }
    }
}
