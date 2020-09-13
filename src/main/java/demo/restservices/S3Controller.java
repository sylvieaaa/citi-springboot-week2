package demo.restservices;

import demo.restservices.mongodb.User;
import demo.restservices.mongodb.UserService;
import demo.restservices.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
                consumes = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE},
                produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<String> uploadFile(@RequestPart(value = "fileKey", required = false) String s3FileKey,
                                         @RequestPart(value = "filePath", required = false) String filePath,
                                         @RequestPart(value = "email", required = false) String email) throws IOException {
        User user = userService.getUser(email);
        if (user != null) {
            s3Factory.upload(s3FileKey, filePath);
            URI uri = URI.create("/user/dp");
            return ResponseEntity.created(uri).body("Display photo uploaded");
        }

        else {
            return ResponseEntity.status(403).build();
        }


    }

    @GetMapping(path = "/download")
    public ResponseEntity<GetObjectResponse> downloadFile(@RequestParam(value = "fileKey") String s3FileKey,
                                                          @RequestParam(value = "filePath") String targetFilePath)throws IOException {
        GetObjectResponse data = s3Factory.download(s3FileKey, targetFilePath);
        return ResponseEntity
                .ok()
                .body(data);
    }
}
