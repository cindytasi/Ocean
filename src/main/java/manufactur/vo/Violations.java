package manufactur.vo;

import java.util.Date;
import java.util.List;

public class Violations {

	
	
	
	private Integer violationNum;
	private List<String> violations;

public  Violations (){
}

	public Violations(Integer violationNum,List<String> violations
			) {
		super();
		this.violationNum = violationNum;
		this.violations = violations;
		
		
		
	}

	public Integer getViolationNum() {
		return violationNum;
	}

	public void setViolationNum(Integer violationNum) {
		this.violationNum = violationNum;
	}

	public List<String> getViolations() {
		return violations;
	}

	public void setViolations(List<String> violations) {
		this.violations = violations;
	}

	
}
















