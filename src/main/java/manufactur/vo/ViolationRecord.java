package manufactur.vo;
import java.util.Date;

public class ViolationRecord {

	private Integer recordNum;
	private Integer comId;
	private Integer violationId;
	private Date creatDate;

	
	
	public ViolationRecord(){
	}
		public ViolationRecord(Integer recordNum, Integer comId, Integer violationId, Date creatDate
				
				) {
			super();
			this.recordNum = recordNum;
			this.comId = comId;
			this.violationId = violationId;
			this.creatDate = creatDate;
			
			
		}

		public Integer getRecordNum() {
			return recordNum;
		}

		public void setRecordNum(Integer recordNum) {
			this.recordNum = recordNum;
		}

		public Integer getComId() {
			return comId;
		}

		public void setComId(Integer comId) {
			this.comId = comId;
		}

		public Integer getViolationId() {
			return violationId;
		}

		public void setViolationId(Integer violationId) {
			this.violationId = violationId;
		}

		public Date getCreatdate() {
			return creatDate;
		}

		public void setCreatdate(Date creatDate) {
			this.creatDate = creatDate;
		}
		
		
	}
	
	

