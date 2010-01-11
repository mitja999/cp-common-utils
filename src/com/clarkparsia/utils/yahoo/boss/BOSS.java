/*
 * Copyright (c) 2005-2010 Clark & Parsia, LLC. <http://www.clarkparsia.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clarkparsia.utils.yahoo.boss;

import com.clarkparsia.utils.yahoo.boss.web.WebSearch;
import com.clarkparsia.utils.yahoo.boss.web.WebSearchResult;
import com.clarkparsia.utils.yahoo.boss.image.ImageSearch;
import com.clarkparsia.utils.yahoo.boss.image.ImageSearchResult;

import java.util.Map;

/**
 * <p>Factory for creating and running searches via the BOSS API</p>
 *
 * @author Michael Grove
 */
public class BOSS {

	/**
	 * The AppId to use for searches
	 */
	private String mKey;

	/**
	 * Searcher for image searches
	 */
	private ImageSearch mImgSearch;

	/**
	 * Searcher for web searches
	 */
	private WebSearch mWebSearch;

	/**
	 * Create a new BOSS with the given AppId
	 * @param theKey the AppId
	 */
	private BOSS(String theKey) {
		mKey = theKey;
	}

	/**
	 * Return an instance of a BOSS with the given AppId
	 * @param theKey the AppId to use for searches
	 * @return a BOSS instances
	 */
	public static BOSS instance(String theKey) {
		return new BOSS(theKey);
	}

	/**
	 * Return the searcher for conducting web searches
	 * @return the web searcher
	 */
	private WebSearch getWebSearch() {
		if (mWebSearch == null) {
			mWebSearch = WebSearch.instance(mKey);
		}

		return mWebSearch;
	}

	/**
	 * Return the searcher for conducting image searches
	 * @return the image searcher
	 */
	private ImageSearch getImageSearch() {
		if (mImgSearch == null) {
			mImgSearch = ImageSearch.instance(mKey);
		}

		return mImgSearch;
	}

	/**
	 * Perform an image search
	 * @param theTerm the search term
	 * @return the results of the search
	 * @throws BOSSException thrown if there is an error while searching
	 */
	public SearchResults<ImageSearchResult> imageSearch(String theTerm) throws BOSSException {
		return getImageSearch().search(theTerm);
	}

	/**
	 * Perform an image search
	 * @param theTerm the search term
	 * @param theParams parameters for the search.
	 * @return the results of the search
	 * @throws BOSSException thrown if there is an error while searching
	 */
	public SearchResults<ImageSearchResult> imageSearch(String theTerm, Map<String, String> theParams) throws BOSSException {
		return getImageSearch().search(theTerm, theParams);
	}

	/**
	 * Perform a web search
	 * @param theTerm the search term
	 * @return the results of the search
	 * @throws BOSSException thrown if there is an error while searching
	 */
	public SearchResults<WebSearchResult> webSearch(String theTerm) throws BOSSException {
		return getWebSearch().search(theTerm);
	}

	/**
	 * Perform a web search
	 * @param theTerm the search term
	 * @param theParams parameters for the search.
	 * @return the results of the search
	 * @throws BOSSException thrown if there is an error while searching
	 */
	public SearchResults<WebSearchResult> webSearch(String theTerm, Map<String, String> theParams) throws BOSSException {
		return getWebSearch().search(theTerm, theParams);
	}
}
