package net.cominfo.digiagent.persistence.domain;

import java.io.Serializable;

public class Sequence implements Serializable {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_sequence.NAME
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private String name;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column t_da_sequence.NEXTID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private Integer nextid;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_sequence.NAME
	 * @return  the value of t_da_sequence.NAME
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_sequence.NAME
	 * @param name  the value for t_da_sequence.NAME
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column t_da_sequence.NEXTID
	 * @return  the value of t_da_sequence.NEXTID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public Integer getNextid() {
		return nextid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column t_da_sequence.NEXTID
	 * @param nextid  the value for t_da_sequence.NEXTID
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	public void setNextid(Integer nextid) {
		this.nextid = nextid;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Sequence)) {
			return false;
		}
		Sequence other = (Sequence) that;
		return this.getName() == null ? other == null : this.getName().equals(
				other.getName())
				&& this.getNextid() == null ? other == null : this.getNextid()
				.equals(other.getNextid());
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_da_sequence
	 * @ibatorgenerated  Wed Oct 06 10:54:15 CST 2010
	 */
	@Override
	public int hashCode() {
		int hash = 23;
		if (getName() != null) {
			hash *= getName().hashCode();
		}
		if (getNextid() != null) {
			hash *= getNextid().hashCode();
		}
		return hash;
	}
}