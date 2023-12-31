package Battleship.Character;

import Battleship.Battleship;
import Battleship.ships.Ship;
import Exceptions.InvalidPositionException;
import Exceptions.InvalidSyntaxException;
import Exceptions.PlayerNotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    protected List<Ship> playerShips = new ArrayList<>();

    /**
     * Performs a special action in the game.
     *
     * @param playerHandler The player executing the action.
     * @param game          The Battleship game instance.
     * @throws PlayerNotFoundException  If a player is not found.
     * @throws InvalidSyntaxException   If there is an invalid syntax in the action.
     * @throws InvalidPositionException If there is an invalid position in the action.
     */
    public abstract void special(Battleship.PlayerHandler playerHandler, Battleship game) throws PlayerNotFoundException, InvalidSyntaxException, InvalidPositionException;

    /**
     * Retrieves the list of ships owned by the player.
     *
     * @return A list of Ship objects representing the player's fleet.
     */

    public List<Ship> getPlayerShips() {
        return playerShips;
    }
}
