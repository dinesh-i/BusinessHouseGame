package com.learning.business.game;

import com.learning.business.game.stakeholders.StakeHolders;

public interface BusinessHouseGameRuleEngine {

	StakeHolders score(String cellLayout, String diceOutput, int numberOfPlayers);

}