package linkshortener;

public class UrlExpander {

    private final UrlMapper urlMapper;
    private final String baseUrl;

    public UrlExpander(UrlMapper urlMapper, String baseUrl) {
        this.urlMapper = urlMapper;
        this.baseUrl = baseUrl;
    }

    public void expandUrl(String shortUrl) {
        String shortKey = shortUrl.replace(baseUrl, "");

        if (urlMapper.containsShortKey(shortKey)) {
            String originalUrl = urlMapper.getOriginalUrl(shortKey);
            System.out.println("Expanded URL: " + originalUrl);
        } else {
            System.out.println("URL not found.");
        }
    }
}
