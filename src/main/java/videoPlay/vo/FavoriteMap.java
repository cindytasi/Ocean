package videoPlay.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import admin.vo.Member;


@Entity

public class FavoriteMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mapId;
	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;
	@ManyToOne
	@JoinColumn(name = "attractionId")
	private Attraction attraction;
	private Date lastModifiedDate;
	
	public FavoriteMap() {
		
	}

	public Integer getMapId() {
		return mapId;
	}

	public Member getMember() {
		return member;
	}

	public Attraction getAttraction() {
		return attraction;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
