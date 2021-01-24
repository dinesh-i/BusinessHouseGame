package com.learning.business.game.celltype;

import com.learning.business.game.constants.AssetType;
import com.learning.business.game.stakeholders.FinancialStakeHolder;

public abstract class Asset extends CellType {

	private AssetType assetType;
	private FinancialStakeHolder owner;

	public Asset(String id, FinancialStakeHolder owner) {
		super(id);
		this.owner = owner;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public FinancialStakeHolder getOwner() {
		return owner;
	}

	public void setOwner(FinancialStakeHolder owner) {
		this.owner = owner;
	}

}
