package com.xemphim.WebXemPhim.dto;

public class EpisodeDTO {
	private String episodePath;
	
	private Integer numericalOrder;

	public String getEpisodePath() {
		return episodePath;
	}

	public void setEpisodePath(String episodePath) {
		this.episodePath = episodePath;
	}

	public Integer getNumericalOrder() {
		return numericalOrder;
	}

	public void setNumericalOrder(Integer numericalOrder) {
		this.numericalOrder = numericalOrder;
	}
}
