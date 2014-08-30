package integration.story;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import com.github.tamurashingo.kakuge.Character;


/**
 * 文字と{@code Character}を変換するParameterConverter
 * 
 * @author tamura shingo
 *
 */
public class CharacterConverter implements ParameterConverter {
    
    private static final Map<String, Character> plmap;
    
    static {
        plmap = new HashMap<String, Character>();
        plmap.put("RYU", Character.RYU);
    }

    @Override
    public boolean accept(Type type) {
        return type.equals(Character.class);
    }

    @Override
    public Object convertValue(String value, Type type) {
        return plmap.get(value);
    }

}
