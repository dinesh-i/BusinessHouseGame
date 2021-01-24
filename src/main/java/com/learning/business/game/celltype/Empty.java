package com.learning.business.game.celltype;

import com.learning.business.game.constants.BusinessHouseGameConstants;
import com.learning.business.game.stakeholders.FinancialStakeHolder;
import com.learning.business.game.stakeholders.Player;

public class Empty extends CellType {

	public Empty(String id) {
		super(id);
	}

	@Override
	public void process(FinancialStakeHolder centralBank, Player playerWithId) {
		return;
	}

	@Override
	public Integer value() {
		return BusinessHouseGameConstants.EMPTY_CELL_VALUE;
	}

}
