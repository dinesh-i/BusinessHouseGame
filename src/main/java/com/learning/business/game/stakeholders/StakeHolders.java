package com.learning.business.game.stakeholders;

import java.util.ArrayList;
import java.util.List;

public class StakeHolders {

	private final CentralBank centralBank;
	private final List<Player> players;

	public StakeHolders(int numberOfPlayers) {
		centralBank = new CentralBank(numberOfPlayers);
		players = new ArrayList<>();
		for (int index = 0; index < numberOfPlayers; index++)
			players.add(new Player(index));
	}

	public FinancialStakeHolder getCentralBank() {
		return centralBank;
	}

	public Player getPlayerWithId(int id) {
		return players.stream().filter(p -> (p.getId() == id)).findFirst().orElse(null);
	}

}
