import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        // Add implementation here
        List<String> list = new ArrayList<>();
        for (Field field: object.getClass().getDeclaredFields()){
            for (Annotation annotation: field.getDeclaredAnnotations()){
                list.add(field.getName());
                break;
            }
        }

        return list.stream().toArray(String[]::new);
    }

}