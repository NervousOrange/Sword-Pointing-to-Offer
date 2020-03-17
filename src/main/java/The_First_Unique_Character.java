/* 请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 */

import java.util.stream.Stream;

public class The_First_Unique_Character {
    public static void main(String[] args) {
        The_First_Unique_Character the_first_unique_character = new The_First_Unique_Character();
        the_first_unique_character.Insert('g');
        System.out.println("Expected g :" + the_first_unique_character.FirstAppearingOnce());
        the_first_unique_character.Insert('o');
        System.out.println("Expected g :" + the_first_unique_character.FirstAppearingOnce());
        the_first_unique_character.Insert('o');
        System.out.println("Expected g :" + the_first_unique_character.FirstAppearingOnce());
        the_first_unique_character.Insert('g');
        System.out.println("Expected # :" + the_first_unique_character.FirstAppearingOnce());
        the_first_unique_character.Insert('l');
        System.out.println("Expected l :" + the_first_unique_character.FirstAppearingOnce());
        the_first_unique_character.Insert('e');
        System.out.println("Expected l :" + the_first_unique_character.FirstAppearingOnce());
    }

    int[] count = new int[256];
    int index = 1;
    //Insert one char from stringStream
    public void Insert(char ch)
    {
        if (count[ch] == 0) {
            count[ch] = index++;
        } else {
            count[ch] = -1;
        }
    }
    //return the first appearence once char in current stringStream
    public char FirstAppearingOnce()
    {
        char result = '#';
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != -1 && count[i] != 0 && count[i] < temp) {
                result = (char) i;
                temp = count[i];
            }
        }
        return result;
    }
}
