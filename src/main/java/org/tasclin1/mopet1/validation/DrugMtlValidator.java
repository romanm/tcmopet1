package org.tasclin1.mopet1.validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.tasclin1.mopet1.domain.Drug;
import org.tasclin1.mopet1.model.DrugMtl;


@Component
public class DrugMtlValidator extends MtlValidator{
	protected final Log log = LogFactory.getLog(getClass());
	public void validateSaveNewTrade(DrugMtl docMtl,Errors errors){
		Drug drugO = checkDrug(docMtl.getTradeName(),"tradeName", errors);
		docMtl.setDrugO(drugO);
	}
}
