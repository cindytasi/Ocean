package videoPlay.vo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity

public class Favourites {
	
	@EmbeddedId
	private FavouritesPK fpk;

	public FavouritesPK getFpk() {
		return fpk;
	}

	public void setFpk(FavouritesPK fpk) {
		this.fpk = fpk;
	}
	
	
}