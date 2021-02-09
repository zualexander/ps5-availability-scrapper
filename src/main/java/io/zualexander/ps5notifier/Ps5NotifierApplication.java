package io.zualexander.ps5notifier;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class Ps5NotifierApplication {

    private Log log = LogFactory.getLog(Ps5NotifierApplication.class);
    final WebClient webClient = new WebClient();

    public Ps5NotifierApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Ps5NotifierApplication.class, args);
    }

    @PostConstruct()
    public void init() throws IOException {
        log.info("Test");
        ScrappingInfo info = ScrappingInfo.builder()
            .url("https://www.amazon.com/PlayStation-5-Console/dp/B08FC5L3RG")
            .elementTextToMatch("Out of Stock")
            .build();

        HtmlPage page = webClient.getPage(info.getUrl());
        log.info(page);


    }

}
