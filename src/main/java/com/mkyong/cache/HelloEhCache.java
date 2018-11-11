
package com.mkyong.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class HelloEhCache{

	
	
	public static void main(String[] args) {
	
		
		//1. Create a cache manager
		CacheManager cm = CacheManager.newInstance();
		
		//2. Get a cache called "cache1", declared in ehcache.xml
		Cache cache = cm.getCache("cache1");
		
		//3. Put few elements in cache
		cache.put(new Element("1","Jan"));
		cache.put(new Element("2","Feb"));
		cache.put(new Element("3","Mar"));
		cache.put(new Element("TT","Mar"));

		
		//4. Get element from cache
		Element ele = cache.get("2");
		
		List<String> ipinames=new ArrayList<>();
		String cdeRattachement="CDERATTACHEMENT";
		
		if (cache.isKeyInCache(cdeRattachement)) {
			Element elEnCache = cache.get(cdeRattachement);
			ipinames=(List<String>) elEnCache.getObjectValue();
		} else {
			 ipinames = getIpiName(cdeRattachement);
				cache.put(new Element(cdeRattachement,ipinames));
		}
		
		if (cache.isKeyInCache(cdeRattachement)) {
			Element elEnCache = cache.get(cdeRattachement);
			ipinames=(List<String>) elEnCache.getObjectValue();
		}

		
		
		

		
//	    String result = "";
//        //Map -> Stream -> Filter -> String
//        result = cache.entrySet().stream()
//                .filter(map -> "aws.amazon.com".equals(map.getValue()))
//                .map(map -> map.getValue())
//                .collect(Collectors.joining());
		
		//5. Print out the element
		String output = (ele == null ? null : ele.getObjectValue().toString());
		System.out.println(output);
		
		//6. Is key in cache?
		System.out.println(cache.isKeyInCache("TT"));
		Element eleTT = cache.get("TT");
		System.out.println(eleTT.getObjectValue().toString());
		System.out.println(cache.isKeyInCache("10"));
		
		//7. shut down the cache manager
		cm.shutdown();
		
		
	}


	private static List<String> getIpiName(String cdeRat) {
		List< String> ipinames=new ArrayList<>();
		ipinames.add("kkkkdkk");
		ipinames.add("kkkkkk");
		ipinames.add("kkkdkkk");
		ipinames.add("kkkkkddk");
		return ipinames;
	}
	

	
}