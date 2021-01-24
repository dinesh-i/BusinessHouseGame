package com.learning.business.game.celltype;

import com.learning.business.game.constants.BusinessHouseGameConstants;
import com.learning.business.game.stakeholders.FinancialStakeHolder;
import com.learning.business.game.stakeholders.Player;

public class Lottery extends CellType {

	public Lottery(String id) {
		super(id);
	}

	@Override
	public void process(FinancialStakeHolder centralBank, Player player) {
		centralBank.debit(BusinessHouseGameConstants.LOTTERY_MONEY);
		player.credit(BusinessHouseGameConstants.LOTTERY_MONEY);

	}

	@Override
	public Integer value() {
		return BusinessHouseGameConstants.LOTTERY_MONEY;
	}

}
