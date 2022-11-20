package trinh.vo.van.service.email;

import java.util.Map;

public interface IMailContentBuilderService {

    String buildMailContent(String templateName, Map<String, Object> properties);
}