package Main;

import java.util.LinkedHashMap;
import java.util.Map;

public class TemplateInfoProvider {
    private static Map<String, Template> templateInfo = null;


    public static Map<String, Template> getInfo()
    {
        if (templateInfo == null) {
            templateInfo = new LinkedHashMap<String, Template>();
            templateInfo.put("PlatinumOwnChoice", new Template("PlatinumOwnChoice", 600, 820, 600, 695,
                    600, 550, 57, 31, 34, -0.61f, 38));

            templateInfo.put("GoldOwnChoice", new Template("GoldOwnChoice", 600, 820, 600, 695,
                    600, 550, 57, 31, 34, -0.61f, 38));

            templateInfo.put("SilverOwnChoice", new Template("SilverOwnChoice", 600, 820, 600, 695,
                    600, 550, 57, 31, 34, -0.61f, 38));

            templateInfo.put("BronzeOwnChoice", new Template("BronzeOwnChoice", 600, 820, 600, 695,
                    600, 550, 57, 31, 34, -0.61f, 38));

            templateInfo.put("WellDoneOwnChoice", new Template("WellDoneOwnChoice", 600, 820, 600, 695,
                    600, 550, 57, 31, 34, -0.61f, 38));

            templateInfo.put("PlatinumCustom", new Template("PlatinumCustom", 600, 820, 600, 685,
                    600, 560, 57, 34, 34, -0.61f, 38));

            templateInfo.put("GoldCustom", new Template("GoldCustom", 600, 820, 600, 685,
                    600, 560, 57, 34, 34, -0.61f, 38));

            templateInfo.put("SilverCustom", new Template("SilverCustom", 600, 820, 600, 685,
                    600, 560, 57, 34, 34, -0.61f, 38));

            templateInfo.put("BronzeCustom", new Template("BronzeCustom", 600, 820, 600, 685,
                    600, 560, 57, 34, 34, -0.61f, 38));

            templateInfo.put("WellDoneCustom", new Template("WellDoneCustom", 600, 820, 600, 685,
                    600, 560, 57, 34, 34, -0.61f, 38));

            templateInfo.put("CertWithTeach", new Template("CertWithTeach", 600, 820, 600, 685,
                    600, 560, 51, 34, 34, -0.61f, 38));

            templateInfo.put("CertNoTeach", new Template("CertNoTeach", 600, 820, 600, 685,
                    600, 560, 51, 34, 34, -0.61f, 38));

            templateInfo.put("Clear", new Template("Clear", 600, 820, 600, 685,
                    600, 560, 57, 34, 34, -0.61f, 38));

            templateInfo.put("Rachmaninoff", new Template("Rachmaninoff", 600, 775, 600, 695,
                    600, 605, 57, 31, 42, -0.61f, 38));


        }

        return templateInfo;

    }
}
