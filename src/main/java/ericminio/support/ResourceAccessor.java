package ericminio.support;

public class ResourceAccessor {

    public static String pdfWithName(String name) {
        return ResourceAccessor.class.getClassLoader().getResource(name + ".pdf").getFile();
    }
}
