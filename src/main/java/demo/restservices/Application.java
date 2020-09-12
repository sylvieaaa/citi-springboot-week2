package demo.restservices;

import demo.restservices.s3.S3Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        S3Service s3Service = ctx.getBean(S3Service.class);
        s3Service.download("tick.svg", "/home/yijie/Desktop/tick.svg");
//        s3Service.upload("Week-4-Hackathon.docx", "/home/yijie/Desktop/Week 4 Hackathon.docx");
    }
}
