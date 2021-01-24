package com.learning.business.game.celltype;

import com.learning.business.game.stakeholders.FinancialStakeHolder;
import com.learning.business.game.stakeholders.Player;

public abstract class CellType {

	private final String id;
	private Integer value;

	public CellType(String id) {
		this.id = id;
		value = value();
	}

	public String getId() {
		return id;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public abstract Integer value();

	public abstract void process(FinancialStakeHolder centralBank, Player playerWithId);

}