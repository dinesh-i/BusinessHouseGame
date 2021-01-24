package com.learning.business.game.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CellLayoutPreprocessor {

	public static List<String> preprocess(String layout) {
		final List<String> result = new ArrayList<>();
		final String[] cellTypes = StringUtils.upperCase(layout).split(",");
		int hotelCount = 0;
		for (final String cellType : cellTypes) {
			if (StringUtils.equalsIgnoreCase("H", StringUtils.trim(cellType)))
				result.add("H" + hotelCount++);
			else
				result.add(StringUtils.trim(cellType));
		}
		return result;
	}

}