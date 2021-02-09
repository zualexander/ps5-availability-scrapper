package io.zualexander.ps5notifier;


import lombok.Builder;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Builder
@Data
public class ScrappingInfo {
    private URL url;
    private List<String> elementDescriptor;
    private String elementTextToMatch;

    public static class ScrappingInfoBuilder {
        public ScrappingInfoBuilder url(String url) throws MalformedURLException {
            this.url = new URL(url);
            return this;
        }
    }
}
