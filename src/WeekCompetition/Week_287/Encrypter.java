package WeekCompetition.Week_287;

import java.util.HashMap;
import java.util.Map;

public class Encrypter {

    /*
    参考灵神的题解:逆向思维
    加密部分比较简单,略过了
    主要是解密部分:解密部分可以先将dictionary中的每个字符串进行加密
    然后用HashMap存储每个的加密后的字符串出现的次数
    找出HashMap对应word2的项进行取值就是答案
    */
    // keys->values的映射
    Map<Character, String> key_value = new HashMap<>();
    // 存储dictionary中加密后的字符串及其出现次数
    Map<String, Integer> map = new HashMap<>();
    /*
    构造器
    */
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i = 0; i < keys.length; i++) {
            key_value.put(keys[i], values[i]);
        }
        for(String dic : dictionary) {
            // dic加密后的字符串
            String s = encrypt(dic);
            // 统计加密后s的出现的次数
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    /*
    加密部分
    */
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word1.length(); i++) {
            // 加密数据出现不合法字符情况,直接返回"",无法加密
            if(!key_value.containsKey(word1.charAt(i))) {
                return "";
            }
            sb.append(key_value.get(word1.charAt(i)));
        }
        return sb.toString();
    }

    /*
    解密部分
    */
    public int decrypt(String word2) {
        // 直接返回map中word2出现的次数就是word2解密后dictionary中符合的个数,两者之前变换可逆
        return map.getOrDefault(word2, 0);
    }

}
