package patterns.creational.factory.fac;

/**
 * @author ArnoFrost
 * @date 2020/8/5 17:31
 * @since 1.0
 */
public abstract class Machine {
    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}
