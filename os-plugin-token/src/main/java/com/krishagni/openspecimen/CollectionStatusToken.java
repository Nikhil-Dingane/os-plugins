package com.krishagni.openspecimen;

import com.krishagni.catissueplus.core.biospecimen.domain.Specimen;
import com.krishagni.catissueplus.core.common.domain.AbstractLabelTmplToken;
import com.krishagni.catissueplus.core.common.domain.LabelTmplToken;

public class CollectionStatusToken extends AbstractLabelTmplToken implements LabelTmplToken{

	@Override
	public String getName() {
		return "COLL_STS";
	}

	@Override
	public String getReplacement(Object object) {
        Specimen specimen = (Specimen)object;
		return specimen.getCollectionStatus();
	}

}
