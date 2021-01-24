package com.learning.business.game.celltype;

import com.learning.business.game.constants.BusinessHouseGameConstants;
import com.learning.business.game.stakeholders.FinancialStakeHolder;
import com.learning.business.game.stakeholders.Player;

public class Jail extends CellType {

	public Jail(String id) {
		super(id);
	}

	@Override
	public void process(FinancialStakeHolder centralBank, Player player) {
		centralBank.credit(BusinessHouseGameConstants.JAIL_FINE);
		player.debit(BusinessHouseGameConstants.JAIL_FINE);
	}

	@Override
	public Integer value() {
		return BusinessHouseGameConstants.JAIL_FINE;
	}

}
