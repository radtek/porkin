package name.huangzhoujin.registration.persistence.dto;

import java.io.Serializable;
import java.util.Date;

public class CustomDto implements Serializable {

	private Integer registrationId;
	private String register;
	private String gender;
	private String education;
	private String oldLevel;
	private String newLevel;
	private String idCard;
	private String phone;
	private String workUnit;
	private String unemployedNo;
	private Date registrationDate;
	private Date startDate;
	private String areaName;
	private String locationName;
	private String postAddress;

	private static final long serialVersionUID = 1L;

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOldLevel() {
		return oldLevel;
	}

	public void setOldLevel(String oldLevel) {
		this.oldLevel = oldLevel;
	}

	public String getNewLevel() {
		return newLevel;
	}

	public void setNewLevel(String newLevel) {
		this.newLevel = newLevel;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getUnemployedNo() {
		return unemployedNo;
	}

	public void setUnemployedNo(String unemployedNo) {
		this.unemployedNo = unemployedNo;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getLocationName() {
		return locationName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((areaName == null) ? 0 : areaName.hashCode());
		result = prime * result
				+ ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result
				+ ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result
				+ ((newLevel == null) ? 0 : newLevel.hashCode());
		result = prime * result
				+ ((oldLevel == null) ? 0 : oldLevel.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((register == null) ? 0 : register.hashCode());
		result = prime
				* result
				+ ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result
				+ ((registrationId == null) ? 0 : registrationId.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((unemployedNo == null) ? 0 : unemployedNo.hashCode());
		result = prime * result
				+ ((workUnit == null) ? 0 : workUnit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomDto other = (CustomDto) obj;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (newLevel == null) {
			if (other.newLevel != null)
				return false;
		} else if (!newLevel.equals(other.newLevel))
			return false;
		if (oldLevel == null) {
			if (other.oldLevel != null)
				return false;
		} else if (!oldLevel.equals(other.oldLevel))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (register == null) {
			if (other.register != null)
				return false;
		} else if (!register.equals(other.register))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (registrationId == null) {
			if (other.registrationId != null)
				return false;
		} else if (!registrationId.equals(other.registrationId))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (unemployedNo == null) {
			if (other.unemployedNo != null)
				return false;
		} else if (!unemployedNo.equals(other.unemployedNo))
			return false;
		if (workUnit == null) {
			if (other.workUnit != null)
				return false;
		} else if (!workUnit.equals(other.workUnit))
			return false;
		return true;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
