package com.learning.business.game.celltype;

import com.learning.business.game.constants.AssetType;
import com.learning.business.game.constants.BusinessHouseGameConstants;
import com.learning.business.game.stakeholders.FinancialStakeHolder;
import com.learning.business.game.stakeholders.Player;

public class Hotel extends Asset {

	public Hotel(String id, FinancialStakeHolder owner) {
		super(id, owner);
	}

	@Override
	public void process(FinancialStakeHolder centralBank, Player player) {
//		TODO: Consider individual classes for different types of hotels
		if (centralBank == getOwner()) {
			setAssetType(AssetType.SILVER_HOTEL);
			centralBank.credit(BusinessHouseGameConstants.SILVER_HOTEL_VALUE);
			player.debit(BusinessHouseGameConstants.SILVER_HOTEL_VALUE);
			player.addAsset(this);
			setOwner(player);
		} else if (player == getOwner()) {
			if (AssetType.SILVER_HOTEL == getAssetType()) {
				setAssetType(AssetType.GOLD_HOTEL);
				centralBank.credit(BusinessHouseGameConstants.GOLD_HOTEL_UPGRADE_AMOUNT);
				player.debit(BusinessHouseGameConstants.GOLD_HOTEL_UPGRADE_AMOUNT);
				setValue(BusinessHouseGameConstants.GOLD_HOTEL_VALUE);
			} else if (AssetType.GOLD_HOTEL == getAssetType()) {
				setAssetType(AssetType.PLATINUM_HOTEL);
				centralBank.credit(BusinessHouseGameConstants.PLATINUM_HOTEL_UPGRADE_AMOUNT);
				player.debit(BusinessHouseGameConstants.PLATINUM_HOTEL_UPGRADE_AMOUNT);
				setValue(BusinessHouseGameConstants.PLATINUM_HOTEL_VALUE);
			}
		} else {
			if (AssetType.SILVER_HOTEL == getAssetType()) {
				getOwner().credit(BusinessHouseGameConstants.SILVER_HOTEL_RENT);
				player.debit(BusinessHouseGameConstants.SILVER_HOTEL_RENT);
			} else if (AssetType.GOLD_HOTEL == getAssetType()) {
				getOwner().credit(BusinessHouseGameConstants.GOLD_HOTEL_RENT);
				player.debit(BusinessHouseGameConstants.GOLD_HOTEL_RENT);
			} else if (AssetType.PLATINUM_HOTEL == getAssetType()) {
				getOwner().credit(BusinessHouseGameConstants.PLATINUM_HOTEL_RENT);
				player.debit(BusinessHouseGameConstants.PLATINUM_HOTEL_RENT);
			}
		}
	}

	@Override
	public Integer value() {
		if (AssetType.SILVER_HOTEL == getAssetType())
			return BusinessHouseGameConstants.SILVER_HOTEL_VALUE;
		else if (AssetType.GOLD_HOTEL == getAssetType())
			return BusinessHouseGameConstants.GOLD_HOTEL_VALUE;
		else if (AssetType.PLATINUM_HOTEL == getAssetType())
			return BusinessHouseGameConstants.PLATINUM_HOTEL_VALUE;
		return 0;
	}

}
