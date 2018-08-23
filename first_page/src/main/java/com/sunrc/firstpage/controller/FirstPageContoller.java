package com.sunrc.firstpage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstPageContoller {

	private static final Logger logger = LoggerFactory.getLogger(FirstPageContoller.class);

	private static final String VIEW_FRAME = "/frame";
	private static final String VIEW_HEADER = "/header";
	private static final String VIEW_CONTENTS = "/contents";
	
	private static final String VIEW_TEST = "/test";
	
	@RequestMapping("/")
	public String index() {

		return VIEW_FRAME;
	}
	
	@RequestMapping("/header")
	public String header() {

		return VIEW_HEADER;
	}
	
	@RequestMapping("/contents/{siteGubun}")
	public String contents(Model model, HttpServletRequest request, @PathVariable String siteGubun) {

		// 참고 - Jsoup에서 제공하는 Connect 처리
		Document slrDoc = null;
		
		try {
			if (siteGubun.equals("slrclub"))
				slrDoc = Jsoup.connect("http://m.slrclub.com/bbs/zboard.php?id=best_article").get();
			else if (siteGubun.equals("bobae"))
				slrDoc = Jsoup.connect("http://m.bobaedream.co.kr/board/new_writing/best").get();
			else if (siteGubun.equals("ppomppu"))
				slrDoc = Jsoup.connect("http://m.ppomppu.co.kr/new/").get();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("href:" + slrDoc);
		
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Elements trList = null;
		
		if (siteGubun.equals("slrclub"))
		{			
			trList = slrDoc.select("ul.list li");

			for(Element article : trList)
			{
				Elements articleSub = article.select("a");
				String href = articleSub.attr("abs:href");

				Map<String, Object> multiMap = new HashMap<>();
				multiMap.put("href", href);
				multiMap.put("text", articleSub.text());
				
				logger.info("href:" + href);
				logger.info("text:" + articleSub.text());
				
				articleSub = article.select("div.article-info");
				multiMap.put("metainfo", articleSub.text());
				
				logger.info("metainfo:" + articleSub.text());
				
				list.add(multiMap);
			}
		}
		else if (siteGubun.equals("bobae"))
		{
			trList = slrDoc.select("ul.rank li");
			
			for(Element article : trList)
			{
				Elements articleSub = article.select("a");
				String href = articleSub.attr("abs:href");
				
				Map<String, Object> multiMap = new HashMap<>();
				multiMap.put("href", href);
				
				logger.info("href:" + href);
				
				articleSub = article.select("span.cont");
				multiMap.put("text", articleSub.text());
				
				logger.info("text:" + articleSub.text());
				
				articleSub = article.select("div.txt2");
				multiMap.put("metainfo", articleSub.text());
				
				logger.info("metainfo:" + articleSub.text());
				
				list.add(multiMap);
			}
		}
		else if (siteGubun.equals("ppomppu"))
		{
			trList = slrDoc.select("div#mainList li");
			
			for(Element article : trList)
			{
				Elements articleSub = article.select("a");
				String href = articleSub.attr("abs:href");
				
				if (href.indexOf("event_ppomppu") <= 0 && href.indexOf("pop_bbs") <= 0)
				{
					Map<String, Object> multiMap = new HashMap<>();
					multiMap.put("href", href);
					
					Elements title = articleSub.select("span.main_text02");
					multiMap.put("text", title.text());

					logger.info("href:" + href);
					logger.info("text:" + title.text());
					
					String metaString = "";
					Elements meta1 = articleSub.select("span.main_list_title");
					metaString += meta1.text();
					
					Elements meta2 = articleSub.select("span.main_list_name");
					metaString += meta2.text();

					Elements meta3 = articleSub.select("span.main_list_vote");
					metaString += meta3.text();
					
					multiMap.put("metainfo", metaString);
					
					logger.info("metainfo:" + articleSub.text());
				
					list.add(multiMap);
				}			
			}

		}

		model.addAttribute("multiMap", list);
		model.addAttribute("siteGubun", siteGubun);
		
		return VIEW_CONTENTS;
	}
		
	private boolean isMobile(HttpServletRequest request)
	{
		boolean retValue = false;
		
		String userAgent = request.getHeader("user-agent");
		String[] browser = {"iPhone", "iPod","Android"};
		
		for (int i = 0; i < browser.length; i++) 
		{
			if(userAgent.matches(".*"+browser[i]+".*"))
			{
				retValue = true;
				break;
			}
		}
		
		return retValue;
	}
	
	@RequestMapping("/test")
	public String test() {

		return VIEW_TEST;
	}
}
