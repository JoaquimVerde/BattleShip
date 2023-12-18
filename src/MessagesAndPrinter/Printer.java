package MessagesAndPrinter;

import Battleship.Battleship;
import Battleship.ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class Printer {

    public static String createMap(Battleship.PlayerHandler playerHandler) {

        List<List<String>> map = playerHandler.getMyMap();
        List<List<String>> mapOpp = playerHandler.getOppMap();

        StringBuilder finalMap = new StringBuilder();

        for (int i = 0; i < map.size(); i++) {
            List<String> line = map.get(i);
            for (int j = 0; j < line.size(); j++) {
                finalMap.append(line.get(j)).append(" ");
            }
            finalMap.append("\t\t");
            List<String> lineOpp = mapOpp.get(i);
            for (int j = 0; j < lineOpp.size(); j++) {
                finalMap.append(lineOpp.get(j)).append(" ");
            }
            finalMap.append("\n");
        }
        return finalMap.toString();
    }

    public static String createShipString(Battleship.PlayerHandler playerHandler) {
        List<String> shipsText = createShipTextArray(playerHandler.getCharacter().getPlayerShips());
        StringBuilder messageToPrint = new StringBuilder();

        for (int i = 0; i < shipsText.size(); i++) {
            messageToPrint.append(i).append(" - ").append(shipsText.get(i)).append("\n");
        }
        return messageToPrint.toString();
    }

    private static List<String> createShipTextArray(List<Ship> playerShips) {
        List<String> ships = new ArrayList<>();
        for (Ship ship : playerShips) {
            ships.add(getShipString(ship));
        }
        return ships;
    }

    private static String getShipString(Ship ship) {
        return switch (ship.getType()) {
            case BIG_SHIP -> ship.isRotated() ? TextShips.BIG_SHIP_V : TextShips.BIG_SHIP_H;
            case CARRIER -> ship.isRotated() ? TextShips.CARRIER_V : TextShips.CARRIER_H;
            case SUBMARINE -> ship.isRotated() ? TextShips.SUBMARINE_V : TextShips.SUBMARINE_H;
            case DESTROYER -> ship.isRotated() ? TextShips.DESTROYER_V : TextShips.DESTROYER_H;
            case CRUISER -> ship.isRotated() ? TextShips.CRUISER_V : TextShips.CRUISER_H;


        };
    }
}