/**
 *
 * @author Philip Tsvetanov
 * @date Apr 15, 2018
 *
 */
public class Block {
    String type;
    String content;
    Boolean isPassable;

    public Block(String s)
    {
        switch (s) {
            case "dot": content = "    O    ";
            isPassable = true;
            type = "dot";
            break;
            case "empty": content = "         ";
            isPassable = true;
            type = "empty";
            break;
            case "pacman-left": content = " _ > ) ¯ ";
            type = "pacman-left";
            break;
            case "pacman-right": content = " _ ( < ¯ ";
            type = "pacman-right";
            break;
            case "pacman-up": content = "   (V)   ";
            type = "pacman-up";
            break;
            case "pacman-down": content = "   (Л)   ";
            type = "pacman-down";
            break;
            case "ghost": content = "   )ß(   ";
            type = "ghost";
            break;
            case "wall": content = "▓▓▓▓▓▓▓▓▓";
            type = "wall";
            isPassable = false;
            break;
            case "border-horiz": content = "   ===   ";
            type = "border-horiz";
            isPassable = false;
            break;
            case "border-vert": content = " ║  ║  ║ ";
            isPassable = false;
            type = "border-vert";
            break;
            
        }
    }
}
