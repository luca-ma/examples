package yaml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlValidator {

	private String fileName = "";

	public static void main(String[] args) throws IOException {

		YamlValidator validator = new YamlValidator();
		validator.fileName = "D:\\Maderna\\luca\\util\\EclipseWS\\CLOUD\\NMS-NFVAgent\\conf\\vnf.template\\vnfd_nms_le.yml";
		String parsedStr = validator.readAndParseErrors(validator.fileName);

	}

	private String descriptor;

	public YamlValidator() {
		// this.descriptor = descriptor;

	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> load(String document) {
		Yaml yaml = new Yaml();
		return (Map<String, Object>) yaml.load(document);

	}

	// @SuppressWarnings("unchecked")
	// private Map<String, Object> parse(String document) {
	// Yaml yaml = new Yaml();
	// return (Map<String, Object>) yaml.parse(yaml)
	//
	// }

	// /NMS-NFVAgent/conf/vnf.template/vnfd_nms_le.yml

	String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	String readAndParseErrors(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		Integer linenum = 1;
		Yaml yaml = new Yaml();
		while (line != null) {
			try {
				yaml.load(line);

			} catch (Exception exc) {
				// exc.printStackTrace();
				System.out.println("ERR at line:" + linenum + ", ERR MSG:"
						+ exc.getMessage());
			} finally {
				linenum++;
				line = br.readLine();
			}
		}

		br.close();
		return sb.toString();

	}
}
