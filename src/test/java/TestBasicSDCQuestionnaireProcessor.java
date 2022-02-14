import com.ibm.fhir.model.generator.exception.FHIRGeneratorException;
import com.ibm.fhir.model.parser.exception.FHIRParserException;
import com.ibm.fhir.model.patch.exception.FHIRPatchException;
import com.ibm.fhir.path.exception.FHIRPathException;
import gov.va.idiq.himms2022.BasicSDCQuestionnaireProcessor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestBasicSDCQuestionnaireProcessor {
    @Test
    public void transformTest() throws IOException, FHIRParserException, FHIRPathException, FHIRPatchException, FHIRGeneratorException {
        String questionnaireFilePath = "src/test/fixtures/sdc-questionnaire-sample.json";
        String questionnaireResponseFilePath = "src/test/fixtures/sdc-questionnaire-response-sample.json";
        String questionnaireString = new String(Files.readAllBytes(Paths.get(questionnaireFilePath)));
        String questionnaireResponseString = new String(Files.readAllBytes(Paths.get(questionnaireResponseFilePath)));
        String transformedQuestionnaireResponse = BasicSDCQuestionnaireProcessor.transform(questionnaireString, questionnaireResponseString);
        System.out.println(transformedQuestionnaireResponse);
    }
}
