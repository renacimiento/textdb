package edu.uci.ics.textdb.web.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uci.ics.textdb.common.constants.DataConstants;
import edu.uci.ics.textdb.web.request.beans.FileSinkBean;
import edu.uci.ics.textdb.web.request.beans.KeywordMatcherBean;
import edu.uci.ics.textdb.web.request.beans.KeywordSourceBean;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kishorenarendran on 10/20/16.
 */
public class KeywordSourceBeanTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testDeserialization() throws IOException {
        final KeywordSourceBean keywordSourceBean = new KeywordSourceBean("operator1", "KeywordSource", "attributes", "10", "100", "keyword1", DataConstants.KeywordMatchingType.PHRASE_INDEXBASED, "datasource");
        String jsonString = "{\n" +
                "    \"operator_id\": \"operator1\",\n" +
                "    \"operator_type\": \"KeywordSource\",\n" +
                "    \"attributes\":  \"attributes\",\n" +
                "    \"limit\": \"10\",\n" +
                "    \"offset\": \"100\",\n" +
                "    \"keyword\": \"keyword1\",\n" +
                "    \"matching_type\": \"PHRASE_INDEXBASED\",\n" +
                "    \"data_source\": \"datasource\"\n" +
                "}";
        KeywordSourceBean deserializedObject = MAPPER.readValue(jsonString, KeywordSourceBean.class);
        assertEquals(keywordSourceBean.equals(deserializedObject), true);
    }
}
