package org.tasclin1.mopet1.service;

import java.util.List;

import org.tasclin1.mopet1.domain.Day;
import org.tasclin1.mopet1.domain.MObject;


public class DbDayCreator extends DbObjMCreator {

	private Day day;

	@Override
	public void create() {
		log.info("----- 1");
		StringBuffer sqls = new StringBuffer().append("\n-- DB UPDATE BEGIN \n");
		getDbUpdate().setParamL().setParam(day.getAbs()).setParam(day.getNewtype());
		getDbUpdate().updateDirect(sqls);
		sqls.append("-- DB UPDATE END \n");
		log.info(sqls);
	}

	public DbDayCreator() {
		setSql("SELECT d FROM Day d WHERE d.abs=:abs AND d.newtype=:newtype");
	}
	@Override
	public MObject read() {
		if(day.hasAbs())
			day.setAbs(day.getAbs().replaceAll(" ", ""));
		Day pvDb=null;
		List dL = em.createQuery(getSql())
		.setParameter("abs",		day.getAbs())
		.setParameter("newtype",	day.getNewtype())
		.getResultList();
		if(dL.size()>0)
		{
			pvDb=(Day) dL.get(0);
		}
		return pvDb;
	}

//	public DbObjMCreator setMtlO(Day day) {
	public DbDayCreator setMtlO(Day day) {
		this.day=day;
		return this;
	}

	@Override
	public boolean isNull() {
		if(!day.hasAbs() && !day.hasNewtype()) return true;
		return false;
	}

	public DbDayCreator setDayAbs(Integer md) {
		day.setAbs(md.toString());
		return this;
	}

	public DbObjMCreator setDayNewtype(String string) {
		day.setNewtype(string);
		return this;
	}
}
