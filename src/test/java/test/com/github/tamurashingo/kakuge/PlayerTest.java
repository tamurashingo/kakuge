package test.com.github.tamurashingo.kakuge;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.github.tamurashingo.kakuge.Character;
import com.github.tamurashingo.kakuge.Operation;
import com.github.tamurashingo.kakuge.Player;
import com.github.tamurashingo.kakuge.PlayerFactory;

public class PlayerTest {

    @Test
    public void testHADOKEN() {
        Player ryu = PlayerFactory.createPlayer(Character.RYU);
        ryu.tick(0);
        ryu.operation(Operation.DOWN);
        ryu.tick(1);
        ryu.operation(Operation.DOWN_RIGHT);
        ryu.tick(2);
        ryu.operation(Operation.RIGHT);
        ryu.tick(3);
        ryu.operation(Operation.PUNCH_WEAK);
        ryu.tick(4);
        
        assertThat(ryu.getStatus(), is(Character.Status.HADOKEN));
    }

}
