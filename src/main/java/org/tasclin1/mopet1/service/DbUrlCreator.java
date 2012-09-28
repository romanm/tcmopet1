package org.tasclin1.mopet1.service;

import java.util.List;

import org.tasclin1.mopet1.domain.Labor;
import org.tasclin1.mopet1.domain.MObject;
import org.tasclin1.mopet1.domain.Url;


public class DbUrlCreator extends DbObjMCreator {

	Url url;
	public DbUrlCreator setMtlO(Url checkitem) {
		this.url = checkitem;
		return this;
	}
	public DbUrlCreator (){
		setSql(" SELECT d FROM Url d WHERE " +
				" d.url= :url AND d.text=:text");
	}
	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void create() {
		log.info("----- 1 "+url);
		StringBuffer sqls = new StringBuffer().append("\n-- DB UPDATE BEGIN \n");
		getDbUpdate().setParamL()
		.setParam(url.getUrl())
		.setParam(url.getText());
		getDbUpdate().updateDirect(sqls);
		sqls.append("-- DB UPDATE END \n");
		log.info(sqls);
	}

	@Override
	public MObject read() {
		String sql2 = "SELECT * FROM Url " +
				" WHERE url = '"+url.getUrl() +"' "
				+" AND text='"+url.getText()+"'";
		List<Url> dL = 
			em.createNativeQuery(sql2,Labor.class).getResultList();
//			em.createQuery(sql)
//		.setParameter("checkitem",	checkitem.getCheckitem())
//		.setParameter("type",	checkitem.getType())
//		.getResultList();
		Url pvDb=null;
		if(dL.size()>0)
		{
			pvDb=dL.get(0);
		}
		return pvDb;
	}

}
