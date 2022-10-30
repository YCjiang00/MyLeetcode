package String;

import java.util.List;

public class easy1773 {
    public static void main(String[] args) {

    }
    /**
        1773. 统计匹配检索规则的物品数量
     items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称
    */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 2;
        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        }

        int out = 0;
        for (List<String> i : items) {
            if (i.get(index).equals(ruleValue)) {
                out++;
            }
        }
        return out;
    }
}
