package me.ticster.cli.Arguments;
import java.util.List;
import java.util.Arrays;


public enum ArgsEnum {
    HELP("-h", "-help"),
    CALC("-c", "-calc"),
    DRAW("-d", "-draw"),
    UNKNOWN("");


    private final List<String> aliases;

    ArgsEnum(String... aliases) {
        this.aliases = Arrays.asList(aliases);
    }

    public Boolean matches(String arg) {
        return aliases.contains(arg.toLowerCase());
    }

    public static ArgsEnum fromArgs(String arg) {
        for(ArgsEnum e : values()) {
            if(e.matches(arg)) {
                return e;
            }
        }
        return UNKNOWN;
    }

}
