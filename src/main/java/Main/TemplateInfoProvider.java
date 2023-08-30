package Main;

import java.util.LinkedHashMap;
import java.util.Map;

public class TemplateInfoProvider {
    private static Map<String, Template> templateInfo = null;


    public static Map<String, Template> getInfo()
    {
        if (templateInfo == null) {
            templateInfo = new LinkedHashMap<String, Template>();
            templateInfo.put("PlatinumOwnChoice", new Template("PlatinumOwnChoice", 595, 846, 595, 684,
                    937, 684, 56, 34, 31, -0.61f, 38));

            templateInfo.put("GoldOwnChoice", new Template("GoldOwnChoice", 595, 846, 595, 684,
                    937, 684, 56, 34, 31, -0.61f, 38));

            templateInfo.put("SilverOwnChoice", new Template("SilverOwnChoice", 595, 846, 595, 684,
                    937, 684, 56, 34, 31, -0.61f, 38));

            templateInfo.put("BronzeOwnChoice", new Template("BronzeOwnChoice", 595, 849, 598, 687,
                    937, 687, 56, 34, 31, -0.61f, 38));

            templateInfo.put("WellDoneOwnChoice", new Template("WellDoneOwnChoice", 595, 846, 595, 684,
                    937, 684, 56, 34, 31, -0.61f, 38));

            templateInfo.put("PlatinumCustom", new Template("PlatinumCustom", 595, 846,595, 674,
                    937, 674,  56, 39, 39, -0.61f, 38));

            templateInfo.put("GoldCustom", new Template("GoldCustom", 595, 846,595, 674,
                    937, 674,  56, 39, 39, -0.61f, 38));

            templateInfo.put("SilverCustom", new Template("SilverCustom", 595, 846,595, 674,
                    937, 674,  56, 39, 39, -0.61f, 38));

            templateInfo.put("BronzeCustom", new Template("BronzeCustom", 595, 846,595, 674,
                    937, 674,  56, 39, 39, -0.61f, 38));

            templateInfo.put("WellDoneCustom", new Template("WellDoneCustom", 595, 846,595, 671,
                    937, 671,  56, 39, 39, -0.61f, 38));

            templateInfo.put("CertWithTeach", new Template("CertWithTeach", 595, 792,-50, -50,
                    595, 630,  48, 36, 36, -0.61f, 38));

            templateInfo.put("CertNoTeach", new Template("CertNoTeach", 595, 754,-50, -50,
                    595, 630,  48, 36, 36, -0.61f, 38));

            templateInfo.put("Clear", new Template("Clear", 595, 846, 595, 684,
                    937, 684, 56, 34, 31, -0.61f, 38));



        }

        return templateInfo;

    }
}
