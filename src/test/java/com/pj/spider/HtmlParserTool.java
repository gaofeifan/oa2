package com.pj.spider;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 *	@author		GFF
 *	@date		2017年6月9日下午3:21:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class HtmlParserTool {

/*	 public static Set<String> extracLinks(String url, LinkFilter filter) {
		  Set<String> links = new HashSet<String>();
		  try {
		   Parser parser = new Parser(url);
		   parser.setEncoding("gb2312");
		   // 过滤 <frame >标签的 filter，用来提取 frame 标签里的 src 属性
		   NodeFilter frameFilter = new NodeFilter() {
		    private static final long serialVersionUID = 1L;
		    @Override
		    public boolean accept(Node node) {
		     if (node.getText().startsWith("frame src=")) {
		      return true;
		     } else {
		      return false;
		     }
		    }
		   };
		   // OrFilter 来设置过滤 <a> 标签和 <frame> 标签
		   OrFilter linkFilter = new OrFilter(new NodeClassFilter(
		     LinkTag.class), frameFilter);
		   // 得到所有经过过滤的标签
		   NodeList list = parser.extractAllNodesThatMatch(linkFilter);
		   for (int i = 0; i < list.size(); i++) {
		    Node tag = list.elementAt(i);
		    if (tag instanceof LinkTag)// <a> 标签
		    {
		     LinkTag link = (LinkTag) tag;
		     String linkUrl = link.getLink();// URL
		     if (filter.accept(linkUrl))
		      links.add(linkUrl);
		    } else// <frame> 标签
		    {
		     // 提取 frame 里 src 属性的链接， 如 <frame src="test.html"/>
		     String frame = tag.getText();
		     int start = frame.indexOf("src=");
		     frame = frame.substring(start);
		     int end = frame.indexOf(" ");
		     if (end == -1)
		      end = frame.indexOf(">");
		     String frameUrl = frame.substring(5, end - 1);
		     if (filter.accept(frameUrl))
		      links.add(frameUrl);
		    }
		   }
		  } catch (ParserException e) {
		   e.printStackTrace();
		  }
		  return links;
		 }*/
}
