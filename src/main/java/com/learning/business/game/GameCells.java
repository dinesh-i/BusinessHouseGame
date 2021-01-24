package com.learning.business.game;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.learning.business.game.celltype.CellType;
import com.learning.business.game.celltype.Empty;
import com.learning.business.game.celltype.Hotel;
import com.learning.business.game.celltype.Jail;
import com.learning.business.game.celltype.Lottery;
import com.learning.business.game.stakeholders.FinancialStakeHolder;

public class GameCells {

	private final List<CellType> cells;

	public GameCells(List<String> cellLayoutList, FinancialStakeHolder centralBank) {
		final Set<String> uniqueCellTypes = cellLayoutList.stream().map(String::trim).collect(Collectors.toSet());
		cells = uniqueCellTypes.stream().map(c -> initializeCells(c, centralBank)).collect(Collectors.toList());
	}

	private CellType initializeCells(String cellType, FinancialStakeHolder centralBank) {
		if (StringUtils.equalsIgnoreCase("L", cellType))
			return new Lottery(cellType);
		if (StringUtils.equalsIgnoreCase("J", cellType))
			return new Jail(cellType);
		if (StringUtils.equalsIgnoreCase("E", cellType))
			return new Empty(cellType);
		if (StringUtils.startsWith(cellType, "H"))
			return new Hotel(cellType, centralBank);
		return null;
	}

	public CellType getCell(String id) {
		return cells.stream().filter(c -> StringUtils.equalsIgnoreCase(id, c.getId())).findFirst().orElse(null);
	}

}
