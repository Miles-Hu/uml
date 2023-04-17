package com.demoioc.插件DEMO.场景一.bean.app;

import com.demoioc.插件DEMO.场景一.bean.validate.ValidateService;
import org.springframework.stereotype.Service;

public abstract class AbsOldBean implements ValidateService {
    private ValidateService validateService;

    public ValidateService getValidateService() {
        return validateService;
    }

    public void setValidateService(ValidateService validateService) {
        this.validateService = validateService;
    }
}
