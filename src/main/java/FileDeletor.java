import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import static java.util.stream.Collectors.groupingBy;

public class FileDeletor {

    public static void main(String[] args) {
        File file = new File("/Users/zhipingwang/Downloads");

        Arrays.stream(file.listFiles())
                .flatMap(f -> listFile(f,new ArrayList<File>()))
                .collect(groupingBy(File::getName))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .forEach(e-> System.out.println(e.getKey()));

    }

    public static Stream<File> listFile(File file, List<File> files) {

        if (file.isFile()) {
            files.add(file);
        } else {
            for (File mFile : file.listFiles())
                listFile(mFile, files);
        }
        return files.stream();

    }
}

