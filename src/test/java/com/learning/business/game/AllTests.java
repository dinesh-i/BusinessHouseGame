package com.learning.business.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BusinessHouseGameConfigurationTest.class, BusinessHouseGameRuleEngineTest.class,
		BusinessHouseGameValidatorTest.class, CellLayoutPreprocessorTest.class })
public class AllTests {

}
