package demo.restservices.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class S3Service {

    private static S3Client s3;

    @Value("${aws.bucketname}")
    private String bucketName;

    public S3Service() {
        Region region = Region.AP_SOUTHEAST_1;
        s3 = S3Client.builder()
                .region(region)
                .build();
    }

    @Override
    public String toString() {
        return "S3Service{" +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }

    // https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html
    // https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/examples-s3-objects.html
    //  "*** File object key name ***";
    // Takes in multipart file -> InputStream -> File
    public String upload(String s3FileKey, MultipartFile file) throws IOException {
        InputStream inputStream =  new BufferedInputStream(file.getInputStream());

        s3.putObject(PutObjectRequest.builder().bucket(bucketName).key(s3FileKey).build(),
                RequestBody.fromFile(uploadToTemp(inputStream, s3FileKey)));

        StringBuilder sb = new StringBuilder();
        sb.append("https://").append(bucketName).append(".s3-ap-southeast-1.amazonaws.com/").append(s3FileKey);
        return sb.toString();
    }

    // https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/examples-s3-objects.html
    public GetObjectResponse download(String s3FileKey, String targetFilePath) {
        return s3.getObject(GetObjectRequest.builder().bucket(bucketName).key(s3FileKey).build(),
                ResponseTransformer.toFile(Paths.get(targetFilePath)));
    }

    protected File uploadToTemp(InputStream data, String s3FileKey) {
        File tempPath;
        String[] fileNameExt = s3FileKey.split("\\.");

        try {
            tempPath = File.createTempFile(fileNameExt[0], fileNameExt[1]);
            Files.copy(data, tempPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return tempPath;
    }
}
