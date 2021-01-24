package com.learning.business.game;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.learning.business.game.utils.CellLayoutPreprocessor;

public class CellLayoutPreprocessorTest {

	@org.junit.Test
	public void shouldReplaceHotelWithUniqueIds() {
		final String layout = "L, J, H, E, H, H";
		final List<String> result = CellLayoutPreprocessor.preprocess(layout);
		assertTrue(StringUtils.equalsIgnoreCase("L", result.get(0)));
		assertTrue(StringUtils.equalsIgnoreCase("J", result.get(1)));
		assertTrue(StringUtils.equalsIgnoreCase("H0", result.get(2)));
		assertTrue(StringUtils.equalsIgnoreCase("E", result.get(3)));
		assertTrue(StringUtils.equalsIgnoreCase("H1", result.get(4)));
		assertTrue(StringUtils.equalsIgnoreCase("H2", result.get(5)));
	}

}