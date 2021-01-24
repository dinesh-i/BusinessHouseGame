package com.learning.business.game.stakeholders;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.learning.business.game.celltype.Asset;
import com.learning.business.game.celltype.CellType;

public abstract class FinancialStakeHolder {

	protected final Integer id;
	protected Integer money;
	private final List<Asset> assets;

	public abstract Integer getInitialMoney();

	public FinancialStakeHolder(Integer id) {
		super();
		this.id = id;
		money = getInitialMoney();
		assets = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public Integer totalAssetValue() {
		return assets.stream().mapToInt(CellType::value).sum();
	}

	public Asset getAsset(String id) {
		return assets.stream().filter(a -> StringUtils.equalsIgnoreCase(id, a.getId())).findFirst().orElse(null);
	}

	public Integer money() {
		return money;
	}

	public Integer credit(Integer amount) {
		money += amount;
		return money;
	}

	public Integer debit(Integer amount) {
		money -= amount;
		return money;
	}

	public void addAsset(Asset asset) {
		assets.add(asset);
	}

}