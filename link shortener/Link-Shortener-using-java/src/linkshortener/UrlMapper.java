package linkshortener;

import java.util.HashMap;
import java.util.Map;

public class UrlMapper {

    private final Map<String, String> urlMap;

    public UrlMapper() {
        this.urlMap = new HashMap<>();
    }

    public boolean containsShortKey(String shortKey) {
        return urlMap.containsKey(shortKey);
    }

    public String getOriginalUrl(String shortKey) {
        return urlMap.get(shortKey);
    }

    public void addMapping(String shortKey, String originalUrl) {
        urlMap.put(shortKey, originalUrl);
    }
}
