package com.learning.business.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import com.learning.business.game.stakeholders.StakeHolders;

public class BusinessHouseGameRuleEngineTest {

	private BusinessHouseGameRuleEngine businessHouseGameRuleEngine;
	private BusinessHouseGameValidator businessHouseGameValidator;

	@Before
	public void setUp() throws Exception {
		businessHouseGameValidator = new BusinessHouseGameValidatorImpl();
		businessHouseGameRuleEngine = new BusinessHouseGameRuleEngineImpl(businessHouseGameValidator);
	}

	@org.junit.Test(expected = RuntimeException.class)
	public void shouldValidateBeforeScoringOperation() {
		businessHouseGameRuleEngine.score("", "2,2", 1);
	}

	@org.junit.Test
	public void shouldCreditPlayersAndDebitBanksForLottery() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("L, L", "2,1", 1);
		assertEquals(4600, stakeHolders.getCentralBank().money().intValue());
		assertEquals(1400, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldDebitPlayersAndCreditBanksForJail() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("J, J", "2,1", 1);
		assertEquals(5300, stakeHolders.getCentralBank().money().intValue());
		assertEquals(700, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldNotCreditOrDebitForEmptyCellType() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("E, E", "2,1", 1);
		assertEquals(5000, stakeHolders.getCentralBank().money().intValue());
		assertEquals(1000, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldCreditBankAndDebitPlayerForSilverHotel() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("H", "2", 1);
		assertEquals(5200, stakeHolders.getCentralBank().money().intValue());
		assertEquals(800, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(200, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldCreditBankAndDebitPlayerForGoldHotel() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("H, E", "1, 2", 1);
		assertEquals(5300, stakeHolders.getCentralBank().money().intValue());
		assertEquals(700, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(300, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldCreditBankAndDebitPlayerForPlatinumHotel() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("H, E", "1, 2, 2", 1);
		assertEquals(5500, stakeHolders.getCentralBank().money().intValue());
		assertEquals(500, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(500, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldCreditPlayer1AndDebitPlayer2ForSilverHotel() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("H, E", "1, 1", 2);
		assertEquals(5200, stakeHolders.getCentralBank().money().intValue());
		assertEquals(850, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(200, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
		assertEquals(950, stakeHolders.getPlayerWithId(1).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(1).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldCreditPlayer1AndDebitPlayer2ForGoldHotel() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("H, E", "1, 1, 2, 2", 2);
		assertEquals(5300, stakeHolders.getCentralBank().money().intValue());
		assertEquals(900, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(300, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
		assertEquals(800, stakeHolders.getPlayerWithId(1).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(1).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldCreditPlayer1AndDebitPlayer2ForPlatinumHotel() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("H, E", "1, 1, 2, 2, 2, 2", 2);
		assertEquals(5500, stakeHolders.getCentralBank().money().intValue());
		assertEquals(1000, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(500, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
		assertEquals(500, stakeHolders.getPlayerWithId(1).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(1).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldSupportMultipleUsersAndMatchResultsOfSampleInput1() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("J,H,L,H,E,L,H,L,H,J",
				"2,2,1, 4,4,2, 4,4,2, 2,2,1, 4,4,2, 4,4,2, 2,2,1", 3);
		assertEquals(5150, stakeHolders.getCentralBank().money().intValue());
		assertEquals(1100, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(500, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
		assertEquals(600, stakeHolders.getPlayerWithId(1).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(1).totalAssetValue().intValue());
		assertEquals(1150, stakeHolders.getPlayerWithId(2).money().intValue());
		assertEquals(0, stakeHolders.getPlayerWithId(2).totalAssetValue().intValue());
	}

	@org.junit.Test
	public void shouldSupportMultipleUsersAndMatchResultsOfSampleInput2() throws Exception {
		final StakeHolders stakeHolders = businessHouseGameRuleEngine.score("J,H,L,H,E,L,H,L,H,J",
				"2,2,1, 4,2,3, 4,1,3, 2,2,7, 4,7,2, 4,4,2, 2,2,2", 3);
		assertEquals(5750, stakeHolders.getCentralBank().money().intValue());
		assertEquals(650, stakeHolders.getPlayerWithId(0).money().intValue());
		assertEquals(500, stakeHolders.getPlayerWithId(0).totalAssetValue().intValue());
		assertEquals(750, stakeHolders.getPlayerWithId(1).money().intValue());
		assertEquals(300, stakeHolders.getPlayerWithId(1).totalAssetValue().intValue());
		assertEquals(850, stakeHolders.getPlayerWithId(2).money().intValue());
		assertEquals(200, stakeHolders.getPlayerWithId(2).totalAssetValue().intValue());
	}

}
