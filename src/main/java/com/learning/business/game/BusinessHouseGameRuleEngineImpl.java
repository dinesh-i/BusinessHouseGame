package com.learning.business.game;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.business.game.stakeholders.Player;
import com.learning.business.game.stakeholders.StakeHolders;
import com.learning.business.game.utils.CellLayoutPreprocessor;

public class BusinessHouseGameRuleEngineImpl implements BusinessHouseGameRuleEngine {

	private static final Logger logger = LoggerFactory.getLogger(BusinessHouseGameRuleEngineImpl.class);

	private final BusinessHouseGameValidator businessHouseGameValidator;

	public BusinessHouseGameRuleEngineImpl(BusinessHouseGameValidator businessHouseGameValidator) {
		this.businessHouseGameValidator = businessHouseGameValidator;
	}

	@Override
	public StakeHolders score(String cellLayout, String diceOutput, int numberOfPlayers) {

		businessHouseGameValidator.validate(cellLayout, diceOutput, numberOfPlayers);
		final StakeHolders stakeHolders = new StakeHolders(numberOfPlayers);

		final List<String> cellLayoutList = CellLayoutPreprocessor.preprocess(cellLayout);
		final GameCells gameCells = new GameCells(cellLayoutList, stakeHolders.getCentralBank());

		final String[] diceOutputArray = diceOutput.split(",");
		for (int index = 0; index < diceOutputArray.length; index++) {
			final int diceValue = Integer.parseInt(StringUtils.trim(diceOutputArray[index]));
			final Player player = stakeHolders.getPlayerWithId(index % numberOfPlayers);
			final int nextPositionOfPlayer = (diceValue + player.getCurrentCellNumber()) % cellLayoutList.size();
			final String nextCellType = cellLayoutList.get(nextPositionOfPlayer);
			logger.debug("Player[{}], Current Position[{}], Dice Value[{}], Next Position[{}], Next Cell Type[{}]",
					player.getId(), player.getCurrentCellNumber(), diceValue, nextPositionOfPlayer, nextCellType);
			player.setCurrentCellNumber(nextPositionOfPlayer);

			gameCells.getCell(nextCellType).process(stakeHolders.getCentralBank(), player);

		}

		return stakeHolders;
	}

}
