package com.time2java.ghb.task;

import com.time2java.ghb.slak.GHBSlackService;
import com.time2java.ghb.template.TemplateService;

/**
 * Created by time2die on 13.03.16.
 */
public class AskGaolTask extends AbstractTask {

    private TemplateService templateService ;
    public AskGaolTask(GHBSlackService slackService, TemplateService templateService) {
        super(slackService);
        this.templateService = templateService ;
    }

    @Override
    public void start() {
        slackService.askAll(templateService.getAskText());
    }

}
