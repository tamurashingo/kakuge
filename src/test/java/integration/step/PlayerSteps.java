package integration.step;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.github.tamurashingo.kakuge.Character;
import com.github.tamurashingo.kakuge.Operation;
import com.github.tamurashingo.kakuge.Player;
import com.github.tamurashingo.kakuge.PlayerFactory;

public class PlayerSteps {
    
    private Player player;
    
    @Given("プレイヤーは$character")
    public void createPlayer(com.github.tamurashingo.kakuge.Character character) {
        this.player = PlayerFactory.createPlayer(character);
    }
    
    @When("$frameフレーム経過")
    public void tick(long frame) {
        this.player.tick(frame);
    }
    
    @When("レバーを$operation")
    @Alias("ボタンを$operation")
    public void operation(Operation operation) {
        this.player.operation(operation);
    }
    
    @Then("状態が$status")
    public void checkStatus(Character.Status status) {
        assertThat(this.player.getStatus(), is(status));
    }
}
