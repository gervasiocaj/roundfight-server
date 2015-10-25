package com.projetoes.roundfight.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderboardDAO {

	private static LeaderboardDAO instance = null;

	public static LeaderboardDAO getInstance() {
		if (instance == null)
			instance = new LeaderboardDAO();
		return instance;
	}

	private List<LeaderboardEntry> list;

	public LeaderboardDAO() {
		this.list = new ArrayList<LeaderboardEntry>();
	}

	/**
	 * Retorna as dez primeiras posições do ranking (ou menos, se não houverem suficientes).
	 * @return
	 */
	public List<LeaderboardEntry> getTopEntries() {
		return list.subList(0, list.size() < 10 ? list.size() : 10);
	}
	
	/**
	 * Retorna 10 posições do ranking que envolvem o usuário e pontuações semelhantes.
	 * @param user
	 * @return
	 */
	public List<LeaderboardEntry> getEntries(String user) {
		LeaderboardEntry current = new LeaderboardEntry(user, 0d);
		if (!list.contains(current))
			return new ArrayList<LeaderboardEntry>();

		int position = list.indexOf(current);
		int fromIndex = position - 10 < 0 ? 0 : position - 10;
		int toIndex = position + 10 > list.size() ? list.size() : position + 10;

		return list.subList(fromIndex, toIndex);
	}

	/**
	 * Adiciona ou atualiza a pontuação do usuário.
	 * @param user
	 * @param points
	 */
	public void updateTopScore(String user, double points) {
		LeaderboardEntry current = new LeaderboardEntry(user, points);
		if (list.contains(current))
			list.remove(current);

		list.add(current);
		Collections.sort(list);
	}

}
