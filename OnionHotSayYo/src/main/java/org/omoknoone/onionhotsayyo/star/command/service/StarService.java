package org.omoknoone.onionhotsayyo.star.command.service;

import java.util.List;

import org.omoknoone.onionhotsayyo.star.command.dto.StarDTO;

public interface StarService {
	void addStar(StarDTO starDTO);

	void removeStar(StarDTO starDTO);

}
