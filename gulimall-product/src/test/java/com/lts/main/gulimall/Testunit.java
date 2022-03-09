package com.lts.main.gulimall;


import com.lts.main.gulimall.product.GulimallProductApplication;
import com.lts.main.gulimall.product.entity.BrandEntity;
import com.lts.main.gulimall.product.service.BrandService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest(classes = GulimallProductApplication.class)
class Testunit {

    @Autowired
    BrandService brandService;

//    测试minio的功能
    @Test
    public void testMinio() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("http://101.133.149.79:9000")
                            .credentials("minioadmin123", "minioadmin123")
                            .build();

            // Make 'asiatrip' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("gulimall-hello").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("gulimall-hello").build());
            } else {
                System.out.println("Bucket 'gulimall-hello' already exists.");
            }

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            // 'asiatrip'.
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("gulimall-hello")
                            .object("test.jpeg")
                            .filename("C:\\Users\\xiaomi\\Desktop\\test.jpeg")
                            .build());
            System.out.println(
                    "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
                            + "object 'test.jpeg' to bucket 'gulimall-hello'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }

//    测试通过
    @Test
    public void insert(){
        BrandEntity brand=new BrandEntity();

        brand.setDescript("abc");

        brandService.save(brand);

        System.out.println("保存成功");
    }
}
