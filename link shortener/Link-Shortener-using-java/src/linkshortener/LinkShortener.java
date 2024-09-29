package linkshortener;

import java.util.Scanner;

public class LinkShortener {

    private final UrlMapper urlMapper;
    private final ShortKeyGenerator keyGenerator;
    private final UrlExpander urlExpander;

    public LinkShortener() {
        this.urlMapper = new UrlMapper();
        this.keyGenerator = new ShortKeyGenerator();
        this.urlExpander = new UrlExpander(urlMapper, "http://short.link/");
    }

    public String shortenUrl(String originalUrl) {
        String shortKey = keyGenerator.generateShortKey(originalUrl);

        if (urlMapper.containsShortKey(shortKey)) {
            System.out.println("Short URL already exists for the given long URL.");
            return urlMapper.getOriginalUrl(shortKey);
        }

        urlMapper.addMapping(shortKey, originalUrl);
        return "http://short.link/" + shortKey;
    }

    public void expandUrl(String shortUrl) {
        urlExpander.expandUrl(shortUrl);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand Short URL");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the URL to shorten:");
                    String originalUrl = scanner.nextLine();
                    String shortUrl = shortenUrl(originalUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;
                case 2:
                    System.out.println("Enter the short URL to expand:");
                    String shortUrlToExpand = scanner.nextLine();
                    expandUrl(shortUrlToExpand);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
