package com.ty.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Observation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Oid;
	private String dname;
	private String r_Observation;
	@ManyToOne
	@JoinColumn
	private Encounter encounter;
	public int getOid() {
		return Oid;
	}
	public void setEid(int Oid) {
		this.Oid = Oid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getR_Observation() {
		return r_Observation;
	}
	public void setR_Observation(String r_Observation) {
		this.r_Observation = r_Observation;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

}
