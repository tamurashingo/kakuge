package com.github.tamurashingo.kakuge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.github.tamurashingo.kakuge.Character.Status;

public class PlayerFactory {
    
    private static final Map<Character, Map<Operation[], Character.Status>> spMap;
    
    static {
        spMap = new HashMap<Character, Map<Operation[], Character.Status>>();
        
        // 操作を逆にたどるため、逆に指定する。
        
        // RYU
        {
            Map<Operation[], Character.Status> sp = new HashMap<Operation[], Character.Status>();
            sp.put(new Operation[] {
                    Operation.PUNCH_WEAK,
                    Operation.RIGHT,
                    Operation.DOWN_RIGHT,
                    Operation.DOWN},
                    Character.Status.HADOKEN);
            sp.put(new Operation[] {
                    Operation.PUNCH_NORM,
                    Operation.RIGHT,
                    Operation.DOWN_RIGHT,
                    Operation.DOWN},
                    Character.Status.HADOKEN);
            sp.put(new Operation[] {
                    Operation.PUNCH_STRONG,
                    Operation.RIGHT,
                    Operation.DOWN_RIGHT,
                    Operation.DOWN},
                    Character.Status.HADOKEN);

            sp.put(new Operation[] {
                    Operation.PUNCH_WEAK,
                    Operation.DOWN_RIGHT,
                    Operation.DOWN,
                    Operation.RIGHT},
                    Character.Status.SHORYUKEN);
            sp.put(new Operation[] {
                    Operation.PUNCH_NORM,
                    Operation.DOWN_RIGHT,
                    Operation.DOWN,
                    Operation.RIGHT},
                    Character.Status.SHORYUKEN);
            sp.put(new Operation[] {
                    Operation.PUNCH_STRONG,
                    Operation.DOWN_RIGHT,
                    Operation.DOWN,
                    Operation.RIGHT},
                    Character.Status.SHORYUKEN);
            
            spMap.put(Character.RYU, sp);
        }
    }
    
    
    private PlayerFactory() {
    }
    
    public static Player createPlayer(Character character) {
        Player player = new Player(character, getSpecial(character));
        player.setOperationBuffer(new LinkedList<Operation>());
        player.setStatus(Status.STAND);
        return player;
    }
    
    private static Map<Operation[], Character.Status> getSpecial(Character character) {
        return spMap.get(character);
    }
}
