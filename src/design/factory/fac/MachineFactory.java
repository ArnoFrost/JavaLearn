package design.factory.fac;

/**
 * @author ArnoFrost
 * @date 2020/8/5 17:34
 * @since 1.0
 */
public class MachineFactory {

    public static final String TYPE_PC = "pc";
    public static final String TYPE_SERVER = "server";

    public Machine getMachine(String type, String ram, String hdd, String cpu) {
        switch (type) {
            case TYPE_PC:
                return new PC(ram, hdd, cpu);
            case TYPE_SERVER:
                return new Server(ram, hdd, cpu);
            default:
                break;
        }
        return null;
    }
}
