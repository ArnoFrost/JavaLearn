package datastruct.heap;

/**
 * @author ArnoFrost
 * @date 2020/3/31 19:57
 * @since 1.0
 */
public class MaxHeap<Item extends Comparable<Item>> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public Item extractMax() {
        assert (count > 0);
        Item ret = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {

        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            //默认和左边交换
            int swapIndex = 2 * k;
            //如果有右子树,且左边大于右边,则和右子树比较
            if (swapIndex + 1 <= count && data[swapIndex + 1].compareTo(data[swapIndex]) > 0) {
                swapIndex++;

            }

            if (data[k].compareTo(data[swapIndex]) >= 0) {
                break;
            }
            swap(k, swapIndex);
            k = swapIndex;
        }

    }

    // 以树状打印整个堆结构
    public void treePrint() {

        if (size() >= 100) {
            System.out.println("This print function can only work for less than 100 integer");
            return;
        }

        System.out.println("The max datastruct.heap size is: " + size());
        System.out.println("Data in the max datastruct.heap: ");
        for (int i = 1; i <= size(); i++) {
            // 我们的print函数要求堆中的所有整数在[0, 100)的范围内
            assert (Integer) data[i] >= 0 && (Integer) data[i] < 100;
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println();

        int n = size();
        int maxLevel = 0;
        int numberPerLevel = 1;
        while (n > 0) {
            maxLevel += 1;
            n -= numberPerLevel;
            numberPerLevel *= 2;
        }

        int maxLevelNumber = (int) Math.pow(2, maxLevel - 1);
        int curTreeMaxLevelNumber = maxLevelNumber;
        int index = 1;
        for (int level = 0; level < maxLevel; level++) {

            String line1 = new String(new char[maxLevelNumber * 3 - 1]).replace('\0', ' ');

            int curLevelNumber = Math.min(count - (int) Math.pow(2, level) + 1, (int) Math.pow(2, level));
            boolean isLeft = true;
            for (int indexCurLevel = 0; indexCurLevel < curLevelNumber; index++, indexCurLevel++) {
                line1 = putNumberInLine((Integer) data[index], line1, indexCurLevel, curTreeMaxLevelNumber * 3 - 1, isLeft);
                isLeft = !isLeft;
            }
            System.out.println(line1);

            if (level == maxLevel - 1) {
                break;
            }

            String line2 = new String(new char[maxLevelNumber * 3 - 1]).replace('\0', ' ');
            for (int indexCurLevel = 0; indexCurLevel < curLevelNumber; indexCurLevel++) {
                line2 = putBranchInLine(line2, indexCurLevel, curTreeMaxLevelNumber * 3 - 1);
            }
            System.out.println(line2);

            curTreeMaxLevelNumber /= 2;
        }
    }

    private String putNumberInLine(Integer num, String line, int indexCurLevel, int curTreeWidth, boolean isLeft) {

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int offset = indexCurLevel * (curTreeWidth + 1) + subTreeWidth;
        assert offset + 1 < line.length();
        if (num >= 10) {
            line = line.substring(0, offset + 0) + num.toString()
                    + line.substring(offset + 2);
        } else {
            if (isLeft) {
                line = line.substring(0, offset + 0) + num.toString()
                        + line.substring(offset + 1);
            } else {
                line = line.substring(0, offset + 1) + num.toString()
                        + line.substring(offset + 2);
            }
        }
        return line;
    }

    private String putBranchInLine(String line, int indexCurLevel, int curTreeWidth) {

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int subSubTreeWidth = (subTreeWidth - 1) / 2;
        int offsetLeft = indexCurLevel * (curTreeWidth + 1) + subSubTreeWidth;
        assert offsetLeft + 1 < line.length();
        int offsetRight = indexCurLevel * (curTreeWidth + 1) + subTreeWidth + 1 + subSubTreeWidth;
        assert offsetRight < line.length();

        line = line.substring(0, offsetLeft + 1) + "/" + line.substring(offsetLeft + 2);
        line = line.substring(0, offsetRight) + "\\" + line.substring(offsetRight + 1);

        return line;
    }

}
