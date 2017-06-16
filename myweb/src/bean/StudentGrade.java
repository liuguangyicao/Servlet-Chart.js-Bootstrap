package bean;

public class StudentGrade {
	private Integer studentId;
	private Integer integerPostNum;
	private Integer integerLoginNum;
	private Double doubleAvgGrade;
	private Double doubleGrade;
	public StudentGrade() {
	}
	public StudentGrade(Integer studentId, Integer integerPostNum, Integer integerLoginNum, Double doubleAvgGrade,
			Double doubleGrade) {
		this.studentId = studentId;
		this.integerPostNum = integerPostNum;
		this.integerLoginNum = integerLoginNum;
		this.doubleAvgGrade = doubleAvgGrade;
		this.doubleGrade = doubleGrade;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getIntegerPostNum() {
		return integerPostNum;
	}

	public void setIntegerPostNum(Integer integerPostNum) {
		this.integerPostNum = integerPostNum;
	}

	public Integer getIntegerLoginNum() {
		return integerLoginNum;
	}

	public void setIntegerLoginNum(Integer integerLoginNum) {
		this.integerLoginNum = integerLoginNum;
	}

	public Double getDoubleAvgGrade() {
		return doubleAvgGrade;
	}

	public void setDoubleAvgGrade(Double doubleAvgGrade) {
		this.doubleAvgGrade = doubleAvgGrade;
	}

	public Double getDoubleGrade() {
		return doubleGrade;
	}

	public void setDoubleGrade(Double doubleGrade) {
		this.doubleGrade = doubleGrade;
	}
	

}
