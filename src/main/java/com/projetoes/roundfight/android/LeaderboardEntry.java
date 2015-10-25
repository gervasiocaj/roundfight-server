package com.projetoes.roundfight.android;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LeaderboardEntry implements Comparable<LeaderboardEntry> {

	private String user;
	private double score;
	
	public LeaderboardEntry() {
		 this.user = "Anonymous";
		 this.score = 0;
	}
	
	public LeaderboardEntry(String user, double score) {
		if (user != null)
			this.setUser(user);
		this.setScore(score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaderboardEntry other = (LeaderboardEntry) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public int compareTo(LeaderboardEntry o) {
		return (int) (o.getScore() - this.getScore()) ;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	

}
