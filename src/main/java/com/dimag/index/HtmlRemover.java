package com.dimag.index;

import org.jsoup.Jsoup;

public class HtmlRemover {
	public String removeHtml(String html) {
		return Jsoup.parse(html).text();

	}
}
