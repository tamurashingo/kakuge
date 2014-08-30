package integration.story;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import com.github.tamurashingo.kakuge.Operation;

/**
 * 文字と{@code Operation}を変換するParameterConverter
 * 
 * @author tamura shingo
 *
 */
public class OperationConverter implements ParameterConverter {
    
    private static final Map<String, Operation> opmap;
    
    static {
        opmap = new HashMap<String, Operation>();
        opmap.put("上", Operation.UP);
        opmap.put("下", Operation.DOWN);
        opmap.put("左", Operation.LEFT);
        opmap.put("右", Operation.RIGHT);
        opmap.put("左上", Operation.UP_LEFT);
        opmap.put("右上", Operation.UP_RIGHT);
        opmap.put("左下", Operation.DOWN_LEFT);
        opmap.put("右下", Operation.DOWN_RIGHT);
        
        opmap.put("弱パンチ", Operation.PUNCH_WEAK);
        opmap.put("中パンチ", Operation.PUNCH_NORM);
        opmap.put("強パンチ", Operation.PUNCH_STRONG);
        opmap.put("弱キック", Operation.KICK_WEAK);
        opmap.put("中キック", Operation.KICK_NORM);
        opmap.put("強キック", Operation.KICK_STRONG);
        
        opmap.put("コイン", Operation.COIN);
        opmap.put("スタート", Operation.START);
        
    }

    @Override
    public boolean accept(Type type) {
        return type.equals(Operation.class);
    }

    @Override
    public Object convertValue(String value, Type type) {
        return opmap.get(value);
    }
}
