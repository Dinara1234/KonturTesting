package generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.Community;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommunityDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = args.length > 0 ? Integer.parseInt(args[0]) : 3;
        String filePath = args.length > 1 ? args[1] : "communities.xml";

        List<Community> communities = generateCommunities(count);
        saveAsXml(communities, new File(filePath));

        System.out.println("Сгенерировано " + count + " сообществ в файл " + filePath);
    }

    private static List<Community> generateCommunities(int count) {
        List<Community> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Random random = new Random();

            int randomDigit = random.nextInt(10);

            String randomString = String.valueOf(randomDigit);
            list.add(new Community("Community_" + randomString, "Desc" + randomString));
        }
        return list;
    }

    private static void saveAsXml(List<Community> communities, File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, communities);
    }
}
