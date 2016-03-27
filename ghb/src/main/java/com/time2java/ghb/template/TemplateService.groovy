package com.time2java.ghb.template

import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateException

/**
 * Created by time2die on 20.03.16.
 */

class TemplateService {

    private static final String templatePath = "src/main/resources/templatests"
    private final Configuration cfg;

    public TemplateService() {
        cfg = new Configuration()
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
    }

    public String getAskText() {
        return processTemplate("ask.ftl", null);
    }

    protected String processTemplate(String fileName, Map<String, Object> data) throws IOException, TemplateException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(bos);
        try {
            Template template = cfg.getTemplate(fileName);

            if (data == null)
                data = Collections.emptyMap();

            template.process(data, out);
            out.flush();
        } catch (Exception e) {
            throw e;
        }
        return bos.toString();
    }
}

