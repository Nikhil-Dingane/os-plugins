package com.krishagni.openspecimen;

import org.springframework.beans.factory.InitializingBean;

import com.krishagni.catissueplus.core.common.domain.LabelTmplTokenRegistrar;

public class PluginInitializer implements InitializingBean {
     
    private LabelTmplTokenRegistrar labelTokensRegistrar;
     
    public void setLabelTokensRegistrar(LabelTmplTokenRegistrar labelTokensRegistrar) {
        this.labelTokensRegistrar = labelTokensRegistrar;
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        labelTokensRegistrar.register(new CollectionStatusToken()); 
 
    }
}