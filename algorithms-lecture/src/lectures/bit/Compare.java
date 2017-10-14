package src.lectures.bit;
/** 
 * @author Yu
 * @date 2017年9月1日
 * 
 * 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。
 * 若两数相同，返回任意一个。给定两个整数a和b，请返回较大的数。
 *
 * 测试样例：
 * 1,2
 * 返回：2
 */
public class Compare {

	public int getMax(int a, int b) {
        int sa = sign(a); //a的符号，sa==1表示a为非负数，sa==0表示a为负数
        int sb = sign(b);
        int sc = sign(a - b);

        int difsign = sa ^ sb;
        int samesign = flip(difsign);

        int ra = difsign * a + samesign * sc;
        int rb = flip(ra);

        return ra * a + rb * b;
    }

    private int sign(int num) {
        return flip((num >> 31) & 1);
    }

    private int flip(int i) {
        return i ^ 1;
    }
}
