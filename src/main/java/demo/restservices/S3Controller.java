package demo.restservices;

import demo.restservices.mongodb.UserService;
import demo.restservices.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class S3Controller {
    @Autowired
    S3Service s3Factory;

    @Autowired
    UserService userService;

    @PostMapping(value = "/upload",
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileKey") String fileKey) throws IOException {
        s3Factory.upload(fileKey, file);
        URI uri = URI.create("/user/dp");
        return ResponseEntity.created(uri).body("Display photo uploaded");
    }

    @GetMapping(path = "/download")
    public ResponseEntity<GetObjectResponse> downloadFile(@RequestParam(value = "fileKey") String s3FileKey,
                                                          @RequestParam(value = "filePath") String targetFilePath) {
        try {
            GetObjectResponse data = s3Factory.download(s3FileKey, targetFilePath);
            return ResponseEntity
                    .ok()
                    .header(data.contentType())
                    .build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity
                    .status(409)
                    .build();
        }
    }
}
