package toy.yoo;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "F:\\data\\crawl\\root";
        String companyFile = "F:\\company\\comlist.txt";
        int numberOfCrawlers = 7;
        Set<String> comNameSet = new HashSet<String>();
        
        Scanner scanner = new Scanner(new File(companyFile));
        while (scanner.hasNextLine()) {
	        String str = scanner.nextLine();
	        comNameSet.add(str.split("|")[0]);
        }

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);


        // Instantiate the controller for this crawl.
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        // For each crawl, you need to add some seed urls. These are the first
        // URLs that are fetched and then the crawler starts following links
        // which are found in these pages
        controller.addSeed("https://www.yna.co.kr/");
//       controller.addSeed("https://www.ics.uci.edu/~welling/");
//    	controller.addSeed("https://www.ics.uci.edu/");
    	
        Map<String,List<String>> comLinkMap = new HashMap<String, List<String>>();
        
        controller.setCustomData(comLinkMap);
    	// The factory which creates instances of crawlers.
        CrawlController.WebCrawlerFactory<NewsCrawler> factory = NewsCrawler::new;
        
       
        
        // Start the crawl. This is a blocking operation, meaning that your code
        // will reach the line after this only when crawling is finished.
        controller.start(factory, numberOfCrawlers);
        
        
        Set<String> keySet =  comLinkMap.keySet();
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			System.out.println(key);
			
		}
        
        
    }
}
